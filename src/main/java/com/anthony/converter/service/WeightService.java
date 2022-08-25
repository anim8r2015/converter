package com.anthony.converter.service;

import com.anthony.converter.service.converter.Converter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WeightService implements Converter {

    @Override
    public double convertToMetric(final double fromValue) {
        return Precision.round(fromValue / 2.205, 2);
    }

    @Override
    public double convertToImperial(final double fromValue) {
        return Precision.round(fromValue * 2.205, 2);
    }
}
