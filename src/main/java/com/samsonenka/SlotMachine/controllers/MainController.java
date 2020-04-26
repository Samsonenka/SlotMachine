package com.samsonenka.SlotMachine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/startGame")
    public String startGame(ModelMap modelMap){

        System.out.println("Start Game!");
        return "index";
    }
}
