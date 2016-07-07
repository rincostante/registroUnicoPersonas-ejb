

package ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades;

import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.Domicilio;
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
public class DomicilioFacade extends AbstractFacade<Domicilio> {
    @PersistenceContext(unitName = "registroUnicoPersonas-ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DomicilioFacade() {
        super(Domicilio.class);
    }
      /**
     * Metodo que verifica si ya existe la entidad.
     * @param aBuscar: es la cadena que buscara para ver si ya existe en la BDD
     * @return: devuelve True o False
     */
    public boolean existe(String aBuscar){
        em = getEntityManager();       
        String queryString = "SELECT act.nombre FROM Domicilio domicilio "
                + "WHERE act.nombre = :stringParam ";
        Query q = em.createQuery(queryString)
                .setParameter("stringParam", aBuscar);
        return q.getResultList().isEmpty();
    }    
    
    /**
     * Metodo que verifica si ya existe la entidad.
     * @param nombre
     * @param depto
     * @return: devuelve True o False
     */
    public boolean noExiste(String nombre, Domicilio domicilio){
        em = getEntityManager();
        String queryString = "SELECT act FROM Domicilio act "
                + "WHERE act.nombre = :stringParam "
                + "AND act.domicilio = :domicilio";
        Query q = em.createQuery(queryString)
                .setParameter("stringParam", nombre)
                .setParameter("domicilio", domicilio);
        return q.getResultList().isEmpty();
    }  
    
    /**
     * Método que obtiene un Centro Poblado existente según los datos recibidos como parámetro
     * @param nombre
     * @return 
     */ 
    public Domicilio getExistente(String nombre, Domicilio domicilio){
        List<Domicilio> lCp;
        em = getEntityManager();
        String queryString = "SELECT act FROM Domicilio act "
                + "WHERE act.nombre = :stringParam "
                + "AND act.domicilio = :domicilio";
        Query q = em.createQuery(queryString)
                .setParameter("stringParam", nombre)
                .setParameter("domicilio", domicilio);
        lCp = q.getResultList();
        if(!lCp.isEmpty()){
            return lCp.get(0);
        }else{
            return null;
        }
    }    

     /**
     * Metodo para el autocompletado de la búsqueda por nombre
     * @return 
     */  

    public List<String> getNombres(){
        em = getEntityManager();
        String queryString = "SELECT act.nombre FROM Domicilio act ";
        Query q = em.createQuery(queryString);
        return q.getResultList();
    }
    
    /**
     * Método que verifica si la entidad tiene dependencia (Hijos) en estado HABILITADO
     * @param id: ID de la entidad
     * @return: True o False
     */
    public boolean noTieneDependencias(Long id){
        em = getEntityManager();        
        String queryString = "SELECT act FROM Domicilio act " 
                + "WHERE act.domicilio.id = :idParam ";        
        Query q = em.createQuery(queryString)
                .setParameter("idParam", id);
        return q.getResultList().isEmpty();
    }  

    public List<Domicilio> getNombres(Domicilio selectDomicilio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean noExiste(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}