/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grafo;

/**
 *
 * @author bruno costa rezende
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grafo_EX2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de vértices: ");
        int n = scanner.nextInt();
        scanner.close();

        // Criando e imprimindo a matriz de adjacência
        int[][] matrizAdjacencia = new int[n][n];
        System.out.println("\nMatriz de Adjacência:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    matrizAdjacencia[i][j] = 1;
                }
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }

        // Criando e imprimindo a lista de adjacências
        List<List<Integer>> listaAdjacencias = new ArrayList<>();
        System.out.println("\nLista de Adjacências:");
        for (int i = 0; i < n; i++) {
            List<Integer> adjacentes = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    adjacentes.add(j);
                }
            }
            listaAdjacencias.add(adjacentes);
            System.out.println("Vértice " + i + ": " + adjacentes);
        }
    }
}
