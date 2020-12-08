package com.exer7um;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;
import java.util.prefs.*;

public class Main {
    private static final String SERVICE = "";

    public static void savePreference(String pickedService) {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        prefs.put(SERVICE, pickedService);
    }

    public static String readPreference() {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);

        return prefs.get(SERVICE, "Weather.com");
    }

    public static void pickService() {
        Scanner serviceScanner = new Scanner(System.in);
        System.out.println("Выберите погодный сервис:\n1: Weather.com\n2: Яндекс\n3: Mail.ru");
        String serviceInput = serviceScanner.nextLine();
        String service = "";
        switch (serviceInput) {
            case ("1") -> service = "Weather.com";
            case ("2") -> service = "Яндекс";
            case ("3") -> service = "Mail.ru";
        }
        savePreference(service);
        getWeather();
    }

    public static String pickAction() {
        Scanner serviceScanner = new Scanner(System.in);
        System.out.println("\nВыберите действие:\n1: Получить погоду\n2: Выбрать сервис\n3: Закрыть программу");
        String actionInput = serviceScanner.nextLine();
        String action = "";
        switch (actionInput) {
            case ("1") -> action = "Получить погоду";
            case ("2") -> action = "Выбрать сервис";
            case ("3") -> action = "Закрыть программу";
        }
        return action;
    }

    public static void getWeather() {
        String service = "";
        service = readPreference();
        switch (service) {
            case ("Weather.com"):
                try {
                    Document doc = Jsoup.connect("https://weather.com/ru-RU/weather/today/l/34f2aafc84cff75ae0b014754856ea5e7f8ddf618cf9735549dfb5e016c28e10").get();
                    Elements degree = doc.select(".CurrentConditions--tempValue--3KcTQ");
                    Elements conditions = doc.select(".CurrentConditions--phraseValue--2xXSr");
                    Elements other = doc.select(".CurrentConditions--precipValue--RBVJT");
                    System.out.println("\nПогода с Weather.com");
                    System.out.println("Температура: " + degree.text());
                    System.out.println("Погодные условия: " + conditions.text());
                    System.out.println(other.text());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case ("Яндекс"):
                try {
                    Document doc = Jsoup.connect("https://yandex.ru/pogoda/moscow").get();
                    Elements degree = doc.select(".temp.fact__temp.fact__temp_size_s .temp__value");
                    Elements conditions = doc.select(".link__condition.day-anchor.i-bem");
                    Elements other = doc.select(".term.term_orient_v.fact__pressure .term__value");
                    System.out.println("\nПогода с Яндекс");
                    System.out.println("Температура: " + degree.text() + "°");
                    System.out.println("Погодные условия: " + conditions.text());
                    System.out.println("Давление: " + other.text());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case ("Mail.ru"):
                try {
                    Document doc = Jsoup.connect("https://pogoda.mail.ru/prognoz/moskva/").get();
                    Elements degree = doc.select(".information__content__temperature");
                    Elements conditions = doc.select(".information__content__additional.information__content__additional_first .information__content__additional__item");
                    Elements other = doc.select(".information__content__additional.information__content__additional_temperature .information__content__additional__item");
                    System.out.println("\nПогода с Mail.ru");
                    System.out.println("Температура: " + degree.text());
                    System.out.println("Погодные условия: " + conditions.text());
                    System.out.println("Ощущения: " + other.text());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public static void main(String[] args) {
        while (true) {
            switch (pickAction()) {
                case ("Получить погоду") -> getWeather();
                case ("Выбрать сервис") -> pickService();
                case ("Закрыть программу") -> System.exit(0);
            }
        }
    }
}