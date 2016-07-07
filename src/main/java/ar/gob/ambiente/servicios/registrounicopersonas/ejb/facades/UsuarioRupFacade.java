

package ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades;

import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
* @author rincostante
*/
@Stateless
public class UsuarioRupFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "registroUnicoPersonas-ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioRupFacade() {
        super(Usuario.class);
    }
    
    /**
     * Método para validad que no exista un Usuario con ese nombre
     * @param nombre
     * @return 
     */
    public boolean noExiste(String nombre){
        em = getEntityManager();
        String queryString = "SELECT us FROM Usuario us "
                + "WHERE us.nombre = :nombre";
        Query q = em.createQuery(queryString)
                .setParameter("nombre", nombre);
        return q.getResultList().isEmpty();
    }        
    
    /**
     * Método que valida si una contraseña ya está en uso
     * @param clave: contraseña encriptada
     * @return 
     */
    public boolean verificarContrasenia(String clave){
        em = getEntityManager();
        String queryString = "SELECT us FROM Usuario us "
                + "WHERE us.clave = :clave";
        Query q = em.createQuery(queryString)
                .setParameter("clave", clave);
        return q.getResultList().isEmpty();
    }    
    
   /**
     * Método que devuelve un LIST con las entidades HABILITADAS
     * @return: True o False
     */
    public List<Usuario> getActivos(){
        em = getEntityManager();        
        List<Usuario> result;
        String queryString = "SELECT us FROM Usuario us " 
                + "WHERE us.adminentidad.habilitado = true";                   
        Query q = em.createQuery(queryString);
        result = q.getResultList();
        return result;
    }  
    
    /**
     * Método que devulve los datos del usuario logeado
     * @param nombre
     * @return 
     */
    public Usuario getUsuario(String nombre){
        em = getEntityManager();
        List<Usuario> lUs;
        String queryString = "SELECT us FROM Usuario us "
                + "WHERE us.nombre = :nombre";
        Query q = em.createQuery(queryString)
                .setParameter("nombre", nombre);
        lUs = q.getResultList();
        if(!lUs.isEmpty()){
            return lUs.get(0);
        }else{
            return null;
        }
    }
}
