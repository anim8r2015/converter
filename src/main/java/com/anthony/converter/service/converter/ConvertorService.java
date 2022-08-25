package com.anthony.converter.service.converter;

import com.anthony.converter.entity.ConversionEntity;
import com.anthony.converter.model.Conversion;
import com.anthony.converter.repository.ConverterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ConvertorService {

    private final ConvertorFactory convertorFactory;


    private final ConverterRepository converterRepository;

    public ConvertorService(final ConvertorFactory convertorFactory, ConverterRepository converterRepository) {
        this.convertorFactory = convertorFactory;
        this.converterRepository = converterRepository;
    }

    /**
     * To convert <code>inputValue</code> of any known type (<code>ConversionType</code>) of measurements between
     * imperial and metric based on the type of system.
     *
     * @param measurement a known type of measurement eg. temperature, area, length etc
     * @param toSystem the type to be converted to, either imperial or metric
     * @param inputValue the number of units to convert
     *
     * @return the equivalent value of the converted unit of measurement
     *
     * @throws RuntimeException where an unknown output unit (neither Imperial nor Metric) has been requested for
     * conversion at runtime
     * @throws IllegalArgumentException where the string values of measurement and/or system is not a known type
     */


    public ResponseEntity<String> convert(final String measurement, final String toSystem, final Double inputValue)
            throws IllegalArgumentException {
        Double convertedValue;
        HttpStatus status;
        //check that required values are submitted
        if (inputValue != null && measurement != null && toSystem != null) {

            try {
                Converter converter = this.getConvertor(measurement);

                switch (this.getSystemToConvertInto(toSystem)) {
                    case METRIC:
                        convertedValue = converter.convertToMetric(inputValue);
                        break;
                    case IMPERIAL:
                        convertedValue = converter.convertToImperial(inputValue);
                        break;
                    default:
                        throw new RuntimeException("Unknown Unit Type, the accepted inputs are "  +
                                SystemType.METRIC.name() + " and " + SystemType.IMPERIAL.name());
                }

                status = HttpStatus.OK;
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }

        } else {
            convertedValue = null;
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(String.valueOf(convertedValue), status);
    }

    private Converter getConvertor(final String measurement) {
        Converter converter;

        try {
            converter = convertorFactory.getConvertor(ConversionType.valueOf(measurement.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Conversion type does not exist, available are: [" +
                    Arrays.stream(ConversionType.values()).map(ConversionType::name)
                            .collect(Collectors.joining(", ")) + "]");
        }

        return converter;
    }

    private SystemType getSystemToConvertInto(final String system) throws IllegalArgumentException {
        SystemType systemType;

        try {
            systemType = SystemType.valueOf(system.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valid systems are system such as [" +
                    SystemType.METRIC.name() + "] or [" + SystemType.IMPERIAL.name() + "]");
        }

        return systemType;
    }

    public ResponseEntity<List<String>> getMeasurements() {
        return new ResponseEntity<>(Arrays.stream(ConversionType.values()).map(ConversionType::name).collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<List<String>> getSiUnits() {
        return new ResponseEntity<>(Arrays.stream(SystemType.values()).map(SystemType::name).collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<String> addConversion(Conversion conversion)
            throws IllegalArgumentException {
        Double convertedValue = null;
        HttpStatus status;

        //check that required values are submitted
        if (conversion.getMeasurement() != null && conversion.getSystem() != null && conversion.getFactor()==0) {
            ModelMapper mapper = new ModelMapper();
            try {

                ConversionEntity conversionEntity = mapper.map(conversion,ConversionEntity.class);


                List<ConversionEntity> conversionEntities = converterRepository.findAll();

                //check if system exists
                Optional<ConversionEntity> conversionOptional = conversionEntities.stream()
                        .filter(c->c.getSystem().equalsIgnoreCase(conversionEntity.getSystem())
                                || c.getMeasurement().equalsIgnoreCase(conversionEntity.getMeasurement())

                        ).findFirst();
                
                if(conversionOptional.isEmpty()){
                    converterRepository.save(conversionEntity);
                } else {
                    convertedValue = null;
                    status = HttpStatus.BAD_REQUEST;
                    throw new IllegalArgumentException("System or Measurement already exists!");
                }
                
                status = HttpStatus.OK;
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }

        } else {
            convertedValue = null;
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(String.valueOf(convertedValue), status);
    }

}
