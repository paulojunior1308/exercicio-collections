package br.com.dio.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;



public class Exercicio2 
{
    public static void main(String[] args) 
    {
        List<String> respostas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Perguntas: ");

        System.out.println("\nTelefonou para vítima? ");
        String resposta = scanner.next();
        respostas.add(resposta.toLowerCase());

        System.out.println("\nEsteve no local do crime? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());

        System.out.println("\nMora perto da vítima? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());

        System.out.println("\nDevia para vítima? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());

        System.out.println("\nJa trabalhou com a vítima? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());

        System.out.println(respostas);

        int i = 0;

        Iterator <String> contador = respostas.iterator();
        while (contador.hasNext()) 
        {
            String resp = contador.next();
            if(resp.contains("s"))
            {
                i ++;
            }    
        }

        switch (i) {
            case 2:
                System.out.println(">> SUSPEITA <<");
                break;
            
            case 3:

            case 4:
                System.out.println(">> CÚMPLICE <<");
                break;

            case 5:
                System.out.println(">> ASSASSINO <<");
                break;
        
            default:
                System.out.println(">> INOCENTE << ");
                break;
        }
    }
}
