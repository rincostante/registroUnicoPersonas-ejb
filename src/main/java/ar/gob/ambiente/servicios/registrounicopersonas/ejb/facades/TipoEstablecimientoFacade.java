

package ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades;

import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.TipoEstablecimiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rincostante
 */
@Stateless
public class TipoEstablecimientoFacade extends AbstractFacade<TipoEstablecimiento> {
    @PersistenceContext(unitName = "registroUnicoPersonas-ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoEstablecimientoFacade() {
        super(TipoEstablecimiento.class);
    }

    
    /**
     * Metodo que verifica si ya existe la entidad.
     * @param nombre
     * @return: devuelve True o False
     */
    public boolean noExiste(String nombre){
        em = getEntityManager();
        String queryString = "SELECT tipoEst FROM TipoEstablecimiento tipoEst "
                + "WHERE tipoEst.nombre = :nombre";
        Query q = em.createQuery(queryString)
                .setParameter("nombre", nombre);
        return q.getResultList().isEmpty();
    }  
    
    /**
     * Método que obtiene un Tipo de Establecimiento existente según los datos recibidos como parámetro
     * @param nombre
     * @return 
     */ 
    public TipoEstablecimiento getExistente(String nombre){
        List<TipoEstablecimiento> lCp;
        em = getEntityManager();
        String queryString = "SELECT tipoEst FROM TipoEstablecimiento tipoEst "
                + "WHERE tipoEst.nombre = :nombre";
        Query q = em.createQuery(queryString)
                .setParameter("nombre", nombre);
        lCp = q.getResultList();
        if(!lCp.isEmpty()){
            return lCp.get(0);
        }else{
            return null;
        }
    }    
    
    /**
     * Método que verifica si la entidad tiene dependencia (Hijos)
     * @param id: ID de la entidad
     * @return: True o False
     */
    public boolean noTieneDependencias(Long id){
        em = getEntityManager();        
        String queryString = "SELECT est FROM Establecimiento est " 
                + "WHERE est.tipoEstablecimiento.id = :id ";        
        Query q = em.createQuery(queryString)
                .setParameter("id", id);
        return q.getResultList().isEmpty();
    }  
    
    /**
     * Método que devuelve el Tipo "Domicilio legal"
     * @return 
     */
    public TipoEstablecimiento getTipoDomLegal(){
        em = getEntityManager();        
        String queryString = "SELECT tipoEst FROM TipoEstablecimiento tipoEst " 
                + "WHERE tipoEst.nombre = 'Domicilio legal'";        
        Query q = em.createQuery(queryString);
        return (TipoEstablecimiento)q.getSingleResult();
    }
}
