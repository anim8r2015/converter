package com.anthony.converter.service;

import com.anthony.converter.service.converter.Converter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AreaService implements Converter {

    /**
     * This function is used to convert area from Imperial (Acre) into Metric (Hectare).
     *
     * Disclaimer:
     * The formula used was taken from Google's Home Page and may defer slightly to more accurate measurements
     *
     * @param acreValue an area in Imperial unit (Acre)
     * @return a Metric unit (Hectare) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToMetric(final double acreValue) {
        return Precision.round(acreValue / 2.471, 2);
    }

    /**
     * This function is used to convert area from Metric (Hectare) into Imperial (Acre)
     *
     * Disclaimer:
     * The formula used was taken from Google's Home Page and may defer slightly to more accurate measurements
     *
     * @param hectareValue an area in Metric unit (Hectare)
     * @return an Imperial unit (Acre) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToImperial(final double hectareValue) {
        return Precision.round(hectareValue * 2.471, 2);
    }
}
