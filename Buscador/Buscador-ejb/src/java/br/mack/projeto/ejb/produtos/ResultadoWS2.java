package br.mack.projeto.ejb.produtos;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ResultadoWS2 {

    private List<ProdutoServer2> produtos;
    @SerializedName("nome")
    private String nomeLoja;
    @SerializedName("descricao")
    private String descricaoLoja;
    private int id;

    public List<ProdutoServer2> getProdutos() {
        return produtos;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public String getDescricaoLoja() {
        return descricaoLoja;
    }

    public int getId() {
        return id;
    }

}
