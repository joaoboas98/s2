/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.s2.DAL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * @author Utilizador
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Utilizador
 */
@Entity
@Table(name = "TRILHO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Trilho.findAll", query = "SELECT t FROM Trilho t")
        , @NamedQuery(name = "Trilho.findByTrilhoId", query = "SELECT t FROM Trilho t WHERE t.trilhoId = :trilhoId")
        , @NamedQuery(name = "Trilho.findByTrilhoNome", query = "SELECT t FROM Trilho t WHERE t.trilhoNome = :trilhoNome")
        , @NamedQuery(name = "Trilho.findByTrilhoCidadeInicio", query = "SELECT t FROM Trilho t WHERE t.trilhoCidadeInicio = :trilhoCidadeInicio")
        , @NamedQuery(name = "Trilho.findByTrilhoCidadeFim", query = "SELECT t FROM Trilho t WHERE t.trilhoCidadeFim = :trilhoCidadeFim")
        , @NamedQuery(name = "Trilho.findByTrilhoCapa", query = "SELECT t FROM Trilho t WHERE t.trilhoCapa = :trilhoCapa")
        , @NamedQuery(name = "Trilho.findByTrilhoDistancia", query = "SELECT t FROM Trilho t WHERE t.trilhoDistancia = :trilhoDistancia")
        , @NamedQuery(name = "Trilho.findByTrilhoFoto", query = "SELECT t FROM Trilho t WHERE t.trilhoFoto = :trilhoFoto")
        , @NamedQuery(name = "Trilho.findByTrilhoDescricao", query = "SELECT t FROM Trilho t WHERE t.trilhoDescricao = :trilhoDescricao")
        , @NamedQuery(name = "Trilho.findByTrilhoNivel", query = "SELECT t FROM Trilho t WHERE t.trilhoNivel = :trilhoNivel")
})
public class Trilho implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="quinta_sequence")
    @SequenceGenerator (name="quinta_sequence", sequenceName="TRILHO_SEQ", allocationSize = 1)
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TRILHO_ID")
    private BigDecimal trilhoId;
    @Column(name = "TRILHO_NOME")
    private String trilhoNome;
    @Column(name = "TRILHO_CIDADE_INICIO")
    private String trilhoCidadeInicio;
    @Column(name = "TRILHO_CIDADE_FIM")
    private String trilhoCidadeFim;
    @Column(name = "TRILHO_CAPA")
    private String trilhoCapa;
    @Column(name = "TRILHO_DISTANCIA")
    private String trilhoDistancia;
    @Column(name = "TRILHO_FOTO")
    private String trilhoFoto;
    @Basic(optional = false)
    @Column(name = "TRILHO_DESCRICAO")
    private String trilhoDescricao;
    @Basic(optional = false)
    @Column(name = "TRILHO_NIVEL")
    private BigInteger trilhoNivel;


    @JoinTable(name = "TRILHO_PONTO", joinColumns = {
            @JoinColumn(name = "TRILHO_ID", referencedColumnName = "TRILHO_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "PONTO_ID", referencedColumnName = "PONTO_ID")})
    @ManyToMany
    private List<Ponto> pontoList;
    @JoinTable(name = "TRILHO_ALOJAMENTO", joinColumns = {
            @JoinColumn(name = "TRILHO_ID", referencedColumnName = "TRILHO_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ALOJAMENTO_ID", referencedColumnName = "ALOJAMENTO_ID")})
    @ManyToMany
    private List<Alojamento> alojamentoList;
    @OneToMany(mappedBy = "trilhoId")
    private List<ClassTrilho> classTrilhoList;
    @OneToMany(mappedBy = "trilhoId")
    private List<Excursao> excursaoList;
    @OneToMany(mappedBy = "trilhoId")
    private List<FotoTrilho> fotoTrilhoList;
    public Trilho() {
    }





    public Trilho(BigDecimal trilhoId) {
        this.trilhoId = trilhoId;
    }

    public Trilho(BigDecimal trilhoId, String trilhoDescricao, BigInteger trilhoNivel) {
        this.trilhoId = trilhoId;
        this.trilhoDescricao = trilhoDescricao;
        this.trilhoNivel = trilhoNivel;
    }

    public BigDecimal getTrilhoId() {
        return trilhoId;
    }

    public void setTrilhoId(BigDecimal trilhoId) {
        this.trilhoId = trilhoId;
    }

    public String getTrilhoNome() {
        return trilhoNome;
    }

    public void setTrilhoNome(String trilhoNome) {
        this.trilhoNome = trilhoNome;
    }

    public String getTrilhoCidadeInicio() {
        return trilhoCidadeInicio;
    }

    public void setTrilhoCidadeInicio(String trilhoCidadeInicio) {
        this.trilhoCidadeInicio = trilhoCidadeInicio;
    }

    public String getTrilhoCidadeFim() {
        return trilhoCidadeFim;
    }

    public void setTrilhoCidadeFim(String trilhoCidadeFim) {
        this.trilhoCidadeFim = trilhoCidadeFim;
    }

    public String getTrilhoCapa() {
        return trilhoCapa;
    }

    public void setTrilhoCapa(String trilhoCapa) {
        this.trilhoCapa = trilhoCapa;
    }

    public String getTrilhoDistancia() {
        return trilhoDistancia;
    }

    public void setTrilhoDistancia(String trilhoDistancia) {
        this.trilhoDistancia = trilhoDistancia;
    }

    public String getTrilhoFoto() {
        return trilhoFoto;
    }

    public void setTrilhoFoto(String trilhoFoto) {
        this.trilhoFoto = trilhoFoto;
    }

    public String getTrilhoDescricao() {
        return trilhoDescricao;
    }

    public void setTrilhoDescricao(String trilhoDescricao) {
        this.trilhoDescricao = trilhoDescricao;
    }

    public BigInteger getTrilhoNivel() {
        return trilhoNivel;
    }

    public void setTrilhoNivel(BigInteger trilhoNivel) {
        this.trilhoNivel = trilhoNivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trilhoId != null ? trilhoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trilho)) {
            return false;
        }
        Trilho other = (Trilho) object;
        if ((this.trilhoId == null && other.trilhoId != null) || (this.trilhoId != null && !this.trilhoId.equals(other.trilhoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto2trilho.DAL.Trilho[ trilhoId=" + trilhoId + " ]";
    }

}
