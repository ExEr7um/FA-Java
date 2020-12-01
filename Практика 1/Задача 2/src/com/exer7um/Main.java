package com.exer7um;
import java.util.Random;

class VectorClass {
    int x;
    int y;
    int z;

    // Конструктор
    public VectorClass() {
        randomizer();
    }

    // Генератор вектора
    private void randomizer() {
        Random random = new Random();
        this.x = random.nextInt(10);
        this.y = random.nextInt(10);
        this.z = random.nextInt(10);
    }

    public void output() {
        System.out.print(x + ", " + y + ", " + z);
    }
}

class VectorFunctions {
    VectorClass vector1;
    VectorClass vector2;
    VectorClass vector3;
    double inner;
    double length1;
    double length2;
    

    // Конструктор
    public VectorFunctions(VectorClass vector1, VectorClass vector2) {
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.vector3 = new VectorClass();
    }

    // Длина вектора
    public void length() {
        this.length1 = Math.sqrt(this.vector1.x * this.vector1.x + this.vector1.y * this.vector1.y + this.vector1.z * this.vector1.z);
        System.out.print("\n\nДлина вектора 1: " + this.length1);
        this.length2 = Math.sqrt(this.vector2.x * this.vector2.x + this.vector2.y * this.vector2.y + this.vector2.z * this.vector2.z);
        System.out.print("\nДлина вектора 2: " + this.length2);
    }

    // Скалярное произведение вектора
    public void innerProduct() {
        this.inner = this.vector1.x * this.vector2.x + this.vector1.y * this.vector2.y + this.vector1.z * this.vector2.z;
        System.out.print("\n\nСкалярное произведение векторов: " + this.inner);
    }

    // Произведение векторов
    public void multiplication() {
        this.vector3.x = this.vector1.y * this.vector2.z - this.vector1.z * this.vector2.y;
        this.vector3.y = this.vector1.z * this.vector2.x - this.vector1.x * this.vector2.z;
        this.vector3.z = this.vector1.x * this.vector2.y - this.vector1.y * this.vector2.x;
        System.out.print("\n\nПроизведение векторов: ");
        this.vector3.output();
    }

    // Угол между векторами
    public void angle() {
        this.innerProduct();
        this.length();
        System.out.print("\n\nКосинус угла между векторами: " + (this.inner / length1 * length2));
    }

    public void addition() {
        this.vector3.x = this.vector1.x + this.vector2.x;
        this.vector3.y = this.vector1.y + this.vector2.y;
        this.vector3.z = this.vector1.z + this.vector2.z;
        System.out.print("\n\nСумма векторов: ");
        vector3.output();
    }

    public void subtraction() {
        this.vector3.x = this.vector1.x - this.vector2.x;
        this.vector3.y = this.vector1.y - this.vector2.y;
        this.vector3.z = this.vector1.z - this.vector2.z;
        System.out.print("\nРазность векторов векторов: ");
        vector3.output();
    }
}

public class Main {

    public static void main(String[] args) {
	    VectorClass vec1 = new VectorClass();
        VectorClass vec2 = new VectorClass();

        System.out.println("\nВектор 1:");
        vec1.output();
        System.out.println("\nВектор 2:");
        vec2.output();

        VectorFunctions functions = new VectorFunctions(vec1, vec2);
        functions.length();
        functions.innerProduct();
        functions.multiplication();
        functions.angle();
        functions.addition();
        functions.subtraction();
    }
}
