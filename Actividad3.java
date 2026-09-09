package com.mycompany.actividad3;

import java.io.IOException;

public class Actividad3 {

    public static void main(String[] args) {

        
        System.out.println("Fibonacci recursivo");
        int n = 10;
        for (int i = 0; i <= n; i++) {
            System.out.print(Fibonacci.fibonacci(i) + " ");
        }
        System.out.println("\n");

      
        System.out.println("Subset Sum");
        int[] conjunto = {3, 34, 4, 12, 5, 2};
        int objetivo = 9;
        boolean existe = SubsetSum.subsetSum(conjunto, conjunto.length, objetivo);
        System.out.println("Existe subconjunto que sume " + objetivo + "? " + existe);
        System.out.println();

        
        System.out.println(" Sudoku con backtracking");
        try {
            int[][] tablero = SudokuSolver.leerTablero("sudoku.txt");

            System.out.println("Tablero que el codigo lee:");
            SudokuSolver.imprimir(tablero);
            System.out.println();

            if (SudokuSolver.resolver(tablero)) {
                System.out.println("Solucion:");
                SudokuSolver.imprimir(tablero);
            } else {
                System.out.println("No tiene solucion.");
            }
        } catch (IOException e) {
            System.out.println("Fallo el codigo: " + e.getMessage());
        }
    }
}