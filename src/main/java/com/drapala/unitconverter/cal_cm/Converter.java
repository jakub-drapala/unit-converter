package com.drapala.unitconverter.cal_cm;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * Created by maczi on 2018-09-08.
 */

@Data
@Service
public class Converter {

    private String value;
    private String unit;


    public String message(){
        if (unit == null){
            return "";
        }
        return value + " " + unit + " = ";
    }

    @Override
    public String toString() {
        if (unit == null) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(value);
        sb.append(" ").append(unit).append(" = ");/*
        sb.append(", unit='").append(unit).append('\'');
        sb.append('}');*/
        return sb.toString();
    }
}
