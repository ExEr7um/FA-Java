package com.exer7um;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Список команд:\n1 — Добавить товар в меню еды\n2 — Добавить товар в меню напитков");
            System.out.println("Введите номер команды:");
            Scanner Scanner = new Scanner(System.in);
            int command = Integer.parseInt(Scanner.nextLine());
            if (command == 1) {
                FoodMenu foodMenu = new FoodMenu();
                FoodMenu.add();
                FoodMenu.output();
            }
            if (command == 2) {
                DrinkMenu drinkMenu = new DrinkMenu();
                DrinkMenu.add();
                DrinkMenu.output();
            }
            if (command == 0) {
                break;
            }
        }
    }
}

class Item {
    String title;
    int price;
    String measurement;
    int amount;
    String composition;

    public Item(String title, int price, String measurement, int amount, String composition) {
        this.title = title;
        this.price = price;
        this.measurement = measurement;
        this.amount = amount;
        this.composition = composition;
    }

    @Override
    public String toString() {
        return "Название " + title + ", Цена " + price + ", Количество " + amount + measurement + ", Состав " + composition;
    }
}

class Food extends Item {
    public Food(String title, int price, String measurement, int amount, String composition) {
        super(title, price, measurement, amount, composition);
    }
}

class Drink extends Item {
    public Drink(String title, int price, String measurement, int amount, String composition) {
        super(title, price, measurement, amount, composition);
    }
}

class DrinkMenu implements Menu {
    static HashMap<Drink, Integer> menu;

    public DrinkMenu() {
        menu = new HashMap<Drink, Integer>();
    }

    public static void add() {
        System.out.println("Введите название товара:");
        Scanner Scanner = new Scanner(System.in);
        String title = Scanner.nextLine();
        System.out.println("Введите цену товара:");
        String price = Scanner.nextLine();
        System.out.println("Введите единицу измерения товара:");
        String measurement = Scanner.nextLine();
        System.out.println("Введите количество товара:");
        String amount = Scanner.nextLine();
        System.out.println("Введите состав товара:");
        String composition = Scanner.nextLine();
        Drink Drink = new Drink(title, Integer.parseInt(price), measurement, Integer.parseInt(amount), composition);
        menu.put(Drink, 1);
    }

    public static void output() {
        System.out.println("Меню Напитков: " + menu.keySet());
    }
}

class FoodMenu implements Menu {
    static HashMap<Food, Integer> menu;

    public FoodMenu() {
        menu = new HashMap<Food, Integer>();
    }

    public static void add() {
        System.out.println("Введите название товара:");
        Scanner Scanner = new Scanner(System.in);
        String title = Scanner.nextLine();
        System.out.println("Введите цену товара:");
        String price = Scanner.nextLine();
        System.out.println("Введите единицу измерения товара:");
        String measurement = Scanner.nextLine();
        System.out.println("Введите количество товара:");
        String amount = Scanner.nextLine();
        System.out.println("Введите состав товара:");
        String composition = Scanner.nextLine();
        Food Food = new Food(title, Integer.parseInt(price), measurement, Integer.parseInt(amount), composition);
        menu.put(Food, 1);
    }

    public static void output() {
        System.out.println("Меню Еды: " + menu.keySet());
    }
}

interface Menu {
    public static void add() {

    }

    public static void output() {

    }
}