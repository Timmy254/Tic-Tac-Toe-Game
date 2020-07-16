package com.pluralsight.myproject.practice;

import java.util.Scanner;

public class ModifiedClass {
    private static int win = 0;
    public static char[] letter;
    public static char[][] result = new char[3][3];
    private static int num = 0;


    public static void main(String[] args){
        //Print empty array first
        int X = 264;
        int O = 237;

        EmptyString();

        while (win == 0){
            Decision();
//            GenerateInput(result, length, width);
            Output(result);
            //check if there is a row win
            Rows(X, O);
            //Check if column wins
            checkIfColumnWins(X, O);
            //check if diagonals match
            DiagonalOne(X, O);
            //check if the second diagonal matches
            DiagonalTwo(X, O);

        }

        //convert the array to a multi-dimension array
        result[0][0] = letter[0];
        result[0][1] = letter[1];
        result[0][2] = letter[2];
        result[1][0] = letter[3];
        result[1][1] = letter[4];
        result[1][2] = letter[5];
        result[2][0] = letter[6];
        result[2][1] = letter[7];
        result[2][2] = letter[8];


    }

    private static void DiagonalTwo(int x, int o) {
        for (char[] chars : result) {
            for (int j = 0; j < chars.length; j++) {
                if (result[2][0] + result[1][1] + result[0][2] == x) {
                    System.out.println("X wins");
                    System.exit(0);
                } else if (result[0][2] + result[1][1] + result[2][0] == o) {
                    System.out.println("O wins");
                    System.exit(0);
                }
            }
        }
    }

    private static void DiagonalOne(int x, int o) {
        for (char[] chars : result) {
            for (int j = 0; j < chars.length; j++) {
                if (result[0][0] + result[1][1] + result[2][2] == x) {
                    System.out.println("X wins");
                    System.exit(0);
                } else if (result[2][2] + result[1][1] + result[0][0] == o) {
                    System.out.println("O wins");
                    System.exit(0);
                }
            }
        }
    }

    private static void checkIfColumnWins(int x, int o) {
        for (char[] chars : result) {
            for (int j = 0; j < chars.length; j++) {
                if (result[0][j] + result[1][j] + result[2][j] == x) {
                    System.out.println("X wins");
                    System.exit(0);
                } else if (result[0][j] + result[1][j] + result[2][j] == o) {
                    System.out.println("O wins");
                    System.exit(0);
                }
            }
        }
    }

    private static void Rows(int x, int o) {
        for (char[] chars : result) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[0] + chars[1] + chars[2] == x){
                    System.out.println("X wins");
                    System.exit(0);
                }
                else if (chars[0] + chars[1] + chars[2] == o) {
                    System.out.println("O wins");
                    System.exit(0);
                }
            }
        }
    }

    private static void EmptyString() {
        for (int i = 0; i < 1; i++){
            System.out.println("---------");
            System.out.println("|" + " " + " " + " " + " " + " " + " " + " " + "|");
            System.out.println("|" + " " + " " + " " + " " + " " + " " + " " + "|");
            System.out.println("|" + " " + " " + " " + " " + " " + " " + " " + "|");
            System.out.println("---------");
        }
    }

    private static void Decision() {
        System.out.print("Enter the coordinates: ");
        Scanner scanner = new Scanner(System.in);
        //check if it is is int or String
        if (scanner.hasNextInt()){
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            if (num1 > 3 || num2 > 3){
                System.out.println("Coordinates should be from 1 to 3!");
                Decision();
            } else {
                int length = --num1;
                int width = 3 - num2;
                GenerateInput(result, length, width);

            }
        } else {
            System.out.println("You should enter numbers!");
            Decision();
        }

    }

    private static void GenerateInput(char[][] result, int length, int width) {
        if (result[width][length] != 'X' && result[width][length] != 'O'){

           if (num % 2 == 0){
               result[width][length] = 'X';
           } else {
               result[width][length] = 'O';
           }
            num++;
        }
        else {
            System.out.println("This cell is occupied! Choose another one!");
            Decision();
        }
    }

    private static void Output(char[][] result) {
        System.out.println("---------");
        System.out.println("|" + " " + result[0][0] + " " + result[0][1] + " " + result[0][2] + " " + "|");
        System.out.println("|" + " " + result[1][0] + " " + result[1][1] + " " + result[1][2] + " " + "|");
        System.out.println("|" + " " + result[2][0] + " " + result[2][1] + " " + result[2][2] + " " + "|");
        System.out.println("---------");
    }
}
