package com.anthony.converter.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LengthServiceTest {

    @InjectMocks
    private LengthService lengthService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(LengthServiceTest.class);
    }

    @Test
    public void given_aMileValue_when_convertingToMetric_expect_theCorrectKilometerEquivalent() {
        // conversion is multiply by 1.609
        assertEquals(37.17, lengthService.convertToMetric(23.1));
    }

    @Test
    public void given_aKilometerValue_when_convertingToImperial_expect_theCorrectMileEquivalent() {
        // conversion is divide by 1.609
        assertEquals(69.51, lengthService.convertToMetric(43.2));
    }
}
