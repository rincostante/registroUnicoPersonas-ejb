/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades;

import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.TmpEstDpyra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rincostante
 */
@Stateless
public class TmpEstDpyraFacade extends AbstractFacade<TmpEstDpyra> {
    @PersistenceContext(unitName = "registroUnicoPersonas-ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TmpEstDpyraFacade() {
        super(TmpEstDpyra.class);
    }
    
}
