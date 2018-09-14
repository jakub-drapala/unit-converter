package com.drapala.unitconverter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Converted {

    @Id
    @GeneratedValue
    private Long id;

    private String result;

    public Converted(String result) {
        this.result = result;
    }
}
