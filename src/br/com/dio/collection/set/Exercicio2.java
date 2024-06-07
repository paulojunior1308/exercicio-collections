package br.com.dio.collection.set;

import java.util.*;




/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/

public class Exercicio2 
{
    public static void main(String[] args) 
    {
        Set<LinguagemFavorita> minhasLinguagemFavoritas = new HashSet<>(); 
        minhasLinguagemFavoritas.add(new LinguagemFavorita("Python", 1991, "Pycharm"));
        minhasLinguagemFavoritas.add(new LinguagemFavorita("JavaScript", 1995, "IntelliJ"));
        minhasLinguagemFavoritas.add(new LinguagemFavorita("Java", 1991, "Visual Studio Code"));

        System.out.println("---\tOrdem de Inserção\t---");
        Set<LinguagemFavorita> minhasLinguagemFavoritas1 = new LinkedHashSet<>(
            Arrays.asList(
            new LinguagemFavorita("Python", 1991, "Pycharm"),
            new LinguagemFavorita("JavaScript", 1995, "IntelliJ"),
            new LinguagemFavorita("Java", 1991, "Visual Studio Code")));
        
        for (LinguagemFavorita linguagem : minhasLinguagemFavoritas1) System.out.println(linguagem);

        System.out.println("---\tOrdem Natural: Nome\t---");
        Set<LinguagemFavorita> minhLinguagemFavoritas1 = new TreeSet<>(minhasLinguagemFavoritas);
        for (LinguagemFavorita linguagemFavorita : minhLinguagemFavoritas1) System.out.println(linguagemFavorita);


        System.out.println("---\tOdem IDE\t---");
        Set<LinguagemFavorita> minhLinguagemFavoritas2 = new TreeSet<LinguagemFavorita>(new ComparatorIde());
        minhLinguagemFavoritas2.addAll(minhasLinguagemFavoritas);
        for (LinguagemFavorita linguagemFavorita : minhLinguagemFavoritas2) System.out.println(linguagemFavorita);
        

        System.out.println("---\tOrdem Ano de Criação e Nome\t---");
        Set<LinguagemFavorita> minhLinguagemFavoritas3 = new TreeSet<LinguagemFavorita>(new ComparatoAnoDeCriacaoENome());
        minhLinguagemFavoritas3.addAll(minhasLinguagemFavoritas);
        for (LinguagemFavorita linguagemFavorita : minhLinguagemFavoritas3) System.out.println(linguagemFavorita);

        System.out.println("---\tOrdem Nome - Ano de Criação - IDE\t---");
        Set <LinguagemFavorita> minhLinguagemFavorita4 = new TreeSet<LinguagemFavorita>(new ComparatorNomeAnoDeCriacaoIde());
        minhLinguagemFavorita4.addAll(minhLinguagemFavoritas2);
        for (LinguagemFavorita linguagemFavorita : minhLinguagemFavorita4) System.out.println(linguagemFavorita);
    }
}

class ComparatorIde implements Comparator<LinguagemFavorita>
    {
        @Override
        public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2)
        {
            return lf1.ide.compareToIgnoreCase(lf2.ide);
        }
    }

class ComparatoAnoDeCriacaoENome implements Comparator<LinguagemFavorita>
    {
        @Override
        public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2)
        {
            int anoDeCriacao = Integer.compare(lf1.anoDeCriacao, lf2.anoDeCriacao);
            if(anoDeCriacao != 0) return anoDeCriacao;
            return lf1.nome.compareToIgnoreCase(lf2.nome);
        }
    }

class ComparatorNomeAnoDeCriacaoIde implements Comparator<LinguagemFavorita>
{
    @Override
    public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2)
    {
        int nome = lf1.nome.compareToIgnoreCase(lf2.nome);
        int anoDeCriacao = Integer.compare(lf1.anoDeCriacao, lf2.anoDeCriacao);
        if (nome != 0) return nome;
        if (anoDeCriacao != 0) return anoDeCriacao;
        return lf1.ide.compareToIgnoreCase(lf2.ide);
    }
}