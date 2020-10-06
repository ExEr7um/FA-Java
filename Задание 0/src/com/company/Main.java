package com.company;

import java.lang.reflect.Method;

public class Main {

    static int task9(int arg) {
        return arg - 21;
    }

    static double task10(double arg1, double arg2) {
        return (arg1 + arg2) / 2;
    }

    static double task11(double arg1, double arg2) {
        return Math.sqrt(arg1 + arg2);
    }

    static double task12(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }

    public static void main(String[] args) {
        // Задача 1
        System.out.println("Hello world!");

        // Задача 2
        int integer = 10;
        System.out.println(integer);

        // Задача 3
        int a = 1;
        a += 1;
        a++;
        ++a;
        System.out.println(a);

        // Задача 4
        a = 10;
        int b = 5;
        // Способ 1
        a = a + b;
        b = b - a;
        b = -b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);
        // Способ 2
        int c = a;
        a = b;
        b = c;
        System.out.println(a);
        System.out.println(b);

        // Задача 5
        a = 5;
        b = 6;
        System.out.println(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));

        // Задача 6
        a = 16;
        System.out.println(a % 10);

        // Задача 7
        a = 36;
        System.out.println(a / 10);

        // Задача 8
        a = 54;
        System.out.println(a / 10);

        // Задача 9
        a = 34;
        System.out.println(task9(a));

        // Задача 10
        a = 12;
        b = 7;
        System.out.println(task10(a, b));

        // Задача 11
        a = 12;
        b = 7;
        System.out.println(task11(a, b));

        // Задача 12
        double x1 = 1;
        double y1 = 3;
        double x2 = 5;
        double y2 = 7;
        System.out.println(task12(x1, y1, x2, y2));
    }
}
