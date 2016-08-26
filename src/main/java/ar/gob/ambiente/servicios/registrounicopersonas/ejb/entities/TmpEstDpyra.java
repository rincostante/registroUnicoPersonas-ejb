

package ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que encapsula los datos de los establecimientos de la DPyRA a migrar
 * @author rincostante
 */
@Entity
public class TmpEstDpyra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**************************************
     * Campos de indican la razón social **
     * Se migra a PerJuridica
     **************************************/
    
    @Column (nullable=false, length=250)
    @NotNull(message = "El campo rs_nombre no puede quedar nulo")
    @Size(message = "El campo rs_nombre debe tener entre 1 y 250 caracteres", min = 1, max = 250)    
    private String rs_nombre;
    
    @Column (nullable=false, length=10)
    @NotNull(message = "El campo rs_tipo no puede quedar nulo")
    @Size(message = "El campo rs_tipo debe tener entre 1 y 10 caracteres", min = 1, max = 10)
    private String rs_tipo;
    
    @Column (nullable=false)
    @NotNull(message = "El compo rs_cuit no debe quedar nulo")
    private Long rs_cuit;
    
    
    /********************************************************
     * Campos que indican el domicilio del Establecimiento **
     * Se migra a Domicilio
     ********************************************************/
    
    @Column (nullable=false, length=50)
    @NotNull(message = "El campo dom_calle no puede quedar nulo")
    @Size(message = "El campo dom_calle debe tener entre 1 y 50 caracteres", min = 1, max = 50)
    private String dom_calle;
    
    @Column (nullable=false, length=10)
    @NotNull(message = "El campo dom_numero no puede quedar nulo")
    @Size(message = "El campo dom_numero debe tener entre 1 y 10 caracteres", min = 1, max = 10)
    private String dom_numero;
    
    private String dom_dpto;
    
    @Column (nullable=false, length=50)
    @NotNull(message = "El campo dom_localidad no puede quedar nulo")
    @Size(message = "El campo dom_localidad debe tener entre 1 y 10 caracteres", min = 1, max = 50)
    private String dom_localidad;
    
    @Column (nullable=false, length=100)
    @NotNull(message = "El campo dom_partido no puede quedar nulo")
    @Size(message = "El campo dom_partido debe tener entre 1 y 100 caracteres", min = 1, max = 100)
    private String dom_partido;
    
    /***************************************************************
     * Campos que indican los datos del Establecimiento en el GEL **
     * Se migra a Establecimiento (GEL)
     ***************************************************************/
    
    @Column (nullable=false, length=10)
    @NotNull(message = "El campo est_actividad no puede quedar nulo")
    @Size(message = "El campo est_actividad debe tener entre 1 y 10 caracteres", min = 1, max = 10)
    private String est_actividad;
    
    private String est_esjuridica;
    
    @Column (nullable=false)
    @NotNull(message = "El campo est_crs no puede quedar nulo")
    private int est_crs;
    
    @Column (nullable=false)
    @NotNull(message = "El campo est_numero no puede quedar nulo")
    private int est_numero;
    
    @Column (nullable=false)
    @NotNull(message = "El campo est_codpartido no puede quedar nulo")
    private int est_codpartido;
    
    private String est_procproductivo;
    
    /****************************************************************************
     * Campos que indican los datos del Inmueble del Establecimiento en el GEL **
     * Se migra a Inmueble (GEL)
     ****************************************************************************/
    
    private String inm_partinmob;
    
    private String inm_nomcatastral;
    
    /****************************************************************************
     * Campos que indican los datos del Firmante del Establecimiento en el GEL **
     * Se migra a Firmante (GEL)
     ****************************************************************************/    
    
    @Column (nullable=false)
    @NotNull(message = "El campo fir_nomcompleto no puede quedar nulo")    
    private String fir_nomcompleto;
    
    @Column (nullable=false)
    private Long fir_dni;
    
    private String inm_letra;
    
    //--------------------------------------------------------------------------}
    @Column (nullable=false)
    private String codercibo;
    
    /**********************************************
     * Campos de actualización para la migración **
     **********************************************/
    
    private Long idRsRup;
    
    private Long idEstRup;
    
    private Long idEstGel;
    
    @Column (length=1000)
    @Size(message = "El campo est_actividad debe tener entre 1 y 10 caracteres", min = 1, max = 1000)
    private String mensaje;
    
    
    /**********************
     * Métodos de acceso **
     **********************/
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
    public Long getIdEstGel() {
        return idEstGel;
    }

    public void setIdEstGel(Long idEstGel) {
        this.idEstGel = idEstGel;
    }
    
    public Long getIdRsRup() {
        return idRsRup;
    }

    public void setIdRsRup(Long idRsRup) {
        this.idRsRup = idRsRup;
    }

    public Long getIdEstRup() {
        return idEstRup;
    }

    public void setIdEstRup(Long idEstRup) {
        this.idEstRup = idEstRup;
    }

    public String getRs_nombre() {
        return rs_nombre;
    }

    public void setRs_nombre(String rs_nombre) {
        this.rs_nombre = rs_nombre;
    }

    public String getRs_tipo() {
        return rs_tipo;
    }

    public void setRs_tipo(String rs_tipo) {
        this.rs_tipo = rs_tipo;
    }

    public Long getRs_cuit() {
        return rs_cuit;
    }

    public void setRs_cuit(Long rs_cuit) {
        this.rs_cuit = rs_cuit;
    }

    public String getDom_calle() {
        return dom_calle;
    }

    public void setDom_calle(String dom_calle) {
        this.dom_calle = dom_calle;
    }

    public String getDom_numero() {
        return dom_numero;
    }

    public void setDom_numero(String dom_numero) {
        this.dom_numero = dom_numero;
    }

    public String getDom_dpto() {
        return dom_dpto;
    }

    public void setDom_dpto(String dom_dpto) {
        this.dom_dpto = dom_dpto;
    }

    public String getDom_localidad() {
        return dom_localidad;
    }

    public void setDom_localidad(String dom_localidad) {
        this.dom_localidad = dom_localidad;
    }

    public String getDom_partido() {
        return dom_partido;
    }

    public void setDom_partido(String dom_partido) {
        this.dom_partido = dom_partido;
    }

    public String getEst_actividad() {
        return est_actividad;
    }

    public void setEst_actividad(String est_actividad) {
        this.est_actividad = est_actividad;
    }

    public String getEst_esjuridica() {
        return est_esjuridica;
    }

    public void setEst_esjuridica(String est_esjuridica) {
        this.est_esjuridica = est_esjuridica;
    }

    public int getEst_crs() {
        return est_crs;
    }

    public void setEst_crs(int est_crs) {
        this.est_crs = est_crs;
    }

    public int getEst_numero() {
        return est_numero;
    }

    public void setEst_numero(int est_numero) {
        this.est_numero = est_numero;
    }

    public int getEst_codpartido() {
        return est_codpartido;
    }

    public void setEst_codpartido(int est_codpartido) {
        this.est_codpartido = est_codpartido;
    }

    public String getEst_procproductivo() {
        return est_procproductivo;
    }

    public void setEst_procproductivo(String est_procproductivo) {
        this.est_procproductivo = est_procproductivo;
    }

    public String getInm_partinmob() {
        return inm_partinmob;
    }

    public void setInm_partinmob(String inm_partinmob) {
        this.inm_partinmob = inm_partinmob;
    }

    public String getInm_nomcatastral() {
        return inm_nomcatastral;
    }

    public void setInm_nomcatastral(String inm_nomcatastral) {
        this.inm_nomcatastral = inm_nomcatastral;
    }

    public String getFir_nomcompleto() {
        return fir_nomcompleto;
    }

    public void setFir_nomcompleto(String fir_nomcompleto) {
        this.fir_nomcompleto = fir_nomcompleto;
    }

    public Long getFir_dni() {
        return fir_dni;
    }

    public void setFir_dni(Long fir_dni) {
        this.fir_dni = fir_dni;
    }

    public String getInm_letra() {
        return inm_letra;
    }

    public void setInm_letra(String inm_letra) {
        this.inm_letra = inm_letra;
    }

    public String getCodercibo() {
        return codercibo;
    }

    public void setCodercibo(String codercibo) {
        this.codercibo = codercibo;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof TmpEstDpyra)) {
            return false;
        }
        TmpEstDpyra other = (TmpEstDpyra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.TmpEstDpyra[ id=" + id + " ]";
    }
    
}
