package com.anthony.converter.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AreaServiceTest {

    @InjectMocks
    private AreaService areaService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(AreaServiceTest.class);
    }

    @Test
    public void when_convertingHectareToAcre_expect_success() {
        // conversion is multiply by 2.47105
        assertEquals(areaService.convertToImperial(5.9), 14.58);
    }

    @Test
    public void when_convertingAcreToHectare_expect_success() {
        // conversion is divide by 2.47105
        assertEquals(areaService.convertToMetric(29.7), 12.02);
    }
}
