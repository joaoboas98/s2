/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.s2.DAL;

import org.hibernate.annotations.GenericGenerator;

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

@NamedQueries({
    @NamedQuery(name = "Utilizador.findAll", query = "SELECT u FROM Utilizador u"),
    @NamedQuery(name = "Utilizador.findByUtilizadorId", query = "SELECT u FROM Utilizador u WHERE u.utilizadorId = :utilizadorId"),
    @NamedQuery(name = "Utilizador.findByUtilizadorNome", query = "SELECT u FROM Utilizador u WHERE u.utilizadorNome = :utilizadorNome"),
    @NamedQuery(name = "Utilizador.findByUtilizadorTipo", query = "SELECT u FROM Utilizador u WHERE u.utilizadorTipo = :utilizadorTipo"),
    @NamedQuery(name = "Utilizador.findByUtilizadorMorada", query = "SELECT u FROM Utilizador u WHERE u.utilizadorMorada = :utilizadorMorada"),
    @NamedQuery(name = "Utilizador.findByUtilizadorIdade", query = "SELECT u FROM Utilizador u WHERE u.utilizadorIdade = :utilizadorIdade"),
    @NamedQuery(name = "Utilizador.findByUtilizadorPass", query = "SELECT u FROM Utilizador u WHERE u.utilizadorPass = :utilizadorPass")
})

public class Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="quinta_sequence")
    @SequenceGenerator (name="quinta_sequence", sequenceName="S_UTILIZADOR", allocationSize = 1)
    @Column(name = "UTILIZADOR_ID")
    private BigDecimal utilizadorId;

    @Column(name = "UTILIZADOR_NOME")
    private String utilizadorNome;
    @Column(name = "UTILIZADOR_TIPO")
    private BigDecimal utilizadorTipo;
    @Basic(optional = false)
    @Column(name = "UTILIZADOR_MORADA")
    private String utilizadorMorada;
    @Basic(optional = false)
    @Column(name = "UTILIZADOR_IDADE")
    private BigInteger utilizadorIdade;
    @Basic(optional = false)
    @Column(name = "UTILIZADOR_PASS")
    private String utilizadorPass;
    @OneToMany(mappedBy = "utilizadorId")
    private List<FotoPonto> fotoPontoList;
    @OneToMany(mappedBy = "utilizadorId")
    private List<Grupo> grupoList;
    @OneToMany(mappedBy = "utilizadorId")
    private List<ClassTrilho> classTrilhoList;
    @OneToMany(mappedBy = "utilizadorId")
    private List<ClassAlo> classAloList;
    @OneToMany(mappedBy = "utilizadorId")
    private List<Excursao> excursaoList;
    @OneToMany(mappedBy = "utilizadorId")
    private List<PagamentoExcursao> pagamentoExcursaoList;
    @OneToMany(mappedBy = "utilizadorId")
    private List<FotoTrilho> fotoTrilhoList;

    public Utilizador() {
    }

    public Utilizador(BigDecimal utilizadorId) {
        this.utilizadorId = utilizadorId;
    }

    public Utilizador(BigDecimal utilizadorId, String utilizadorNome, String utilizadorMorada, BigInteger utilizadorIdade, BigDecimal utilizadorTipo,String utilizadorPass) {
        this.utilizadorId = utilizadorId;
        this.utilizadorNome = utilizadorNome;
        this.utilizadorMorada = utilizadorMorada;
        this.utilizadorIdade = utilizadorIdade;
        this.utilizadorPass = utilizadorPass;
        this.utilizadorTipo = utilizadorTipo;
    }

    public BigDecimal getUtilizadorId() {
        return utilizadorId;
    }

    public void setUtilizadorId(BigDecimal utilizadorId) {
        this.utilizadorId = utilizadorId;
    }

    public String getUtilizadorNome() {
        return utilizadorNome;
    }

    public void setUtilizadorNome(String utilizadorNome) {
        this.utilizadorNome = utilizadorNome;
    }

    public BigDecimal getUtilizadorTipo() {
        return utilizadorTipo;
    }

    public void setUtilizadorTipo(BigDecimal utilizadorTipo) {
        this.utilizadorTipo = utilizadorTipo;
    }

    public String getUtilizadorMorada() {
        return utilizadorMorada;
    }

    public void setUtilizadorMorada(String utilizadorMorada) {
        this.utilizadorMorada = utilizadorMorada;
    }

    public BigInteger getUtilizadorIdade() {
        return utilizadorIdade;
    }

    public void setUtilizadorIdade(BigInteger utilizadorIdade) {
        this.utilizadorIdade = utilizadorIdade;
    }

    public String getUtilizadorPass() {
        return utilizadorPass;
    }

    public void setUtilizadorPass(String utilizadorPass) {
        this.utilizadorPass = utilizadorPass;
    }

    @XmlTransient
    public List<FotoPonto> getFotoPontoList() {
        return fotoPontoList;
    }

    public void setFotoPontoList(List<FotoPonto> fotoPontoList) {
        this.fotoPontoList = fotoPontoList;
    }

    @XmlTransient
    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    @XmlTransient
    public List<ClassTrilho> getClassTrilhoList() {
        return classTrilhoList;
    }

    public void setClassTrilhoList(List<ClassTrilho> classTrilhoList) {
        this.classTrilhoList = classTrilhoList;
    }

    @XmlTransient
    public List<ClassAlo> getClassAloList() {
        return classAloList;
    }

    public void setClassAloList(List<ClassAlo> classAloList) {
        this.classAloList = classAloList;
    }

    @XmlTransient
    public List<Excursao> getExcursaoList() {
        return excursaoList;
    }

    public void setExcursaoList(List<Excursao> excursaoList) {
        this.excursaoList = excursaoList;
    }

    @XmlTransient
    public List<PagamentoExcursao> getPagamentoExcursaoList() {
        return pagamentoExcursaoList;
    }

    public void setPagamentoExcursaoList(List<PagamentoExcursao> pagamentoExcursaoList) {
        this.pagamentoExcursaoList = pagamentoExcursaoList;
    }

    @XmlTransient
    public List<FotoTrilho> getFotoTrilhoList() {
        return fotoTrilhoList;
    }

    public void setFotoTrilhoList(List<FotoTrilho> fotoTrilhoList) {
        this.fotoTrilhoList = fotoTrilhoList;
    }



    @Override
    public String toString() {
        return "SpringWebMVC.s2.DAL.Utilizador[ utilizadorId=" + utilizadorId + " ]";
    }
    
}
