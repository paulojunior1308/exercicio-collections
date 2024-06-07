package br.com.dio.collection.set;

/*
Crie uma conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */

import java.util.*;

public class Exercicio1 
{
    public static void main(String[] args) 
    {
        System.out.println("Crie um conjunto contendo as cores do arco-íris: ");
        Set <String> coresArcoIris = new HashSet<>();
        coresArcoIris.add("violeta");
        coresArcoIris.add("anil");
        coresArcoIris.add("azul");
        coresArcoIris.add("verde");
        coresArcoIris.add("amarelo");
        coresArcoIris.add("laranja");
        coresArcoIris.add("vermelho");
        System.out.println(coresArcoIris);

        System.out.println("Exiba todas as cores do arco-íris uma abaixo da outra: ");
        for (String cor : coresArcoIris) 
        {
            System.out.println(cor);    
        }

        System.out.println("A quantidade de cores que o arco-íris tem: " + coresArcoIris.size());

        System.out.println("Exiba as cores em ordem alfabética: ");
        Set <String> coresArcoIris1 = new TreeSet<>(coresArcoIris);
        System.out.println(coresArcoIris1);

        System.out.println("Exiba as cores na ordem inversa da que foi informada: ");
        Set <String> coresArcoIris2 = new LinkedHashSet<>(Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelho"));
        System.out.println(coresArcoIris2);
        List <String> coresArcoIrisList = new ArrayList<>(coresArcoIris2);
        Collections.reverse(coresArcoIrisList);
        System.out.println(coresArcoIrisList);

        System.out.println("Exiba todas as cores que começam com a letra ”v”: ");
        Iterator <String> iterator = coresArcoIris.iterator();
        while (iterator.hasNext())
        {
            if(!iterator.next().startsWith("v")) iterator.remove();    
        }
        System.out.println(coresArcoIris);

        System.out.println("Limpe o conjunto: ");
        coresArcoIris.clear();
        System.out.println("Confira se o conjunto está vazio: " + coresArcoIris.isEmpty());

    }
}
