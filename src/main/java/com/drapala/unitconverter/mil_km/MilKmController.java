package com.drapala.unitconverter.mil_km;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by maczi on 2018-09-08.
 */
@Slf4j
@Controller
public class MilKmController {

    private final MilKmConverter converter;
    private boolean showLastConverted;

    @Autowired
    public MilKmController(MilKmConverter converter) {
        this.converter = converter;
    }

    @GetMapping("mil-km-converter")
    public String calCm(Model model) {
        model.addAttribute("result", converter);
        log.info("result = {}", model);
        String history;
        if (converter.getUnit() == null || converter.getUnit().equals("null")){
             showLastConverted = true;
        } else {
            showLastConverted = false;
        }
        model.addAttribute("showLast", showLastConverted );
        model.addAttribute("wholeHistory", converter.getRepository().getHistory());
        return "mil_km";
    }

    @PostMapping("mil-km-converter")
    public String calCmProcess(@RequestParam(name = "value", defaultValue = "0") double value,
                               @RequestParam(name = "unit", defaultValue = "null") String unit) {
        log.info("Retrieved value = {}", value);
        log.info("Retrieved unit = {}", unit);
        converter.setValue(value);
        converter.setUnit(unit);
        if (!unit.equals("null")){
            converter.saveResult();
        }
        return  "redirect:/" + "mil-km-converter";
    }

    @GetMapping("goHome2")
    public String goHome() {
        converter.setValue(0);
        log.info("Now value ={}", converter.getValue());
        converter.setUnit(null);
        log.info("Now unit = {}", converter.getUnit());
        return "redirect:/";
    }



}
