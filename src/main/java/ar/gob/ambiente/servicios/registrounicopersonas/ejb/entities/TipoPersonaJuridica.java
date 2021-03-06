
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

/**
 * Clase paramétrica que encapsula los datos relacionados al tipo de Persona Jurídica
 * @author rincostante
 */
@Entity
public class TipoPersonaJuridica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (nullable=false, length=250, unique=true)
    @NotNull(message = "El campo nombre no puede quedar nulo")
    @Size(message = "El campo nombre debe tener entre 1 y 250 caracteres", min = 1, max = 250)
    private String nombre;
    
    @Column (nullable=false, length=10, unique=true)
    @NotNull(message = "El campo nombre no puede quedar nulo")
    @Size(message = "El campo nombre debe tener entre 1 y 10 caracteres", min = 1, max = 10)
    private String sigla;    
    
    @OneToMany(mappedBy="tipoPersonaJuridica")
    private List<PerJuridica> perJuridica;

    public TipoPersonaJuridica() {
        perJuridica = new ArrayList();
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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

    public List<PerJuridica> getPerJuridicas() {
        return perJuridica;
    }

    public void setPerJuridica(List<PerJuridica> perJuridica) {
        this.perJuridica = perJuridica;
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
        if (!(object instanceof TipoPersonaJuridica)) {
            return false;
        }
        TipoPersonaJuridica other = (TipoPersonaJuridica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.gob.ambiente.servicios.gestionPersonas.entidades.TipoPersonaJuridica[ id=" + id + " ]";
    }
    
}
