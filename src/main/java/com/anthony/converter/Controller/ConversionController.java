package com.anthony.converter.Controller;

import com.anthony.converter.model.Conversion;
import com.anthony.converter.service.converter.ConvertorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Converter", description = "Converter API - This Resource provides/exposes resources under ConversionController")
@RestController
@RequestMapping(value = "/convert")
public class ConversionController {

    private final ConvertorService convertorService;

    @Autowired
    public ConversionController(final ConvertorService convertorService) {
        this.convertorService = convertorService;
    }

    @GetMapping("/{measurement}/{toSystem}/{value}")
    public ResponseEntity<String> convert(@PathVariable("measurement") final String measurement, @PathVariable("toSystem") final String toSystem, @PathVariable("value") final Double value) {
        return convertorService.convert(measurement, toSystem, value);
    }

    @GetMapping("/measurements")
    public ResponseEntity<List<String>> getMeasurements() {
        return convertorService.getMeasurements();
    }

    @GetMapping("/si-units")
    public ResponseEntity<List<String>> getSiUnits() {
        return convertorService.getSiUnits();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addConversion(@RequestBody Conversion conversion) {
        return convertorService.addConversion(conversion);
    }

}
