package padrao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Sarah
 */

public class Ex04_Grafos {

    //método para completar a matriz usando sua simetria
    public static void completaMatriz(int[][] matrizAdj, int n) {
        
        //para cada elemento acima da diagonal principal, copia o valor correspondente de baixo da diagonal
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //atribui a posição (i,j) com o valor da posição simétrica (j,i)
                matrizAdj[i][j] = matrizAdj[j][i];
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            //define o caminho do arquivo contendo a matriz triangular inferior 
            File arquivo = new File("C:/Users/sjand_c05zfsv/OneDrive/Documentos/NetBeansProjects/Ex04_Grafos/entrada.txt");
            Scanner scanner = new Scanner(arquivo); //cria um objeto scanner para ler o arquivo
 
            //lê um número inteiro n, representando o tamanho da matriz quadrada
            int n = scanner.nextInt();
 
            //cria uma matriz (n x n) quadrada com todos os valores inicialmente zerados
            int[][] matrizAdj = new int[n][n];
 
            //lê a parte triangular inferior da matriz
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    //atribui cada valor lido à posição (i,j) da matriz
                    matrizAdj[i][j] = scanner.nextInt();
                }
            }
            
            scanner.close();
 
            //chama o método para completar a matriz usando simetria
            completaMatriz(matrizAdj, n);
 
            // Exibe a matriz completa
            System.out.println("Matriz de Adjacência Completa:\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //exibe cada elemento da linha i, separando por um espaço
                    System.out.print(matrizAdj[i][j] + " ");
                }
                System.out.println();
            }
 
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado.");
            e.printStackTrace();
        }
    }
}