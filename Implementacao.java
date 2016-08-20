/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yuri
 */
import java.util.Random;

public class Implementacao 
{
    public static void main(String[] args)
    {
        /**
         * Aqui são declarados dois vetores do Tipo Integer
         * para a realização dos testes de comparações entre
         * os métodos Insertion Sort e o MergeSort,eles vão
         * variar de acordo com a sequência dos números aleatórios gerados.
         */
        Vector<Integer> v  = new Vector<Integer>(10);
        Vector<Integer> v2 = new Vector<Integer>(10);
        
        /**
         * Declaração da variavél de referência de nome gerador,que instância 
         * objetos da Classe Random,sendo que esse gerador será responsável por
         * gerar os números aleatórios para os vetores
         */
        Random gerador = new Random();        
        
        /**
         * Aqui são declaradas variáveis primitivas do tipo int
         */
        int num;      
        int i=0;
        
        /**
         * Este laço faz a atribuição dos valores gerados randomicamente
         * no vetor.
         */
        while(i<v.getCapacity())
        {
            num=gerador.nextInt(100);
            v.add(i, num);
            i++;
        }
        
              
         /**
          * Aqui o vetor é ordenado pelo algoritmo do MergeSort
          */
        v.sort();
        
                
        /**
         * Aqui é é declarada uma variável primitiva do tipo inteiro,que já
         * é inicializada com o valor de comparações que foram feitas pelo
         * algoritmo do mergesort
         */
        int mergesort = v.getCount2();
        
        /**
         * Aqui é declarada uma  variável primitiva do tipo int
         */
        int k=0;
        
        
        /**
         * Este laço faz a atribuição dos valores gerados randomicamente
         * no vetor.
         */
        while(k<v2.getCapacity())
        {
            num=gerador.nextInt(100);
            v2.add(k, num);
            k++;
        }
        
               
          /**
          * Aqui o vetor é ordenado pelo algoritmo do InsertionSort
          */
        v2.InsertionSort();
        
        
                
        /**
         * Aqui é é declarada uma variável primitiva do tipo inteiro,que já
         * é inicializada com o valor de comparações que foram feitas pelo
         * algoritmo do insertionsort
         */ 
        int insertion = v2.getCount();
        
        /**
         * Aqui trás o resultados das comparações feito pelos dois algoritmos
         */
        System.out.println("MergeSort: "+mergesort+" comparações");
        System.out.println("InsertionSort: "+insertion+" comparações");
        
        
    }
    
}
