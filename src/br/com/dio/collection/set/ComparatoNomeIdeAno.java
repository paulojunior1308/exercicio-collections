package br.com.dio.collection.set;

import java.util.Comparator;

public class ComparatoNomeIdeAno 
{
     public class ComparatorIde implements Comparator<LinguagemFavorita>
    {
        @Override
        public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2)
        {
            return lf1.ide.compareToIgnoreCase(lf2.ide);
        }
    }

    public class ComparatoAnoDeCriacaoENome implements Comparator<LinguagemFavorita>
    {
        @Override
        public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2)
        {
            int anoDeCriacao = Integer.compare(lf1.anoDeCriacao, lf2.anoDeCriacao);
            if(anoDeCriacao != 0) return anoDeCriacao;
            return lf1.nome.compareToIgnoreCase(lf2.nome);
        }
    }

    public class ComparatorNomeAnoDeCriacaoIde implements Comparator<LinguagemFavorita>
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
}
