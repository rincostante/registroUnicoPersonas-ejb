

package ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades;

import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.TipoPersonaJuridica;
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
public class TipoPersonaJuridicaFacade extends AbstractFacade<TipoPersonaJuridica> {
    @PersistenceContext(unitName = "registroUnicoPersonas-ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPersonaJuridicaFacade() {
        super(TipoPersonaJuridica.class);
    }   
    
    
    /**
     * Método que obtiene un Tipo de persona jurídica existente según los datos recibidos como parámetro
     * @param nombre
     * @return 
     */ 
    public TipoPersonaJuridica getExistente(String nombre){
        List<TipoPersonaJuridica> lCp;
        em = getEntityManager();
        String queryString = "SELECT tpj FROM TipoPersonaJuridica tpj "
                + "WHERE tpj.nombre = :nombre";
        Query q = em.createQuery(queryString)
                .setParameter("stringParam", nombre);
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
        String queryString = "SELECT perJur FROM PerJuridica perJur " 
                + "WHERE perJur.tipoPersonaJuridica.id = :id ";        
        Query q = em.createQuery(queryString)
                .setParameter("id", id);
        return q.getResultList().isEmpty();
    }  

     /**
     * Metodo que verifica si ya existe la entidad.
     * @param nombre: es la cadena que buscara para ver si ya existe en la BDD
     * @return: devuelve True o False
     */
    public boolean noExiste(String nombre){
        em = getEntityManager();       
        String queryString = "SELECT tpj.nombre FROM TipoPersonaJuridica tpj "
                + "WHERE tpj.nombre = :nombre ";
        Query q = em.createQuery(queryString)
                .setParameter("nombre", nombre);
        return q.getResultList().isEmpty();
    } 
}
