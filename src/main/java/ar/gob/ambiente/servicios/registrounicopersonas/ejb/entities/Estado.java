

package ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Clase paramétrica que encapsula los datos del estado que un Establecimiento puede tomar
 * @author rincostante
 */
@Entity
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (nullable=false, length=250, unique=true)
    @NotNull(message = "El campo nombre del Estado no puede quedar nulo")
    @Size(message = "El campo nombre del Estado debe tener entre 1 y 250 caracteres", min = 1, max = 250)
    private String nombre;
    
    @OneToMany(mappedBy="estado")
    private List<PerFisica> perFisicas;
    
    @OneToMany(mappedBy="estado")
    private List<PerJuridica> perJuridicas;
    
    @OneToMany(mappedBy="estado")
    private List<Establecimiento> establecimientos;

    public Estado() {
        perFisicas = new ArrayList();
        perJuridicas = new ArrayList();
        establecimientos = new ArrayList();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<PerFisica> getPerFisicas() {
        return perFisicas;
    }

    public void setPerFisicas(List<PerFisica> perFisicas) {
        this.perFisicas = perFisicas;
    }

    @XmlTransient
    public List<PerJuridica> getPerJuridicas() {
        return perJuridicas;
    }

    public void setPerJuridicas(List<PerJuridica> perJuridicas) {
        this.perJuridicas = perJuridicas;
    }

    @XmlTransient
    public List<Establecimiento> getEstablecimientos() {
        return establecimientos;
    }

    public void setEstablecimientos(List<Establecimiento> establecimientos) {
        this.establecimientos = establecimientos;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.gob.ambiente.servicios.gestionPersonas.entidades.Estado[ id=" + id + " ]";
    }
    
}
