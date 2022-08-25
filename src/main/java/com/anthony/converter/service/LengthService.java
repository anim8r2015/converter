package com.anthony.converter.service;

import com.anthony.converter.repository.ConverterRepository;
import com.anthony.converter.service.converter.Converter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LengthService implements Converter {


    /**
     * This function is used to convert length from Imperial (Mile) into Metric (Kilometer)
     *
     * Disclaimer:
     * The formula used was taken from Google's Home Page and may defer slightly to more accurate measurements
     *
     * @param mileValue a length in Imperial unit (Mile)
     * @return a Metric unit (Kilometer) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToMetric(final double mileValue) {
        return Precision.round(mileValue * 1.609, 2);
    }

    /**
     * This function is used to convert length from Metric (Kilometer) into Imperial (Mile)
     *
     * Disclaimer:
     * The formula used was taken from Google's Home Page and may defer slightly to more accurate measurements
     *
     * @param kilometerValue a length in Metric unit (Kilometer)
     * @return an Imperial unit (Mile) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToImperial(final double kilometerValue) {
        return Precision.round(kilometerValue / 1.609, 2);
    }
}