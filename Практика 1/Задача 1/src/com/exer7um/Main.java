package com.exer7um;
import java.util.Random;

class MatrixClass {
    int width;
    int height;
    int[][] matrix;

    // Конструктор
    public MatrixClass(int width, int height) {
        this.matrix = new int[width][height];
        this.width = matrix[0].length;
        this.height = matrix.length;
        this.randomizer();
    }

    // Заполнение матрицы
    private void randomizer() {
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }
    }

    // Вывод матрицы
    public void output() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class MatrixFunctions {
    MatrixClass matrix1;
    MatrixClass matrix2;
    MatrixClass matrix3;
    MatrixClass matrix4;

    // Конструктор
    public MatrixFunctions(MatrixClass matrix1, MatrixClass matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }

    // Сложение матриц
    public void addition() {
        if (this.matrix1.width == this.matrix2.width && this.matrix1.height == this.matrix2.height) {
            this.matrix3 = new MatrixClass(matrix1.width, matrix1.height);
            for (int i = 0; i < matrix1.height; i++) {
                for (int j = 0; j < matrix1.height; j++) {
                    matrix3.matrix[i][j] = matrix1.matrix[i][j] + matrix2.matrix[i][j];
                }
            }
            System.out.println("\nРезультат сложения:");
            matrix3.output();
        } else {
            System.out.println("Ошибка: Можно складывать матрицы только одинаковой размерности!");
        }
    }

    // Вычитание матриц
    public void subtraction() {
        if (this.matrix1.width == this.matrix2.width && this.matrix1.height == this.matrix2.height) {
            this.matrix3 = new MatrixClass(matrix1.width, matrix1.height);
            for (int i = 0; i < matrix1.height; i++) {
                for (int j = 0; j < matrix1.height; j++) {
                    matrix3.matrix[i][j] = matrix1.matrix[i][j] - matrix2.matrix[i][j];
                }
            }
            System.out.println("\nРезультат вычитания:");
            matrix3.output();
        } else {
            System.out.println("Ошибка: Можно вычитать матрицы только одинаковой размерности!");
        }
    }

    // Умножение матрицы на число
    public void numberMultiplication(int multiplier) {
        this.matrix3 = new MatrixClass(matrix1.width, matrix1.height);
        for (int i = 0; i < matrix1.height; i++) {
            for (int j = 0; j < matrix1.height; j++) {
                matrix3.matrix[i][j] = matrix1.matrix[i][j] * multiplier;
            }
        }
        System.out.println("\nРезультат умножения матрицы 1 на число:");
        matrix3.output();
    }

    // Произведение матриц
    public void multiplication() {
        if (this.matrix1.width == this.matrix2.height) {
            this.matrix3 = new MatrixClass(matrix1.width, matrix2.height);
            for (int i = 0; i < matrix1.height; i++) {
                for (int j = 0; j < matrix1.height; j++) {
                    matrix3.matrix[i][j] = 0;
                }
            }
            for (int i = 0; i < matrix1.height; i++) {
                for (int j = 0; j < matrix2.width; j++) {
                    for (int k = 0; k < matrix1.width; k++) {
                        matrix3.matrix[i][j] += matrix1.matrix[i][k] * matrix2.matrix[k][j];
                    }
                }
            }
            System.out.println("\nРезультат произведения матриц:");
            matrix3.output();
        } else {
            System.out.println("Ошибка: Можно премножать матрицы только когда количество столбцов первой равняется количеству строк второй!");
        }
    }

    // Транспонирование матрицы
    public void transposition() {
        this.matrix3 = new MatrixClass(matrix1.width, matrix1.height);
        for (int i = 0; i < matrix1.height; i++) {
            for (int j = 0; j < matrix1.height; j++) {
                matrix3.matrix[j][i] = matrix1.matrix[i][j];
            }
        }
        System.out.println("\nРезультат транспонирования матрицы 1:");
        matrix3.output();
    }

    // Возведение в степень
    public void exponentiation(int exponent) {
        this.matrix3 = this.matrix1;
        this.matrix4 = this.matrix2;
        this.matrix2 = this.matrix1;
        for (int n = 1; n < exponent; n++) {
            this.multiplication();
            this.matrix2 = this.matrix3;
        }
        this.matrix2 = this.matrix4;
        System.out.println("\nРезультат возведения матрицы в степень:");
        matrix3.output();
    }
}

public class Main {

    public static void main(String[] args) {
        MatrixClass mat1 = new MatrixClass(3, 3);
        MatrixClass mat2 = new MatrixClass(3, 3);
        System.out.println("\nМатрица 1:");
        mat1.output();
        System.out.println("\nМатрица 2:");
        mat2.output();

        MatrixFunctions functions = new MatrixFunctions(mat1, mat2);
        functions.addition();
        functions.subtraction();
        functions.numberMultiplication(2);
        functions.multiplication();
        functions.transposition();
        functions.exponentiation(3);
    }
}
