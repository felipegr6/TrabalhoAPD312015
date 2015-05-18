package br.mack.projeto.ejb.produtos;

public class ProdutoServer1 {

    private CategoriaServer1 codCategoria;
    private int codProduto;
    private String descProduto;
    private String imgProduto;
    private String nomeProduto;
    private double preco;

    public ProdutoServer1(CategoriaServer1 codCategoria, int codProduto, String descProduto, String imgProduto, String nomeProduto, double preco) {
        this.codCategoria = codCategoria;
        this.codProduto = codProduto;
        this.descProduto = descProduto;
        this.imgProduto = imgProduto;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
    }

    public CategoriaServer1 getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(CategoriaServer1 codCategoria) {
        this.codCategoria = codCategoria;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public String getImgProduto() {
        return imgProduto;
    }

    public void setImgProduto(String imgProduto) {
        this.imgProduto = imgProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
