package com.drapala.unitconverter;

import com.drapala.unitconverter.repository.ConvertedRepository;

public interface Converter {

    void setValue(double value);

    double getValue();

    void setUnit(String unit);

    String getUnit();

    void setSecondUnit(String secondUnit);

    String getSecondUnit();

    String getResult();

  //  void saveResult();

//    ConvertedRepository getRepository();



}
