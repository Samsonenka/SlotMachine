package com.samsonenka.SlotMachine.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Fruit {

    private int id;
    private String name;
    private int point;
    private List<Fruit> fruitList = new ArrayList<>();

    public Fruit() {
    }

    public Fruit(int id, String name, int point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public List<Fruit> getFruitList() {

        fruitList.add(new Fruit(1, "grape", 2)); //виноград
        fruitList.add(new Fruit(2, "lemon", 3)); //лимон
        fruitList.add(new Fruit(3, "pear", 4)); //груша
        fruitList.add(new Fruit(4, "plum", 5)); //слива

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

    public int bonusPoints(List<Fruit> fruitList){

        int counter = 0;
        int maxBonus = 0;
        List<Integer> counterList = new ArrayList<>();

        for (int i = 0; i < fruitList.size(); i++) {
            for (int j = 0; j < fruitList.size(); j++) {
                if (fruitList.get(i).getId() == fruitList.get(j).getId()){
                    counter++;
                }
            }
            counterList.add(counter);
            counter = 0;
        }

        for (int i = 0; i < counterList.size(); i++) {
            if (counterList.get(i) > maxBonus){
                maxBonus = counterList.get(i);
            }
        }
        return maxBonus;
    }

    public int sumPoints(List<Fruit> fruitList){

        int sumPoints = 0;
        int maxBonus = bonusPoints(fruitList);

        for (Fruit fruit: fruitList) {
            sumPoints += fruit.getPoint();
        }

        return sumPoints * maxBonus;
    }

    public int getPoint() {
        return point;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
