package br.mack.projeto.ejb.produtos;

public class ProdutoServer2 implements AbstractProduto {

    private int codigo;
    private String categoria;
    private String descricao;
    private double preco;
    private int id;

    public ProdutoServer2(String nome, double preco) {
        this.categoria = nome;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String getNome() {
        return descricao;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getDescricao() {
        return "";
    }

    @Override
    public int compareTo(AbstractProduto o) {

        if (this.getPreco() == o.getPreco()) {
            return 0;
        }
        if (this.getPreco() > o.getPreco()) {
            return 1;
        } else {
            return -1;
        }

    }

}
