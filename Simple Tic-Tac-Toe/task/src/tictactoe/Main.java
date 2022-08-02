package tictactoe;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void printField(char[][] field) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean doesOWin(char[][] array) {

        boolean oWin = false;
        for (int i = 0; i < 3; i++) {
            int horizontalSum = 0;
            int verticalSum = 0;

            for (int j = 0; j < 3; j++) {
                if (array[i][j] == 'O') {
                    horizontalSum += 'O';
                }

                if (array[j][i] == 'O') {
                    verticalSum += 'O';
                }
            }
            if (horizontalSum == 237 || verticalSum == 237) {
                oWin = true;
            }
        }

        int diagonalSum = 0;
        int reverseDiagonalSum = 0;

        for (int i = 0; i < 3; i++) {
            if (array[i][i] == 'O') {
                diagonalSum += 'O';
            }
            if (array[2 - i][i] == 'O') {
                reverseDiagonalSum += 'O';
            }
        }
        if (diagonalSum == 237 || reverseDiagonalSum == 237) {
            oWin = true;
        }

        return oWin;
    }

    public static boolean doesXWin(char[][] array) {
        boolean xWin = false;

        for (int i = 0; i < 3; i++) {
            int horizontalSum = 0;
            int verticalSum = 0;

            for (int j = 0; j < 3; j++) {
                if (array[i][j] == 'X') {
                    horizontalSum += 'X';
                }

                if (array[j][i] == 'X') {
                    verticalSum += 'X';
                }
            }
            if (horizontalSum == 264 || verticalSum == 264) {
                xWin = true;
            }
        }

        int diagonalSum = 0;
        int reverseDiagonalSum = 0;

        for (int i = 0; i < 3; i++) {
            if (array[i][i] == 'X') {
                diagonalSum += 'X';
            }
            if (array[2 - i][i] == 'X') {
                reverseDiagonalSum += 'X';
            }
        }
        if (diagonalSum == 264 || reverseDiagonalSum == 264) {
            xWin = true;
        }

        return xWin;
    }

    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] field = new char[3][3];
        int[] counterOfSymbols = new int[2];
        //String lineOfSymbols = scanner.nextLine();
        int[] moveOfPlayer = new int[2];
        boolean doesItXTurn = true;

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                field[i][j] = '_';
                System.out.print(field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        while (true) {
            if (counterOfSymbols[0] + counterOfSymbols[1] == 9) {
                    System.out.println("Draw");
                    break;
                }


                moveOfPlayer[0] = 0;
                moveOfPlayer[1] = 0;
                String playerMove = scanner.nextLine();
                String[] subString = playerMove.split("\\s");
                int flag = 0;

                for (String subStr : subString) {
                    if (!isNumber(subStr)) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    System.out.println("You should enter numbers!");
                    continue;
                }

                moveOfPlayer[0] = Integer.parseInt(subString[0]);
                moveOfPlayer[1] = Integer.parseInt(subString[1]);

                if (moveOfPlayer[0] <= 3 && moveOfPlayer[0] >= 1 && moveOfPlayer[1] <= 3 && moveOfPlayer[1] >= 1) {
                    if (field[moveOfPlayer[0] - 1][moveOfPlayer[1] - 1] == '_') {
                        if (doesItXTurn) {
                            field[moveOfPlayer[0] - 1][moveOfPlayer[1] - 1] = 'X';
                            counterOfSymbols[0]++;
                            doesItXTurn = false;
                            if (doesXWin(field)) {
                                printField(field);
                                System.out.println("X wins");
                                break;
                            }
                        } else {
                            field[moveOfPlayer[0] - 1][moveOfPlayer[1] - 1] = 'O';
                            counterOfSymbols[1]++;
                            doesItXTurn = true;
                            if (doesOWin(field)) {
                                printField(field);
                                System.out.println("O wins");
                                break;
                            }
                        }
                        printField(field);


                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }

            }


        }


        /*
        if (Math.abs(counterOfSymbols[0] - counterOfSymbols[1]) >= 2 || doesOWin(field) && doesXWin(field)) {
            System.out.println("Impossible");
        } else if (doesXWin(field)) {
            System.out.println("X wins");
        } else if (doesOWin(field)) {
            System.out.println("O wins");
        } else if (counterOfSymbols[0] + counterOfSymbols[1] == 9) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }

        */
}
