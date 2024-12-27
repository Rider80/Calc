package com.pack1;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt"); //создаём объект file
        Scanner scanner = new Scanner(file); //сканируем объект file в scanner

        File out = new File("output.txt");
        PrintWriter pw = new PrintWriter(out);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); // из scanner читаем строку с нашими переменными и матзнаком
            String[] calcs = line.split(" "); // создаём массив calcs из разделенных по пробелу символов строки
            System.out.println(Arrays.toString(calcs));// выводим в консоль calcs
            double[] numbers = new double[2]; //создаём массив numbers на 2 перемеyные
            try {
            numbers[0] = Integer.parseInt(calcs[0]); // первому элементу присваиваем значение Int первой переменной
            numbers[1] = Integer.parseInt(calcs[2]); // второму элементу присваиваем значение Int второй переменной
            } catch (Exception ex) {
                System.out.println("Error! Not number");
                }
            System.out.println(Arrays.toString(numbers)); // выводим в консоль массив с переменными

            try { // если не выйдет то что в трай, то кэтч
                double result = 0;
                double a = numbers[0];
                System.out.println("a = " + a);
                String op = calcs[1];
                System.out.println("op = " + op);
                double b = numbers[1];
                System.out.println("b = " + b);
                String ops = "+-*/";
                if (!ops.contains(op)) System.out.println("Operation Error!");
                switch (op) {
                    case "/": {
                        System.out.println(b == 0 ? "Error! Division by zero" : a / b);
                        pw.println(a+" "+op+" "+b+" = Error! Division by zero");
                        break;
                    }
                    case "+": {
                        result = a + b;
                        System.out.println(result);
                        pw.println(a+" "+op+" "+b+" = "+result);
                        break;
                    }
                    case "-": {
                        result = a - b;
                        System.out.println(result);
                        pw.println(a+" "+op+" "+b+" = "+result);
                        break;
                    }
                    case "*": {
                        result = a * b;
                        System.out.println(result);
                        pw.println(a+" "+op+" "+b+" = "+result);
                        break;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Error! Not number");
               break;
            }
        }
        scanner.close(); // закрываем поток сканнера
        pw.close();
    }
}

