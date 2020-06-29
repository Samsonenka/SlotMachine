package com.samsonenka.SlotMachine.controllers;

import com.samsonenka.SlotMachine.models.Fruit;
import com.samsonenka.SlotMachine.models.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/startGame")
    public String startGame(ModelMap modelMap){

        Player player = new Player();
        Fruit fruit = new Fruit();
        List<Fruit> fruitList = fruit.createRandomFruits(fruit.getFruitList(), fruit.getRandomNumbers());

        System.out.println(fruit.sumPoints(fruitList, player));


        modelMap.put("fruitList", fruitList);

        return "index";
    }
}
