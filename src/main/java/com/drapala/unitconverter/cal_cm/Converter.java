package com.drapala.unitconverter.cal_cm;

import com.drapala.unitconverter.entity.Converted;
import com.drapala.unitconverter.repository.ConvertedRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by maczi on 2018-09-08.
 */

@Data
@Service
public class Converter {

    @Autowired
    private ConvertedRepository repository;

    private double value;
    private String unit;
    private String secondUnit;


    public String getResult(){
        String result;
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
        result = String.format("%.2f %s = %.2f %s",
                this.value, this.unit, convertedValue, this.secondUnit);
        repository.save(new Converted(result));
        return result;
    }


    @Override
    public String toString() {
        if (unit == null) {
            return "";
        }

        return getResult();
    }
}
