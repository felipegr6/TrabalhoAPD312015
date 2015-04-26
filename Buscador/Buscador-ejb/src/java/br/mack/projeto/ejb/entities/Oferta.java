/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.projeto.ejb.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "oferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findByIdOferta", query = "SELECT o FROM Oferta o WHERE o.idOferta = :idOferta"),
    @NamedQuery(name = "Oferta.findByDescricao", query = "SELECT o FROM Oferta o WHERE o.descricao = :descricao"),
    @NamedQuery(name = "Oferta.findByPreco", query = "SELECT o FROM Oferta o WHERE o.preco = :preco"),
    @NamedQuery(name = "Oferta.findByUrlOferta", query = "SELECT o FROM Oferta o WHERE o.urlOferta = :urlOferta"),
    @NamedQuery(name = "Oferta.findByDataCadastro", query = "SELECT o FROM Oferta o WHERE o.dataCadastro = :dataCadastro")})
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_oferta")
    private Integer idOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preco")
    private double preco;
    @Size(max = 50)
    @Column(name = "url_oferta")
    private String urlOferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIME)
    private Date dataCadastro;
    @JoinColumn(name = "id_loja", referencedColumnName = "id_loja")
    @ManyToOne(optional = false)
    private Loja idLoja;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto idProduto;

    public Oferta() {
    }

    public Oferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public Oferta(Integer idOferta, String descricao, double preco, Date dataCadastro) {
        this.idOferta = idOferta;
        this.descricao = descricao;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getUrlOferta() {
        return urlOferta;
    }

    public void setUrlOferta(String urlOferta) {
        this.urlOferta = urlOferta;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Loja getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Loja idLoja) {
        this.idLoja = idLoja;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOferta != null ? idOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.idOferta == null && other.idOferta != null) || (this.idOferta != null && !this.idOferta.equals(other.idOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mack.projeto.entities.Oferta[ idOferta=" + idOferta + " ]";
    }
    
}
