

package ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rincostante
 */
@Entity
@Table(name = "actividadesrubro")
@XmlRootElement
public class Actividadesrubro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "rubro")
    private Integer rubro;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo")
    private Integer tipo;
    @Column(name = "prioridad")
    private Integer prioridad;
    @Size(max = 100)
    @Column(name = "rubro2")
    private String rubro2;
    @Size(max = 100)
    @Column(name = "rubro3")
    private String rubro3;
    @Column(name = "codactividad")
    private Short codactividad;

    public Actividadesrubro() {
    }

    public Actividadesrubro(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getRubro() {
        return rubro;
    }

    public void setRubro(Integer rubro) {
        this.rubro = rubro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getRubro2() {
        return rubro2;
    }

    public void setRubro2(String rubro2) {
        this.rubro2 = rubro2;
    }

    public String getRubro3() {
        return rubro3;
    }

    public void setRubro3(String rubro3) {
        this.rubro3 = rubro3;
    }

    public Short getCodactividad() {
        return codactividad;
    }

    public void setCodactividad(Short codactividad) {
        this.codactividad = codactividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividadesrubro)) {
            return false;
        }
        Actividadesrubro other = (Actividadesrubro) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.Actividadesrubro[ codigo=" + codigo + " ]";
    }
    
}
