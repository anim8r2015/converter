package com.anthony.converter.service;

import com.anthony.converter.service.converter.Converter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VolumeService implements Converter {

    /**
     * This function is used to convert volume from Imperial (Gallon) into Metric (Litre)
     *
     * Disclaimer:
     * The formula used was taken from Google's Home Page and may defer slightly to more accurate measurements
     *
     * @param gallonValue a temperature in Imperial unit (Gallon)
     * @return a Metric unit (Litre) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToMetric(final double gallonValue) {
        return Precision.round(gallonValue * 4.546, 2);
    }

    /**
     * This function is used to convert volume from Metric (Litre) into Imperial (Gallon)
     *
     * Disclaimer:
     * The formula used was taken from Google's Home Page and may defer slightly to more accurate measurements
     *
     * @param litreValue a temperature in Metric unit (Litre)
     * @return an Imperial unit (Gallon) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToImperial(final double litreValue) {
        return Precision.round(litreValue / 4.546, 2);
    }
}
