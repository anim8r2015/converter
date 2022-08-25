package com.anthony.converter.model;

import lombok.Data;

@Data
public class Conversion {

    Long Id;
    double factor;
    String measurement;
    String system;

}
