package br.com.dio.collection.streamAPI;

import java.util.*;
import java.util.stream.Collectors;


public class ExerciciosStreamAPI 
{
    public static void main(String[] args) 
    {
        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");
        
        System.out.println("Imprima todos os elementos dessa lista de String: ");
        numerosAleatorios.stream().forEach(System.out::println);

// ------------------------------------------------------------------------------------------------------------------ 
        System.out.println("-----------------------------------------------------------");
        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set: ");
        numerosAleatorios.stream()
            .limit(5)
            .collect(Collectors.toSet())
            .forEach(System.out::println);

// ------------------------------------------------------------------------------------------------------------------ 
        System.out.println("-----------------------------------------------------------");
        System.out.println("Transforme esta lista de String em uma lista de números inteiros: ");
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        /*numerosAleatorios.stream()
            .map(s -> Integer.parseInt(s))
            .forEach(System.out::println);*/

        /*numerosAleatorios.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList())
            .forEach(System.out::println);*/

// ------------------------------------------------------------------------------------------------------------------ 
        System.out.println("-----------------------------------------------------------");
        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista: ");
        numerosAleatorios.stream()
            .map(Integer::parseInt)
            .filter(i -> i % 2 == 0 && i > 2)
            .collect(Collectors.toList())
            .forEach(System.out::println);

        /*List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
            .map(Integer::parseInt)
            .filter(i -> (i % 2 == 0 && i > 2))
            .collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);*/
            
// ------------------------------------------------------------------------------------------------------------------ 
        System.out.println("-----------------------------------------------------------");
        System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream()
            .mapToInt(Integer :: parseInt)
            .average()
            .ifPresent(System.out::println);

// ------------------------------------------------------------------------------------------------------------------ 
        System.out.println("-----------------------------------------------------------");
        System.out.println("Remova os valores impares: ");
        numerosAleatoriosInteger.removeIf(i -> i % 2 != 0);
        System.out.println(numerosAleatoriosInteger);

// ------------------------------------------------------------------------------------------------------------------ 
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante: ");
        numerosAleatoriosInteger.stream()
            .skip(3)
            .forEach(System.out::println);
    
 // ------------------------------------------------------------------------------------------------------------------ 
        System.out.println("-----------------------------------------------------------");   
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? ");
        long countNumerosUnicos = numerosAleatoriosInteger.stream()
            .distinct()
            .count();
        System.out.println(countNumerosUnicos);
    
 // ------------------------------------------------------------------------------------------------------------------ 
        System.out.println("-----------------------------------------------------------");   
        System.out.println("Mostre o menor valor da lista: ");
        numerosAleatoriosInteger.stream()
            .mapToInt(Integer::intValue)
            .min()
            .ifPresent(System.out::println);

 // ------------------------------------------------------------------------------------------------------------------ 
        System.out.println("-----------------------------------------------------------");   
        System.out.println("Mostre o maior valor da lista: ");
        numerosAleatoriosInteger.stream()
            .mapToInt(Integer::intValue)
            .max()
            .ifPresent(System.out::println);

 // ------------------------------------------------------------------------------------------------------------------ 
        System.out.println("-----------------------------------------------------------");       
        System.out.println("Pegue apenas os números ímpares e some: ");
        Integer soma = numerosAleatoriosInteger.stream()
            .filter(i -> (i % 2 == 0))
            .mapToInt(Integer::intValue)
            .sum();
        System.out.println(soma);

// ------------------------------------------------------------------------------------------------------------------ 
        System.out.println("-----------------------------------------------------------");
        System.out.println("Mostre a lista em ordem númerica: ");
        List<Integer> numerosOrdem = numerosAleatoriosInteger.stream()
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
        System.out.println(numerosOrdem);
    
// ------------------------------------------------------------------------------------------------------------------ 
        System.out.println("-----------------------------------------------------------");
        System.out.println("Agrupe os valores impares múltiplos de 3 e de 5: ");
        Map<Boolean, List<Integer>> collectNumeros = numerosAleatoriosInteger.stream()
            .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(collectNumeros);

    }    
}
