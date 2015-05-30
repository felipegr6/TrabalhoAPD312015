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

@Entity
@Table(name = "prod_server2")
@NamedQueries({
    @NamedQuery(name = "ProdServer2.findAll", query = "SELECT p FROM ProdServer2 p"),
    @NamedQuery(name = "ProdServer2.findByCodigo", query = "SELECT p FROM ProdServer2 p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "ProdServer2.findByCategoria", query = "SELECT p FROM ProdServer2 p WHERE p.categoria = :categoria"),
    @NamedQuery(name = "ProdServer2.findByPreco", query = "SELECT p FROM ProdServer2 p WHERE p.preco = :preco"),
    @NamedQuery(name = "ProdServer2.findByDescricao", query = "SELECT p FROM ProdServer2 p WHERE p.descricao = :descricao")})
public class ProdServer2 implements Serializable {
    @Column(name = "id")
    private Integer id;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 20)
    @Column(name = "categoria")
    private String categoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Double preco;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;

    public ProdServer2() {
    }

    public ProdServer2(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof ProdServer2)) {
            return false;
        }

        ProdServer2 other = (ProdServer2) object;

        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }

        return true;

    }

    @Override
    public String toString() {
        return "br.mack.projeto.ejb.entities.ProdServer2[ codigo=" + codigo + " ]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
