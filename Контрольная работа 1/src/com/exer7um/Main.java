package com.exer7um;

import java.util.ArrayList;

class Car {
    String color;
    int maxSpeed;
    String gearBox;
    int currentSpeed = 0;
    int price;
    boolean ignition = false;

    public Car(String color, int maxSpeed, String gearBox, int price) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.gearBox = gearBox;
        this.price = price;
    }

    public void start() {
        if (!ignition) {
            ignition = true;
            System.out.println("Машина заведена!");
        } else {
            System.out.println("Машина уже заведена!");
        }
    }

    public void stop() {
        if (ignition) {
            ignition = false;
            currentSpeed = 0;
            System.out.println("Машина выключена!");
        } else {
            System.out.println("Машина уже выключена!");
        }
    }

    public void accelerate(int speed) {
        if (ignition) {
            if (currentSpeed + speed <= maxSpeed) {
                currentSpeed += speed;
            } else {
                currentSpeed = maxSpeed;
                System.out.println("Машина достигла максимальной скорости!");
            }
            System.out.println("Скорость машины: " + currentSpeed);
        } else {
            System.out.println("Сначала нужно завести машину!");
        }
    }
}

class ServiceCar extends Car {
    boolean flash = false;

    public ServiceCar(String color, int maxSpeed, String gearBox, int price) {
        super(color, maxSpeed, gearBox, price);
    }

    public void switchFlasher() {
        flash = !flash;
        if (flash) {
            System.out.println("Мигалка включена!");
        } else {
            System.out.println("Мигалка выключена");
        }
    }
}

class Garage {
    int capacity;
    ArrayList<Car> stock = new ArrayList<Car>();

    public Garage(int capacity) {
        this.capacity = capacity;
    }

    public void addCar(Car newCar) {
        stock.add(newCar);
    }

    public void output() {
        System.out.println("Автомобили на складе: " + stock);
    }
}

public class Main {

    public static void main(String[] args) {
        Car jigul = new Car("Красный", 120, "МКПП", 10000);
        jigul.start();
        jigul.accelerate(100);
        jigul.accelerate(20);
        jigul.accelerate(20);
        ServiceCar service = new ServiceCar("Красный", 120, "МКПП", 10000);
        service.switchFlasher();

    }
}
