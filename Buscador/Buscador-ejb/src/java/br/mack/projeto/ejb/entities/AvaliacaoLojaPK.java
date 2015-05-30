package br.mack.projeto.ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class AvaliacaoLojaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_avaliacao")
    private int idAvaliacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_loja")
    private int idLoja;

    public AvaliacaoLojaPK() {
    }

    public AvaliacaoLojaPK(int idAvaliacao, int idLoja) {
        this.idAvaliacao = idAvaliacao;
        this.idLoja = idLoja;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAvaliacao;
        hash += (int) idLoja;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvaliacaoLojaPK)) {
            return false;
        }
        AvaliacaoLojaPK other = (AvaliacaoLojaPK) object;
        if (this.idAvaliacao != other.idAvaliacao) {
            return false;
        }
        if (this.idLoja != other.idLoja) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.mack.projeto.entities.AvaliacaoLojaPK[ idAvaliacao=" + idAvaliacao + ", idLoja=" + idLoja + " ]";
    }

}
