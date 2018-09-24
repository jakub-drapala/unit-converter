package com.drapala.unitconverter.cal_cm;


import com.drapala.unitconverter.Converter;
import com.drapala.unitconverter.entity.Converted;
import com.drapala.unitconverter.repository.ConvertedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by maczi on 2018-09-08.
 */
@Slf4j
@Controller
public class CalCmController {

    private final Converter converter;

    @Autowired
    private ConvertedRepository repository;

    @Autowired
    public CalCmController(Converter converter) {
        this.converter = converter;

    }

    @GetMapping("cal-cm-converter")
    public String calCm(Model model) {
        model.addAttribute("result", converter);
        log.info("result = {}", model);
        String history;
        if (converter.getUnit() == null){
            history = repository.getActualAndLastTwoConverted();
            model.addAttribute("result", "You have to choose unit which want you converted");
            if (repository.getSizeOfRepository() == 0) {
                model.addAttribute("result", "");
            }
        } else {
            history = repository.getLastThreeConverted();
            if (converter.getUnit().equals("temp")) {
                model.addAttribute("result", "");
            }
        }
        model.addAttribute("history", history );
        return "cal_cm";
    }

    @PostMapping("cal-cm-converter")
    public String calCmProcess(@RequestParam(name = "value", defaultValue = "0") double value,
                               @RequestParam(name = "unit", required = false) String unit) {
        log.info("Retrieved value = {}", value);
        log.info("Retrieved unit = {}", unit);
        converter.setValue(value);
        converter.setUnit(unit);
        if (unit != null){
            repository.save(new Converted(converter.getResult(),"cal-cm"));
        }


        return  "redirect:/" + "cal-cm-converter";
    }

    @GetMapping("mil-km-converter")
    public String milKm(Model model) {
        model.addAttribute("result", converter);
        log.info("result = {}", model);
        String history;
        if (converter.getUnit() == null || converter.getUnit().equals("null")){
            history = repository.getActualAndLastTwoConverted();
        } else {
            history = repository.getLastThreeConverted();
        }
        model.addAttribute("history", history );
        return "mil_km";
    }


    @PostMapping("mil-km-converter")
    public String milKmProcess(@RequestParam(name = "value", defaultValue = "0") double value,
                               @RequestParam(name = "unit", defaultValue = "null") String unit) {
        log.info("Retrieved value = {}", value);
        log.info("Retrieved unit = {}", unit);
        converter.setValue(value);
        converter.setUnit(unit);
        if (!unit.equals("null")){
            repository.save(new Converted(converter.getResult(),"bbbbb"));
        }
        return  "redirect:/" + "mil-km-converter";
    }


    @GetMapping("goHome")
    public String goHome() {
        converter.setValue(0);
        log.info("Now value ={}", converter.getValue());
        converter.setUnit("temp");
        log.info("Now unit = {}", converter.getUnit());
        return "redirect:/";
    }



}
