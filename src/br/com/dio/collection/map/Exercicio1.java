package br.com.dio.collection.map;

import java.util.*;
/*
 * Dada a população estimada de alguns estados do NE brasileiro, faça:
 * 
 *  Estado: PE - População: 9616621
 *  Estado: AL - População: 3351543
 *  Estado: CE - População: 9187103
 *  Estado: RN - População: 3534265
 */
public class Exercicio1 
{
    public static void main(String[] args) 
    {
        System.out.println("Crie um dicionário e relacione os estados e suas populações: ");
        Map<String, Integer> estadoPopulacao = new HashMap<>()
        {
            {
                put("PE", 9616621);
                put("AL", 3351543);
                put("CE", 9187103);
                put("RN", 3534265);
            }
        };
        System.out.println(estadoPopulacao);

// ---------------------------------------------------------------------------------------------------------
        System.out.println("Substitua a população do estado do RN por 3534165: ");
        estadoPopulacao.put("RN", 3534165);
        System.out.println(estadoPopulacao);

// ---------------------------------------------------------------------------------------------------------
        System.out.println("Confira se o estado PB está no dicionário, caso não adicione: PB - 4039277: ");
        
        if (!estadoPopulacao.containsKey("PB"))
        {
            estadoPopulacao.put("PB", 4039277);
        }
        System.out.println(estadoPopulacao);
 
// --------------------------------------------------------------------------------------------------------       
        System.out.println("Exiba a população PE: ");
        System.out.println(estadoPopulacao.get("PE"));

// --------------------------------------------------------------------------------------------------------
        System.out.println("Exiba todos os estados e suas popualções na ordem que foi informado: ");
        Map<String, Estado> estadoPopulacao1 = new LinkedHashMap<>()
        {
            {
                put("PE", new Estado("PE", 9616621));
                put("AL", new Estado("AL", 3351543));
                put("CE", new Estado("CE", 9187103));
                put("RN", new Estado("RN", 3534265));
               
            }
        };
        for (Map.Entry<String, Estado> estado : estadoPopulacao1.entrySet()) 
        {
            System.out.println(estado.getKey() + " - " + estado.getValue().getPopulacao());    
        }

// ---------------------------------------------------------------------------------------------------------        
        System.out.println("Exiba os estados e suas populações em ordem alfabética: ");
        Map<String, Estado> estadoPopulacao2 = new TreeMap<>(estadoPopulacao1);
        for (Map.Entry<String, Estado> estado: estadoPopulacao2.entrySet())
        {
            System.out.println(estado.getKey() + " - " + estado.getValue().getPopulacao());
        }

// ---------------------------------------------------------------------------------------------------------
        System.out.println("Exiba o estado com o menor população e sua quantidade: ");
        Integer menosPopulacao = Collections.min(estadoPopulacao.values());
        String menosPopuloso = " ";
        for (Map.Entry<String, Integer> entry : estadoPopulacao.entrySet())
        {
            if(entry.getValue().equals(menosPopulacao))
            {
                menosPopuloso = entry.getKey();
                System.out.println(menosPopulacao);    
            }
        }

// ----------------------------------------------------------------------------------------------------------        
        System.out.println("Exiba o estado com a maior população e sua quantidade: ");
        Integer maiorPopulacao = Collections.max(estadoPopulacao.values());
        String maisPopuloso = "";
        for (Map.Entry<String, Integer> entry : estadoPopulacao.entrySet()) 
        {
            if(entry.getValue().equals(maiorPopulacao))
            {
                maisPopuloso = entry.getKey();
                System.out.println(maiorPopulacao);
            }    
        }

// -----------------------------------------------------------------------------------------------------------
        System.out.println("Exiba a soma da população desses estados: ");
        Iterator<Integer> iterator = estadoPopulacao.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext())
        {
            soma += iterator.next();    
        }
        System.out.println(soma);

// -----------------------------------------------------------------------------------------------------------
        System.out.println("Exiba a média da população deste dicionário de estados: ");
        System.out.println((soma/estadoPopulacao.size()));

// -----------------------------------------------------------------------------------------------------------     
        System.out.println("Remova os estados com a população menor que 4000000: ");
        Iterator <Integer> iterator2 = estadoPopulacao.values().iterator();
        while (iterator2.hasNext()) 
        {
            if (iterator2.next() <= 4000000) iterator2.remove();    
        }
        System.out.println(estadoPopulacao);

// ----------------------------------------------------------------------------------------------------------        
        System.out.println("Apague o dicionário de estados: ");
        estadoPopulacao.clear();

// ----------------------------------------------------------------------------------------------------------
        System.out.println("Confira se o dicionário está vazio: ");
        System.out.println(estadoPopulacao.isEmpty());
    }   
}


class Estado 
{
    private String estado;
    private Integer populacao;

    public Estado (String estado, Integer populacao)
    {
        this.estado = estado;
        this.populacao = populacao;
    }

    public String getEstado()
    {
        return estado;
    }

    public Integer getPopulacao()
    {
        return populacao;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return estado.equals(estado.estado) && populacao.equals(estado.populacao);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(estado, populacao);
    }

    @Override
    public String toString()
    {
        return "{" +
        "estado: '" + estado + '\'' +
        ", populacao: '" + populacao + '\'' + '}';
    }
}