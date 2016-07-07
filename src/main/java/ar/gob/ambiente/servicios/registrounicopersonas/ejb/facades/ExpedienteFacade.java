

package ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades;

import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.Expediente;
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
public class ExpedienteFacade extends AbstractFacade<Expediente> {
    @PersistenceContext(unitName = "registroUnicoPersonas-ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExpedienteFacade() {
        super(Expediente.class);
    }  
    
    /**
     * Metodo que verifica si ya existe la entidad.
     * @param numero
     * @param anio
     * @return: devuelve True o False
     */
    public boolean noExiste(int numero, int anio){
        em = getEntityManager();
        String queryString = "SELECT exp FROM Expediente exp "
                + "WHERE exp.numero = :numero "
                + "AND exp.anio = :anio";
        Query q = em.createQuery(queryString)
                .setParameter("numero", numero)
                .setParameter("anio", anio);
        return q.getResultList().isEmpty();
    }  
    
    /**
     * Método que obtiene un Centro Poblado existente según los datos recibidos como parámetro
     * @param numero
     * @param anio
     * @return 
     */ 
    public Expediente getExistente(int numero, int anio){
        List<Expediente> list;
        em = getEntityManager();
        String queryString = "SELECT exp FROM Expediente exp "
                + "WHERE exp.numero = :numero "
                + "AND exp.anio = :anio";
        Query q = em.createQuery(queryString)
                .setParameter("numero", numero)
                .setParameter("anio", anio);
        list = q.getResultList();
        if(!list.isEmpty()){
            return list.get(0);
        }else{
            return null;
        }
    }    
    
    public List<Expediente> findAllByOrder(){
        em = getEntityManager();
        String queryString = "SELECT exp FROM Expediente exp "
                + "ORDER BY exp.numero, exp.anio";
        Query q = em.createQuery(queryString);
        return q.getResultList();
    }
} 

