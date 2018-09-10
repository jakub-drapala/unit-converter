package com.drapala.unitconverter.cal_cm;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * Created by maczi on 2018-09-08.
 */

@Data
@Service
public class Converter {

    private double value;
    private String unit;
    private String secondUnit;


    public String getResult(){
        if (this.unit.equals("null")){
            return "You have to choose unit which want you converted";
        }

        double convertedValue;
        if (this.unit.equals("cal")) {
            convertedValue = this.value * 2.53995;
            this.secondUnit = "cm";
        } else  {
            convertedValue = this.value / 2.53995;
            this.secondUnit = "cal";
        }
        return String.format("%.2f %s = %.2f %s",
                this.value, this.unit, convertedValue, this.secondUnit);
    }


    @Override
    public String toString() {
        if (unit == null) {
            return "";
        }

        return getResult();
    }
}
