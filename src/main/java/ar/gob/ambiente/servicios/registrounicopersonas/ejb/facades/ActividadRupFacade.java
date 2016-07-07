

package ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades;

import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.Actividad;
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
public class ActividadRupFacade extends AbstractFacade<Actividad> {
    @PersistenceContext(unitName = "registroUnicoPersonas-ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadRupFacade() {
        super(Actividad.class);
    }
    
    /**
     * Metodo que verifica si ya existe la entidad.
     * @param nombre
     * @return: devuelve True o False
     */
    public boolean noExiste(String nombre){
        em = getEntityManager();
        String queryString = "SELECT act FROM Actividad act "
                + "WHERE act.nombre = :nombre";
        Query q = em.createQuery(queryString)
                .setParameter("nombre", nombre);
        return q.getResultList().isEmpty();
    }  
    
    /**
     * Método que obtiene un Centro Poblado existente según los datos recibidos como parámetro
     * @param nombre
     * @return 
     */ 
    public Actividad getExistente(String nombre){
        List<Actividad> lCp;
        em = getEntityManager();
        String queryString = "SELECT act FROM Actividad act "
                + "WHERE act.nombre = :nombre";
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
     * Método que verifica si la entidad tiene dependencia (Hijos) en estado HABILITADO
     * @param id: ID de la entidad
     * @return: True o False
     */
    public boolean noTieneDependencias(Long id){
        em = getEntityManager();        
        String queryString = "SELECT est FROM Establecimiento est "
                + "INNER JOIN est.actividades act " 
                + "WHERE act.id = :id";        
        Query q = em.createQuery(queryString)
                .setParameter("id", id);
        return q.getResultList().isEmpty();
    }  
    
    /**
     * Método para ordenar las Actividades alfabéticamente
     * @return 
     */
    public List<Actividad> findAllByOrder(){
        em = getEntityManager();
        String queryString = "SELECT act FROM Actividad act "
                + "ORDER BY act.nombre";
        Query q = em.createQuery(queryString);
        return q.getResultList();
    }
}
