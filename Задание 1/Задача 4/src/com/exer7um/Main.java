package com.exer7um;

abstract class Shape {
    double volume;
}

class Box extends Shape {
    public Box(double volume) {
        this.volume = volume;
    }

    public void add(Shape shape) {
        if (volume < shape.volume) {
            System.out.println("Объем Shape больше доступного в Box. Доступный объем: " + volume);
        } else {
            volume -= shape.volume;
            System.out.println("Фигура добавлена! Доступный объем: " + volume);
        }
    }

    public void output() {
        System.out.println("Объем хранилища: " + volume);
    }
}

class Pyramid extends Shape {
    double s;
    double h;

    public Pyramid(double s, double h) {
        this.s = s;
        this.h = h;
        this.volume = s * h / 3;
    }

    public void output() {
        System.out.println("Объем пирамиды: " + volume);
    }
}

abstract class SolidOfRevolution extends Shape {
    double radius;

    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }
}

class Cylinder extends SolidOfRevolution {
    double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
        this.volume = Math.PI * Math.pow(radius, 2) * height;
    }

    public void output() {
        System.out.println("Объем цилиндра: " + volume);
    }
}

class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        super(radius);
        this.volume = 4 * Math.PI * Math.pow(radius, 3) / 3;
    }

    public void output() {
        System.out.println("Объем шара: " + volume);
    }
}

public class Main {

    public static void main(String[] args) {
        Box box = new Box(100);
        Pyramid pyramid = new Pyramid(4,5);
        Cylinder cylinder = new Cylinder(3,2);
        Ball ball = new Ball(3);

        box.output();
        pyramid.output();
        cylinder.output();
        ball.output();

        box.add(pyramid);
        box.add(cylinder);
        box.add(ball);
    }
}
