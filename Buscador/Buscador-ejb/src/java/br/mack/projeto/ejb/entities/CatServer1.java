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
@Table(name = "cat_server1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatServer1.findAll", query = "SELECT c FROM CatServer1 c"),
    @NamedQuery(name = "CatServer1.findByCodCategoria", query = "SELECT c FROM CatServer1 c WHERE c.codCategoria = :codCategoria"),
    @NamedQuery(name = "CatServer1.findByNomeCategoria", query = "SELECT c FROM CatServer1 c WHERE c.nomeCategoria = :nomeCategoria")})
public class CatServer1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_categoria")
    private Integer codCategoria;
    @Size(max = 25)
    @Column(name = "nome_categoria")
    private String nomeCategoria;

    public CatServer1() {
    }

    public CatServer1(Integer codCategoria) {
        this.codCategoria = codCategoria;
    }

    public Integer getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(Integer codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCategoria != null ? codCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof CatServer1)) {
            return false;
        }
        CatServer1 other = (CatServer1) object;
        if ((this.codCategoria == null && other.codCategoria != null) || (this.codCategoria != null && !this.codCategoria.equals(other.codCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mack.projeto.ejb.entities.CatServer1[ codCategoria=" + codCategoria + " ]";
    }

}
