package br.com.dio.collection.map;
import java.util.*;

/*Faça um programa que simule um lançamento de dados. Lance o dado 100 vezes e armazene.
 * Despois, mostre quantas vezes cada valor foi conseguido.
 */
public class Exercicio2 
{
    public static void main(String[] args) 
    {
        int qntLacamentos = 100;
        
        List<Integer> valores = new ArrayList<>();
        Random geradorDeLancamentos = new Random();
        for (int i = 0; i < qntLacamentos; i++)
        {
            int num = geradorDeLancamentos.nextInt(6) + 1;
            valores.add(num);
        }

        Map<Integer, Integer> lancamentos = new HashMap<>();
        for(Integer resultado : valores)
        {
            if (lancamentos.containsKey(resultado))
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            else lancamentos.put(resultado, 1);
        }

        System.out.println("Jogando");
        for(int i = 0; i < 3; i++)
        {
            try {
                Thread.sleep(3000);
                System.out.println(".");
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("\nValor " + " Quantidade de vezes");
        for (Map.Entry <Integer, Integer> entry : lancamentos.entrySet()) 
        {
            System.out.printf("%3d %10d\n", entry.getKey(), entry.getValue());    
        }
    }    
}
