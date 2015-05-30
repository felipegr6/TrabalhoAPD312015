package br.mack.projeto.ejb.produtos;

public interface AbstractProduto extends Comparable<AbstractProduto> {

    double getPreco();

    String getNome();

    String getDescricao();

}
