package com.drapala.unitconverter.cal_cm;

import com.drapala.unitconverter.Converter;
import com.drapala.unitconverter.entity.Converted;
import com.drapala.unitconverter.repository.ConvertedRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by maczi on 2018-09-08.
 */
@Slf4j
@Service
@Primary
public class CalCmConverter {


    @Setter
    @Getter
    private double value;
    private String unit = "temp";

    @Setter
    @Getter
    private String secondUnit;


    public Optional<String> getUnit() {
        return Optional.ofNullable(unit);
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public String getResult(){
        log.info("Method: getResult() is running.");

        String result;

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


    @Override
    public String toString() {
        if (unit == null) {
            return "";
        }

        return getResult();
    }
}
