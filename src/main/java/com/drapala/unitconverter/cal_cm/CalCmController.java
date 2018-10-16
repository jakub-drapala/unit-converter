package com.drapala.unitconverter.cal_cm;


import com.drapala.unitconverter.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by maczi on 2018-09-08.
 */
@Slf4j
@Controller
public class CalCmController {

    private final Converter converter;
    private boolean showLastConverted;

    @Autowired
    public CalCmController(Converter converter) {
        this.converter = converter;
    }

    @GetMapping("cal-cm-converter")
    public String calCm(Model model) {
        model.addAttribute("result", converter);
        log.info("result = {}", model);
        if (converter.getUnit() == null || converter.getUnit().equals("null")){
            showLastConverted = true;
        } else {
            showLastConverted = false;
        }
        model.addAttribute("showLast", showLastConverted);
        model.addAttribute("wholeHistory", converter.getRepository().getHistory());
        return "cal_cm";
    }

    @PostMapping("cal-cm-converter")
    public String calCmProcess(@RequestParam(name = "value", defaultValue = "0") double value,
                               @RequestParam(name = "unit", defaultValue = "null") String unit) {
        log.info("Retrieved value = {}", value);
        log.info("Retrieved unit = {}", unit);
        converter.setValue(value);
        converter.setUnit(unit);
        if (!unit.equals("null")){
            converter.saveResult();
        }
        return  "redirect:/" + "cal-cm-converter";
    }

    @GetMapping("goHome")
    public String goHome() {
        converter.setValue(0);
        log.info("Now value ={}", converter.getValue());
        converter.setUnit(null);
        log.info("Now unit = {}", converter.getUnit());
        return "redirect:/";
    }



}
