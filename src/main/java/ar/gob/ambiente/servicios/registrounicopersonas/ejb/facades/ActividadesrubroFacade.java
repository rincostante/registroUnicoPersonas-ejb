/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades;

import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.Actividadesrubro;
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
public class ActividadesrubroFacade extends AbstractFacade<Actividadesrubro> {
    @PersistenceContext(unitName = "registroUnicoPersonas-ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadesrubroFacade() {
        super(Actividadesrubro.class);
    }
    
    public Actividadesrubro getByCodigo(String codigo){
        List<Actividadesrubro> lActRubro;
        em = getEntityManager();
        String queryString = "SELECT actRub FROM Actividadesrubro actRub "
                + "WHERE actRub.codigo = :codigo";
        Query q = em.createQuery(queryString)
                .setParameter("codigo", codigo);
        lActRubro = q.getResultList();
        if(!lActRubro.isEmpty()){
            return lActRubro.get(0);
        }else{
            return null;
        }
    }
}
