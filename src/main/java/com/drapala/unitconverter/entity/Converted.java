package com.drapala.unitconverter.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Converted {

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    private String result;

    public Converted(String result) {
        this.result = result;
    }

    protected Converted() {
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Converted{");
        sb.append("id=").append(id);
        sb.append(", result='").append(result).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
