package com.drapala.unitconverter.cal_cm;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

/**
 * Created by maczi on 2018-09-08.
 */
@Slf4j
@Controller
public class CalCmController {


    @GetMapping("cal-cm-converter")
    public String calCm() {
        return "cal_cm";
    }

    @PostMapping("cal-cm-converter")
    public String calCmProcess(@RequestParam(name = "value", defaultValue = "0") String value,
                               @RequestParam(name = "unit", defaultValue = "null") String unit) {
        log.info("Retrieved value = {}", value);
        log.info("Retrieved unit = {}", unit);
        return  "cal_cm";

    }
}
