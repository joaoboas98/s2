/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.s2.DAL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Utilizador
 */
@Entity
@Table(name = "PONTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ponto.findAll", query = "SELECT p FROM Ponto p"),
    @NamedQuery(name = "Ponto.findByPontoId", query = "SELECT p FROM Ponto p WHERE p.pontoId = :pontoId"),
    @NamedQuery(name = "Ponto.findByPontoNome", query = "SELECT p FROM Ponto p WHERE p.pontoNome = :pontoNome"),
    @NamedQuery(name = "Ponto.findByPontoCidade", query = "SELECT p FROM Ponto p WHERE p.pontoCidade = :pontoCidade"),
    @NamedQuery(name = "Ponto.findByPontoLatitude", query = "SELECT p FROM Ponto p WHERE p.pontoLatitude = :pontoLatitude"),
    @NamedQuery(name = "Ponto.findByPontoLongitude", query = "SELECT p FROM Ponto p WHERE p.pontoLongitude = :pontoLongitude"),
    @NamedQuery(name = "Ponto.findByPontoCp", query = "SELECT p FROM Ponto p WHERE p.pontoCp = :pontoCp"),
    @NamedQuery(name = "Ponto.findByPontoDescricao", query = "SELECT p FROM Ponto p WHERE p.pontoDescricao = :pontoDescricao"),
    @NamedQuery(name = "Ponto.findByPontoPais", query = "SELECT p FROM Ponto p WHERE p.pontoPais = :pontoPais")})
public class Ponto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PONTO_ID")
    private Integer pontoId;
    @Basic(optional = false)
    @Column(name = "PONTO_NOME")
    private String pontoNome;
    @Column(name = "PONTO__CIDADE")
    private String pontoCidade;
    @Column(name = "PONTO_LATITUDE")
    private String pontoLatitude;
    @Column(name = "PONTO_LONGITUDE")
    private String pontoLongitude;
    @Column(name = "PONTO_CP")
    private String pontoCp;
    @Basic(optional = false)
    @Column(name = "PONTO_DESCRICAO")
    private String pontoDescricao;
    @Basic(optional = false)
    @Column(name = "PONTO_PAIS")
    private String pontoPais;
    @ManyToMany(mappedBy = "pontoList")
    private List<Trilho> trilhoList;
    @OneToMany(mappedBy = "pontoId")
    private List<FotoPonto> fotoPontoList;

    public Ponto() {
    }

    public Ponto(Integer pontoId) {
        this.pontoId = pontoId;
    }

    public Ponto(Integer pontoId, String pontoNome, String pontoDescricao, String pontoPais) {
        this.pontoId = pontoId;
        this.pontoNome = pontoNome;
        this.pontoDescricao = pontoDescricao;
        this.pontoPais = pontoPais;
    }

    public Integer getPontoId() {
        return pontoId;
    }

    public void setPontoId(Integer pontoId) {
        this.pontoId = pontoId;
    }

    public String getPontoNome() {
        return pontoNome;
    }

    public void setPontoNome(String pontoNome) {
        this.pontoNome = pontoNome;
    }

    public String getPontoCidade() {
        return pontoCidade;
    }

    public void setPontoCidade(String pontoCidade) {
        this.pontoCidade = pontoCidade;
    }

    public String getPontoLatitude() {
        return pontoLatitude;
    }

    public void setPontoLatitude(String pontoLatitude) {
        this.pontoLatitude = pontoLatitude;
    }

    public String getPontoLongitude() {
        return pontoLongitude;
    }

    public void setPontoLongitude(String pontoLongitude) {
        this.pontoLongitude = pontoLongitude;
    }

    public String getPontoCp() {
        return pontoCp;
    }

    public void setPontoCp(String pontoCp) {
        this.pontoCp = pontoCp;
    }

    public String getPontoDescricao() {
        return pontoDescricao;
    }

    public void setPontoDescricao(String pontoDescricao) {
        this.pontoDescricao = pontoDescricao;
    }

    public String getPontoPais() {
        return pontoPais;
    }

    public void setPontoPais(String pontoPais) {
        this.pontoPais = pontoPais;
    }

    @XmlTransient
    public List<Trilho> getTrilhoList() {
        return trilhoList;
    }

    public void setTrilhoList(List<Trilho> trilhoList) {
        this.trilhoList = trilhoList;
    }

    @XmlTransient
    public List<FotoPonto> getFotoPontoList() {
        return fotoPontoList;
    }

    public void setFotoPontoList(List<FotoPonto> fotoPontoList) {
        this.fotoPontoList = fotoPontoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pontoId != null ? pontoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ponto)) {
            return false;
        }
        Ponto other = (Ponto) object;
        if ((this.pontoId == null && other.pontoId != null) || (this.pontoId != null && !this.pontoId.equals(other.pontoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpringWebMVC.s2.DAL.Ponto[ pontoId=" + pontoId + " ]";
    }
    
}
