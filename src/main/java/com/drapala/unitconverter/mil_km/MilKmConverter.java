package com.drapala.unitconverter.mil_km;

import com.drapala.unitconverter.entity.Converted;
import com.drapala.unitconverter.repository.ConvertedRepository;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by maczi on 2018-09-08.
 */
@Slf4j
@Data
@Service
public class MilKmConverter {

    @Autowired
    private ConvertedRepository repository;

    private double value;
    private String unit;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private String secondUnit;

    ArrayList<String> history = new ArrayList<>();


    public String getResult(){
        log.info("Method: getResult() is running.");

        String result;

        if (this.unit .equals("null")){
            return "You have to choose unit which want you converted";
        }

        double convertedValue;
        if (this.unit.equals("mil")) {
            convertedValue = this.value * 1.6093472;
            this.secondUnit = "km";
        } else  {
            convertedValue = this.value / 1.6093472;
            this.secondUnit = "mil";
        }
        result = String.format("%.2f %s = %.2f %s",
                this.value, this.unit, convertedValue, this.secondUnit);

        return result;
    }

    public void saveResult() {
        repository.save(new Converted(getResult(), "mil-km"));

    }



    @Override
    public String toString() {
        if (unit == null) {
            return "";
        }

        return getResult();
    }
}
