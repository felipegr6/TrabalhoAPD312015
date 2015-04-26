package br.mack.projeto.ejb.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "loja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loja.findAll", query = "SELECT l FROM Loja l"),
    @NamedQuery(name = "Loja.findByIdLoja", query = "SELECT l FROM Loja l WHERE l.idLoja = :idLoja"),
    @NamedQuery(name = "Loja.findByCnpj", query = "SELECT l FROM Loja l WHERE l.cnpj = :cnpj"),
    @NamedQuery(name = "Loja.findByNomeLoja", query = "SELECT l FROM Loja l WHERE l.nomeLoja = :nomeLoja"),
    @NamedQuery(name = "Loja.findByLocalizacao", query = "SELECT l FROM Loja l WHERE l.localizacao = :localizacao"),
    @NamedQuery(name = "Loja.findByTelefone", query = "SELECT l FROM Loja l WHERE l.telefone = :telefone"),
    @NamedQuery(name = "Loja.findByUrl", query = "SELECT l FROM Loja l WHERE l.url = :url"),
    @NamedQuery(name = "Loja.findByLogo", query = "SELECT l FROM Loja l WHERE l.logo = :logo")})
public class Loja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_loja")
    private Integer idLoja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome_loja")
    private String nomeLoja;
    @Size(max = 100)
    @Column(name = "localizacao")
    private String localizacao;
    @Size(max = 11)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "url")
    private String url;
    @Size(max = 50)
    @Column(name = "logo")
    private String logo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLoja")
    private List<Oferta> ofertaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loja")
    private List<AvaliacaoLoja> avaliacaoLojaList;

    public Loja() {
    }

    public Loja(Integer idLoja) {
        this.idLoja = idLoja;
    }

    public Loja(Integer idLoja, String cnpj, String nomeLoja, String url) {
        this.idLoja = idLoja;
        this.cnpj = cnpj;
        this.nomeLoja = nomeLoja;
        this.url = url;
    }

    public Integer getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Integer idLoja) {
        this.idLoja = idLoja;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @XmlTransient
    public List<Oferta> getOfertaList() {
        return ofertaList;
    }

    public void setOfertaList(List<Oferta> ofertaList) {
        this.ofertaList = ofertaList;
    }

    @XmlTransient
    public List<AvaliacaoLoja> getAvaliacaoLojaList() {
        return avaliacaoLojaList;
    }

    public void setAvaliacaoLojaList(List<AvaliacaoLoja> avaliacaoLojaList) {
        this.avaliacaoLojaList = avaliacaoLojaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLoja != null ? idLoja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loja)) {
            return false;
        }
        Loja other = (Loja) object;
        if ((this.idLoja == null && other.idLoja != null) || (this.idLoja != null && !this.idLoja.equals(other.idLoja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mack.projeto.entities.Loja[ idLoja=" + idLoja + " ]";
    }

}
