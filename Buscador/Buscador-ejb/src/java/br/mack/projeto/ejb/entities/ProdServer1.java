package br.mack.projeto.ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "prod_server1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdServer1.findAll", query = "SELECT p FROM ProdServer1 p"),
    @NamedQuery(name = "ProdServer1.findByCodProduto", query = "SELECT p FROM ProdServer1 p WHERE p.codProduto = :codProduto"),
    @NamedQuery(name = "ProdServer1.findByDescProduto", query = "SELECT p FROM ProdServer1 p WHERE p.descProduto = :descProduto"),
    @NamedQuery(name = "ProdServer1.findByImgProduto", query = "SELECT p FROM ProdServer1 p WHERE p.imgProduto = :imgProduto"),
    @NamedQuery(name = "ProdServer1.findByNomeProduto", query = "SELECT p FROM ProdServer1 p WHERE p.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "ProdServer1.findByPreco", query = "SELECT p FROM ProdServer1 p WHERE p.preco = :preco")})
public class ProdServer1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_produto")
    private Integer codProduto;
    @Size(max = 500)
    @Column(name = "desc_produto")
    private String descProduto;
    @Size(max = 50)
    @Column(name = "img_produto")
    private String imgProduto;
    @Size(max = 200)
    @Column(name = "nome_produto")
    private String nomeProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Double preco;

    public ProdServer1() {
    }

    public ProdServer1(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProduto != null ? codProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdServer1)) {
            return false;
        }
        ProdServer1 other = (ProdServer1) object;
        if ((this.codProduto == null && other.codProduto != null) || (this.codProduto != null && !this.codProduto.equals(other.codProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mack.projeto.ejb.entities.ProdServer1[ codProduto=" + codProduto + " ]";
    }

}
