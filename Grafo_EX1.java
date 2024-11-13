/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grafo;

/**
 *
 * @author bruno costa rezende
 */
import java.util.*;

public class Grafo_EX1 {
    private int[][] matrizAdjacencia;
    private int vertices;

    public Grafo_EX1(int vertices, int[][] matriz) {
        this.vertices = vertices;
        this.matrizAdjacencia = matriz;
    }

    // a) Quais são as arestas do grafo?
    public List<String> obterArestas() {
        List<String> arestas = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            for (int j = (isDirigido() ? 0 : i); j < vertices; j++) {
                if (matrizAdjacencia[i][j] != 0) {
                    arestas.add("(" + i + ", " + j + ")");
                }
            }
        }
        return arestas;
    }

    // b) É um dígrafo ou um grafo não-direcionado?
    public boolean isDirigido() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (matrizAdjacencia[i][j] != matrizAdjacencia[j][i]) {
                    return true; 
                }
            }
        }
        return false; // Grafo não-dirigido
    }

    // c) Qual é o grau de cada vértice?
    public int[] grausVertices() {
        int[] graus = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (matrizAdjacencia[i][j] != 0) {
                    graus[i]++;
                }
            }
        }
        return graus;
    }

    // d) O grafo é conexo ou desconexo?
    public boolean isConexo() {
        boolean[] visitado = new boolean[vertices];
        dfs(0, visitado);
        for (boolean v : visitado) {
            if (!v) return false; 
        }
        return true;
    }

    private void dfs(int vertice, boolean[] visitado) {
        visitado[vertice] = true;
        for (int i = 0; i < vertices; i++) {
            if (matrizAdjacencia[vertice][i] != 0 && !visitado[i]) {
                dfs(i, visitado);
            }
        }
    }

    // e) O grafo é cíclico ou acíclico?
    public boolean isCiclico() {
        boolean[] visitado = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visitado[i] && dfsCiclo(i, visitado, -1)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfsCiclo(int vertice, boolean[] visitado, int pai) {
        visitado[vertice] = true;
        for (int i = 0; i < vertices; i++) {
            if (matrizAdjacencia[vertice][i] != 0) {
                if (!visitado[i]) {
                    if (dfsCiclo(i, visitado, vertice)) return true;
                } else if (i != pai) {
                    return true;
                }
            }
        }
        return false;
    }

    // f) Qual é a lista de adjacências do mesmo grafo?
    public List<List<Integer>> obterListaAdjacencia() {
        List<List<Integer>> listaAdjacencia = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            List<Integer> adjacentes = new ArrayList<>();
            for (int j = 0; j < vertices; j++) {
                if (matrizAdjacencia[i][j] != 0) {
                    adjacentes.add(j);
                }
            }
            listaAdjacencia.add(adjacentes);
        }
        return listaAdjacencia;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o numero de vertices: ");
        int vertices = scanner.nextInt();
        
        int[][] matriz = new int[vertices][vertices];
        System.out.println("Digite a matriz de adjacencias:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        Grafo_EX1 grafo = new Grafo_EX1(vertices, matriz);

        System.out.println("Arestas do grafo: " + grafo.obterArestas());
        System.out.println("E um digrafo? " + grafo.isDirigido());
        System.out.println("Grau de cada vertice: " + Arrays.toString(grafo.grausVertices()));
        System.out.println("O grafo e conexo? " + grafo.isConexo());
        System.out.println("O grafo e ciclico? " + grafo.isCiclico());
        System.out.println("Lista de adjacencias: " + grafo.obterListaAdjacencia());
        
        scanner.close();
    }
}
