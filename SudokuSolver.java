package com.mycompany.actividad3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SudokuSolver {

    static final int SIZE = 9;

    // Lee el tablero desde un archivo .txt con 9 líneas de 9 dígitos pegados (sin espacios)
    // Ejemplo de línea: 740000009
    public static int[][] leerTablero(String rutaArchivo) throws IOException {
        int[][] tablero = new int[SIZE][SIZE];
        BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));

        String linea;
        int fila = 0;
        while ((linea = lector.readLine()) != null && fila < SIZE) {
            linea = linea.trim();
            if (linea.isEmpty()) continue; // ignora líneas vacías

            for (int col = 0; col < SIZE; col++) {
                char c = linea.charAt(col);
                tablero[fila][col] = c - '0'; // convierte el carácter a número entero
            }
            fila++;
        }
        lector.close();
        return tablero;
    }

    public static boolean resolver(int[][] tablero) {
        for (int fila = 0; fila < SIZE; fila++) {
            for (int col = 0; col < SIZE; col++) {
                if (tablero[fila][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (esValido(tablero, fila, col, num)) {
                            tablero[fila][col] = num;
                            if (resolver(tablero)) return true;
                            tablero[fila][col] = 0; // backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean esValido(int[][] tablero, int fila, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (tablero[fila][i] == num || tablero[i][col] == num) return false;
        }
        int filaInicio = fila - fila % 3;
        int colInicio = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[filaInicio + i][colInicio + j] == num) return false;
            }
        }
        return true;
    }

    public static void imprimir(int[][] tablero) {
        for (int fila = 0; fila < SIZE; fila++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < SIZE; col++) {
                sb.append(tablero[fila][col]).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}