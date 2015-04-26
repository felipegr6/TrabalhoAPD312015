/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.projeto.ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Felipe
 */
@Embeddable
public class AvaliacaoProdutoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_avaliacao")
    private int idAvaliacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produto")
    private int idProduto;

    public AvaliacaoProdutoPK() {
    }

    public AvaliacaoProdutoPK(int idAvaliacao, int idProduto) {
        this.idAvaliacao = idAvaliacao;
        this.idProduto = idProduto;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAvaliacao;
        hash += (int) idProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvaliacaoProdutoPK)) {
            return false;
        }
        AvaliacaoProdutoPK other = (AvaliacaoProdutoPK) object;
        if (this.idAvaliacao != other.idAvaliacao) {
            return false;
        }
        if (this.idProduto != other.idProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mack.projeto.entities.AvaliacaoProdutoPK[ idAvaliacao=" + idAvaliacao + ", idProduto=" + idProduto + " ]";
    }
    
}
