package com.drapala.unitconverter.home;

import com.drapala.unitconverter.repository.ConvertedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class homePageController {


    private final ConvertedRepository repository;

    @Autowired
    public homePageController(ConvertedRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("result",repository.getActualAndLastTwoConverted());
        return "index";
    }


}
