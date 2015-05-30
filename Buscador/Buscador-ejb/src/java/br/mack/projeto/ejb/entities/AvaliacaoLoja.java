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

@Entity
@Table(name = "avaliacao_loja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvaliacaoLoja.findAll", query = "SELECT a FROM AvaliacaoLoja a"),
    @NamedQuery(name = "AvaliacaoLoja.findByIdAvaliacao", query = "SELECT a FROM AvaliacaoLoja a WHERE a.avaliacaoLojaPK.idAvaliacao = :idAvaliacao"),
    @NamedQuery(name = "AvaliacaoLoja.findByIdLoja", query = "SELECT a FROM AvaliacaoLoja a WHERE a.avaliacaoLojaPK.idLoja = :idLoja")})
public class AvaliacaoLoja implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvaliacaoLojaPK avaliacaoLojaPK;
    @JoinColumn(name = "id_avaliacao", referencedColumnName = "id_avaliacao", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Avaliacao avaliacao;
    @JoinColumn(name = "id_loja", referencedColumnName = "id_loja", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Loja loja;

    public AvaliacaoLoja() {
    }

    public AvaliacaoLoja(AvaliacaoLojaPK avaliacaoLojaPK) {
        this.avaliacaoLojaPK = avaliacaoLojaPK;
    }

    public AvaliacaoLoja(int idAvaliacao, int idLoja) {
        this.avaliacaoLojaPK = new AvaliacaoLojaPK(idAvaliacao, idLoja);
    }

    public AvaliacaoLojaPK getAvaliacaoLojaPK() {
        return avaliacaoLojaPK;
    }

    public void setAvaliacaoLojaPK(AvaliacaoLojaPK avaliacaoLojaPK) {
        this.avaliacaoLojaPK = avaliacaoLojaPK;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avaliacaoLojaPK != null ? avaliacaoLojaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvaliacaoLoja)) {
            return false;
        }
        AvaliacaoLoja other = (AvaliacaoLoja) object;
        if ((this.avaliacaoLojaPK == null && other.avaliacaoLojaPK != null) || (this.avaliacaoLojaPK != null && !this.avaliacaoLojaPK.equals(other.avaliacaoLojaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mack.projeto.entities.AvaliacaoLoja[ avaliacaoLojaPK=" + avaliacaoLojaPK + " ]";
    }

}
