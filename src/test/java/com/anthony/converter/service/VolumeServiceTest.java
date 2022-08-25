package com.anthony.converter.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class VolumeServiceTest {

    @InjectMocks
    private VolumeService volumeService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(VolumeServiceTest.class);
    }

    @Test
    public void when_convertingLitreToGallon_expect_correctValue() {
        // conversion is divide by 4,546
        assertEquals(6.40, volumeService.convertToImperial(29.1));
    }

    @Test
    public void when_convertingGallonLitre_expect_correctValue() {
        // conversion is multiply by 4,546
        assertEquals(73.19, volumeService.convertToMetric(16.1));
    }
}
