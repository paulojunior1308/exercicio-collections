package br.com.dio.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Exercicio1 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<>();

        int i = 0;

        while (true)
        {
            if (i == 6) break;

            System.out.println("Digite a temperatura: ");
            double tempe = scanner.nextDouble();
            temperaturas.add(tempe);
            i++;
        }

        System.out.println("-------------");

        System.out.println("Todas as temperaturas: ");
        temperaturas.forEach(t -> System.out.println(t + " "));

        double media = temperaturas.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0d);

        System.out.printf("\nMédia das temperaturas: %.1f\n", media);

        System.out.println("Temperaturas acima da média: ");
        temperaturas.stream()
                    .filter(t -> t > media)
                    .forEach(t -> System.out.printf("%.1f ", t));

        System.out.println("\n\nMeses das temperaturas acima da média: ");

        Iterator<Double> iterator = temperaturas.iterator();

        i = 0;
        while (iterator.hasNext()) 
        {
            Double tempe = iterator.next();
            
            if (tempe > media)
            {
                switch (i)
                {
                    case (0):
                        System.out.printf("1 - Janeiro: %.1f\n ", tempe);
                        break;

                    case (1):
                    System.out.printf("2 - Fevereiro: %.1f\n ", tempe);
                    break;
                        
                    case (2):
                    System.out.printf("3 - Março: %.1f\n ", tempe);
                    break;

                    case (3):
                    System.out.printf("4 - Abril: %.1f\n ", tempe);
                    break;

                    case (4):
                    System.out.printf("5 - Maio: %.1f\n ", tempe);
                    break;

                    case (5):
                    System.out.printf("6 - Junho: %.1f\n ", tempe);
                    break;

                    default:
                        System.out.println("Não houve temperatura acima da média.");
                }
            }
            i++;
        }
    }
}
