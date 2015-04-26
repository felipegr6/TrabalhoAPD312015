/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.projeto.ejb.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "avaliacao_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvaliacaoProduto.findAll", query = "SELECT a FROM AvaliacaoProduto a"),
    @NamedQuery(name = "AvaliacaoProduto.findByIdAvaliacao", query = "SELECT a FROM AvaliacaoProduto a WHERE a.avaliacaoProdutoPK.idAvaliacao = :idAvaliacao"),
    @NamedQuery(name = "AvaliacaoProduto.findByIdProduto", query = "SELECT a FROM AvaliacaoProduto a WHERE a.avaliacaoProdutoPK.idProduto = :idProduto")})
public class AvaliacaoProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvaliacaoProdutoPK avaliacaoProdutoPK;
    @JoinColumn(name = "id_avaliacao", referencedColumnName = "id_avaliacao", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Avaliacao avaliacao;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    public AvaliacaoProduto() {
    }

    public AvaliacaoProduto(AvaliacaoProdutoPK avaliacaoProdutoPK) {
        this.avaliacaoProdutoPK = avaliacaoProdutoPK;
    }

    public AvaliacaoProduto(int idAvaliacao, int idProduto) {
        this.avaliacaoProdutoPK = new AvaliacaoProdutoPK(idAvaliacao, idProduto);
    }

    public AvaliacaoProdutoPK getAvaliacaoProdutoPK() {
        return avaliacaoProdutoPK;
    }

    public void setAvaliacaoProdutoPK(AvaliacaoProdutoPK avaliacaoProdutoPK) {
        this.avaliacaoProdutoPK = avaliacaoProdutoPK;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avaliacaoProdutoPK != null ? avaliacaoProdutoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvaliacaoProduto)) {
            return false;
        }
        AvaliacaoProduto other = (AvaliacaoProduto) object;
        if ((this.avaliacaoProdutoPK == null && other.avaliacaoProdutoPK != null) || (this.avaliacaoProdutoPK != null && !this.avaliacaoProdutoPK.equals(other.avaliacaoProdutoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mack.projeto.entities.AvaliacaoProduto[ avaliacaoProdutoPK=" + avaliacaoProdutoPK + " ]";
    }
    
}
