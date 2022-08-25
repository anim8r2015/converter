package com.anthony.converter.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="conversion_factors", schema = "converter")
public class ConversionEntity {

    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="Id")
    Long Id;
    @Column(name="factor")
    double factor;
    @Column(name="measurement")
    String measurement;
    @Column(name="system")
    String system;

}
