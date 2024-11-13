package padrao;

import java.util.Scanner;

/**
 *
 * @author Sarah
 */
public class Ex03_Grafos {

    //método para imprimir todas as arestas do grafo
    public static void imprimirArestas(int[][] matrizAdj, int vertices){
        System.out.println("\nArestas do grafo (pares ordenados com pesos): ");
        
        //percorre a matriz na metade superior (sem a diagonal)
        for(int i = 0; i < vertices; i++){
            for(int j = i + 1; j < vertices; j++){
                //se a posição (i,j) tem valor diferente de zero, então tem uma areats entre os vértices i e j
                if (matrizAdj[i][j] != 0){
                    //imprime o par de vértices e o peso da aresta entre eles
                    System.out.println("(" + i + ", " + j + ") - Peso: " + matrizAdj[i][j]);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        //cria um objeto para ler dados
        Scanner entrada = new Scanner(System.in);
        
        //pede ao usuario o numero de vertices e lê o valor
        System.out.println("insira o número de vértices: ");
        int vertices = entrada.nextInt();
        
        //cria uma matriz quadrada com tamanho baseado no numero de vertices
        int[][] matrizAdj = new int[vertices][vertices];
        
        System.out.println("Insira a matriz de adjacência (separado por espaço):");
        
        //lê cada linha e coluna da matriz, preenchendo com os valores inseridos
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                //lê o proximo valor inserido e armazena na posição [i][j] da matriz
                matrizAdj[i][j] = entrada.nextInt();
            }
        }
        
        entrada.close();
        //chama o método para imprimir as arestas, passando a matriz e o numero de vertices
        imprimirArestas(matrizAdj, vertices);
    }   
}