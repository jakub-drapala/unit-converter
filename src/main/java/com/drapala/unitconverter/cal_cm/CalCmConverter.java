package com.drapala.unitconverter.cal_cm;

import com.drapala.unitconverter.Converter;
import com.drapala.unitconverter.entity.Converted;
import com.drapala.unitconverter.repository.ConvertedRepository;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maczi on 2018-09-08.
 */
@Slf4j
@Data
@Service
public class CalCmConverter implements Converter {

    @Autowired
    private ConvertedRepository repository;

    private double value;
    private String unit;
    private String secondUnit;


    public String getResult(){
        log.info("Method: getResult() is running.");

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

        return result;
    }

    public void saveResult() {
        repository.save(new Converted(getResult(), "cal-cm"));

    }



    @Override
    public String toString() {
        if (unit == null) {
            return "";
        }

        return getResult();
    }
}
