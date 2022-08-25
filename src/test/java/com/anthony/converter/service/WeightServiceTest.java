package com.anthony.converter.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class WeightServiceTest {

    @InjectMocks
    private WeightService weightService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(WeightServiceTest.class);
    }

    @Test
    public void when_convertingAWeightInKilogram_expect_equivalentWeightInPound() {
        assertEquals(16.54, weightService.convertToImperial(7.5));
    }

    @Test
    public void when_convertingAWeightInPound_expect_equivalentWeightInKilogram() {
        assertEquals(5.53, weightService.convertToMetric(12.2));
    }

}
