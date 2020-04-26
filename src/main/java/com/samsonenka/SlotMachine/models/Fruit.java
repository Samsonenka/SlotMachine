package com.samsonenka.SlotMachine.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Fruit {

    private int id;
    private String name;
    private List<Fruit> fruitList = new ArrayList<>();

    public Fruit() {
    }

    public Fruit(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Fruit> getFruitList() {

        fruitList.add(new Fruit(1, "grape"));
        fruitList.add(new Fruit(2, "lemon"));
        fruitList.add(new Fruit(3, "pear"));
        fruitList.add(new Fruit(4, "plum"));

        return fruitList;
    }

    public List<Integer> getRandomNumbers(){

        ThreadLocalRandom random = ThreadLocalRandom.current();

        List<Integer> integerList = new ArrayList<>();
        integerList.add(random.nextInt(1, 5));
        integerList.add(random.nextInt(1, 5));
        integerList.add(random.nextInt(1, 5));
        integerList.add(random.nextInt(1, 5));

        return integerList;
    }

    public List<Fruit> createRandomFruits(List<Fruit> fruitList, List<Integer> integerList){

        List<Fruit> newFruitList = new ArrayList<>();

        for (int i = 0; i < fruitList.size(); i++) {
            for (int j = 0; j < integerList.size(); j++) {
                if (fruitList.get(i).getId() == integerList.get(j)){
                    newFruitList.add(fruitList.get(i));
                }
            }
        }

        return newFruitList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
