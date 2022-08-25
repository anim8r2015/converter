package com.anthony.converter.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TemperatureServiceTest {

    @InjectMocks
    private TemperatureService temperatureService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(TemperatureServiceTest.class);
    }

    @Test
    public  void when_degreesInFahrenheitSpecified_expectConversionToCelsius() {
        // conversion is (value - 32) / 1.8 then rounded up to two decimal places
        assertEquals(9.5, temperatureService.convertToMetric(49.1));
    }

    @Test
    public  void when_degreesInCelsiusSpecified_expectConversionToFahrenheit() {
        // conversion is (value x 1.8) + 32 then rounded up to two decimal places
        assertEquals(72.5, temperatureService.convertToImperial(22.5));
    }
}
