package ar.gob.ambiente.servicios.registrounicopersonas.ejb.servicio;

import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.Actividad;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.Actividadesrubro;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.Especialidad;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.Establecimiento;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.Estado;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.Expediente;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.PerFisica;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.PerJuridica;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.ReasignaRazonSocial;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.TipoEstablecimiento;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.TipoPersonaJuridica;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.TmpEstDpyra;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.entities.Usuario;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades.ActividadRupFacade;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades.ActividadesrubroFacade;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades.EspecialidadFacade;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades.EstablecimientoRupFacade;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades.EstadoFacade;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades.ExpedienteFacade;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades.PerFisicaFacade;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades.PerJuridicaFacade;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades.ReasignaRazonSocialFacade;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades.TipoEstablecimientoFacade;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades.TipoPersonaJuridicaFacade;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades.TmpEstDpyraFacade;
import ar.gob.ambiente.servicios.registrounicopersonas.ejb.facades.UsuarioRupFacade;
import interfases.PersonasServicioInterfazRemota;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Fachada que expone los métodos de acceso a datos para el servicio web
 * @author rincostante
 */

@Stateless
public class PersonasServicio implements PersonasServicioInterfazRemota  {

    @EJB
    private EstablecimientoRupFacade estFacade;
    @EJB
    private PerFisicaFacade perFisFacade;
    @EJB
    private PerJuridicaFacade perJurFacade;
    @EJB
    private TipoPersonaJuridicaFacade tipoPerJurFacade;
    @EJB
    private UsuarioRupFacade usRupFacade;
    @EJB
    private EstadoFacade estadoFacade;
    @EJB
    private ActividadRupFacade actividadFacade;
    @EJB
    private TipoEstablecimientoFacade tipoEstFacade;
    @EJB
    private EspecialidadFacade espFacade;
    @EJB
    private ExpedienteFacade expFacade;
    @EJB
    private ReasignaRazonSocialFacade reasignaRazSocFacade;
    @EJB
    private TmpEstDpyraFacade tmpEstFacade;
    @EJB
    private ActividadesrubroFacade actRubroFacade;
    
    private static final Logger logger = Logger.getLogger(Establecimiento.class.getName());
    
    /**************
     * Migración **
     **************/
    
    /**
     * Método para crear un Establecimiento a migrar proveniente de la DPyRA
     * @param tmpEstDpyra 
     */
    @Override
    public void createTempEst(TmpEstDpyra tmpEstDpyra){
        Date date;
        try{
            tmpEstFacade.create(tmpEstDpyra);
            logger.log(Level.INFO, "Ejecutando el método createTempEst() desde el servicio RUP");
        }catch(Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método createTempEst() desde el servicio RUP. " + date + ". ", ex);
        }
    }
    
    @Override
    public List<TmpEstDpyra> getEstDpyra(){
        List<TmpEstDpyra> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = tmpEstFacade.findAll();
            logger.log(Level.INFO, "Ejecutando el método getEstDpyra() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getEstDpyra() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst;
    }
    
    public void editTmpEstDpyra(TmpEstDpyra est){
        Date date;
        try{
            tmpEstFacade.edit(est);
            logger.log(Level.INFO, "Ejecutando el método editTmpEstDpyra() desde el servicio RUP");
        }catch(Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método editTmpEstDpyra() desde el servicio RUP. " + date + ". ", ex);
        }
    }    
    
    public Actividadesrubro getActRubroPorCodigo(String codigo){
        Actividadesrubro actRub;
        Date date;
        try{
            actRub = actRubroFacade.getByCodigo(codigo);
            logger.log(Level.INFO, "Ejecutando el método getActRubroPorCodigo() desde el servicio RUP");
        }catch(Exception ex){
            actRub = null;
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getActRubroPorCodigo() desde el servicio RUP. " + date + ". ", ex);
        }
        return actRub; 
    }
    
    public Actividad getActividadPorNombre(String nombre){
        Actividad act;
        Date date;
        try{
            act = actividadFacade.getExistente(nombre);
            logger.log(Level.INFO, "Ejecutando el método getActividadPorNombre() desde el servicio RUP");
        }catch(Exception ex){
            act = null;
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getActividadPorNombre() desde el servicio RUP. " + date + ". ", ex);
        }
        return act; 
    }
    
    /**********************
     * Establecimientos ***
     **********************/
    /**
     * Retorna los establecimientos ordenados por razón social
     * @return 
     */
    public List<Establecimiento> getEstablecimientos(){
        List<Establecimiento> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = estFacade.findAll();
            logger.log(Level.INFO, "Ejecutando el método getEstablecimientos() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getEstablecimientos() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst;
    }    
    
    /**
     * Retorna el Establecimiento correspondiente
     * @param idEstablecimiento
     * @return 
     */
    public Establecimiento getEstablecimientoPorId(Long idEstablecimiento){
        Establecimiento result;
        Date date;
        try{
            result = estFacade.find(idEstablecimiento);
            logger.log(Level.INFO, "Ejecutando el método getEstablecimientoPorId() desde el servicio RUP");
            return result;
        }catch(Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getEstablecimientoPorId() desde el servicio RUP. " + date + ". ", ex);
            return null;
        }
    }
    
    /**
     * Retorna los establecimientos vinculados al cuit recibido
     * @param cuit
     * @return 
     */
    public List<Establecimiento> getEstablecimientosPorCUIT(Long cuit){
        List<Establecimiento> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = estFacade.getByCuit(cuit);
            logger.log(Level.INFO, "Ejecutando el método getEstablecimientosPorCUIT() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getEstablecimientosPorCUIT() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst;
    }
    
    /**
     * Retorna los establecimientos vinculados a la razón social recibida
     * @param razonSocial
     * @return 
     */
    public List<Establecimiento> getEstablecimientoPorRazonSocial(String razonSocial){
        List<Establecimiento> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = estFacade.getByRazonSocial(razonSocial);
            logger.log(Level.INFO, "Ejecutando el método getEstablecimientoPorRazonSocial() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getEstablecimientoPorRazonSocial() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst;
    }
    
    /**
     * Retorna los Establecimientos que tramitan con el expediente recibido
     * @param num
     * @param anio
     * @return 
     */
    public List<Establecimiento> getEstablecimientosPorExp(int num, int anio){
        List<Establecimiento> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = estFacade.getByExp(num, anio);
            logger.log(Level.INFO, "Ejecutando el método getEstablecimientosPorExp() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getEstablecimientosPorExp() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst;
    }
    
    /**
     * Retorna solo los Establecimientos habilitados, ordanados por razón social
     * @return 
     */
    public List<Establecimiento> getEstablecimientosHabilitados(){
        List<Establecimiento> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = estFacade.getAtivos();
            logger.log(Level.INFO, "Ejecutando el método getEstablecimientosHabilitados() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getEstablecimientosHabilitados() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst;
    }
    
    public List<Establecimiento> getEstablecimientosExistentes(String calle, String numero, Long idLocalidad, TipoEstablecimiento tipo){
        List<Establecimiento> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = estFacade.getExistente(calle, numero, idLocalidad, tipo);
            logger.log(Level.INFO, "Ejecutando el método getEstablecimientosExistentes() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getEstablecimientosExistentes() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst;
    }
    
    /**
     * Método que devuelve todas las Actividades
     * @return 
     */
    public List<Actividad> getActividadesAll(){
        List<Actividad> lstAct = new ArrayList();
        Date date;
        try{
            lstAct = actividadFacade.findAllByOrder();
            logger.log(Level.INFO, "Ejecutando el método getActividadesAll() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getActividadesAll() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstAct;
    }
    
    /**
     * Método para obtener la Actividad según su id
     * @param id
     * @return 
     */
    public Actividad getActividad(Long id){
        Actividad act;
        Date date;
        try{
            act = actividadFacade.find(id);
            logger.log(Level.INFO, "Ejecutando el método getActividad() desde el servicio RUP");
        }catch(Exception ex){
            act = null;
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getActividad() desde el servicio RUP. " + date + ". ", ex);
        }
        return act;                
    }
    
    /**
     * Método para obtener el Tipo de Establecimiento según su nombre
     * @param nombre
     * @return 
     */
    public TipoEstablecimiento getTipoEstByNombre(String nombre){
        TipoEstablecimiento tipoEst;
        Date date;
        try{
            tipoEst = tipoEstFacade.getExistente(nombre);
            logger.log(Level.INFO, "Ejecutando el método getTipoEstByNombre() desde el servicio RUP");
        }catch(Exception ex){
            tipoEst = null;
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getTipoEstByNombre() desde el servicio RUP. " + date + ". ", ex);
        }
        return tipoEst; 
    }
    
    /**
     * Método para obtener la Especialidad según el nombre
     * @param nombre
     * @return 
     */
    public Especialidad getEspecialidadByNombre(String nombre){
        Especialidad esp;
        Date date;
        try{
            esp = espFacade.getExistente(nombre);
            logger.log(Level.INFO, "Ejecutando el método getTipoEspByNombre() desde el servicio RUP");
        }catch(Exception ex){
            esp = null;
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getTipoEspByNombre() desde el servicio RUP. " + date + ". ", ex);
        }
        return esp; 
    }
    
    /**
     * Método para crear un Establecimiento
     * @param est 
     */
    public void createEstablecimiento(Establecimiento est){
        Date date;
        try{
            estFacade.create(est);
            logger.log(Level.INFO, "Ejecutando el método createEstablecimiento() desde el servicio RUP");
        }catch(Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método createEstablecimiento() desde el servicio RUP. " + date + ". ", ex);
        }
    }       
    
    public void editEstablecimiento(Establecimiento est){
        Date date;
        try{
            estFacade.edit(est);
            logger.log(Level.INFO, "Ejecutando el método editEstablecimiento() desde el servicio RUP");
        }catch(Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método editEstablecimiento() desde el servicio RUP. " + date + ". ", ex);
        }
    }

    /**
     * Método para obtener un expediente según su id
     * @param id 
     * @return  
     */
    public Expediente getExpedienteById(Long id){
        Expediente exp;
        Date date;
        try{
            exp = expFacade.find(id);
            logger.log(Level.INFO, "Ejecutando el método getExpedienteById() desde el servicio RUP");
        }catch(Exception ex){
            exp = null;
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getExpedienteById() desde el servicio RUP. " + date + ". ", ex);
        }
        return exp;
    }
    
    /*********************
     * Personas Físicas **
     *********************/
    
    /**
     * Método que devuelve las personasa físicas más allá de su estado
     * @return 
     */
    public List<PerFisica> getPerFisicas(){
        List<PerFisica> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = perFisFacade.findAll();
            logger.log(Level.INFO, "Ejecutando el método getPerFisicas() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getPerFisicas() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst;
    }    
    
    /**
     * Método que devuelve las personasa físicas habilitadas
     * @return 
     */
    public List<PerFisica> getPerFisicasHabilitadas(){
        List<PerFisica> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = perFisFacade.getHabilitados();
            logger.log(Level.INFO, "Ejecutando el método getPerFisicasHabilitadas() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getPerFisicasHabilitadas() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst; 
    }
    
    /**
     * Método que devuelve las personasa físicas vinculadas al cuit
     * @param cuit
     * @return 
     */
    public PerFisica getPerFisicasPorCuit(Long cuit){
        PerFisica perFis = new PerFisica();
        Date date;
        try{
            perFis = perFisFacade.getByCuit(cuit);
            logger.log(Level.INFO, "Ejecutando el método getPerFisicasPorCuit() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getPerFisicasPorCuit() desde el servicio RUP. " + date + ". ", ex);
        }      
        return perFis; 
    }    
    
    /**
     * Método que devuelve las personasa físicas vinculadas al nombre
     * @param nombre
     * @return 
     */
    public List<PerFisica> getPerFisicasPorNombre(String nombre){
        List<PerFisica> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = perFisFacade.getByNombre(nombre);
            logger.log(Level.INFO, "Ejecutando el método getPerFisicasPorNombre() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getPerFisicasPorNombre() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst; 
    }    
    
    /**
     * Método que devuelve las persona física según su id
     * @param id
     * @return 
     */
    public PerFisica getPerFisicaPorId(Long id){
        PerFisica result;
        Date date;
        try{
            result = perFisFacade.find(id);
            logger.log(Level.INFO, "Ejecutando el método getPerFisicaPorId() desde el servicio RUP");
            return result;
        }catch(Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getPerFisicaPorId() desde el servicio RUP. " + date + ". ", ex);
            return null;
        }
    }
    
    /**
     * Retorna los Establecimientos que tramitan con el expediente recibido
     * @param num
     * @param anio
     * @return 
     */
    public List<PerFisica> getPerFisicasPorExp(int num, int anio){
        List<PerFisica> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = perFisFacade.getByExp(num, anio);
            logger.log(Level.INFO, "Ejecutando el método getPerFisicasPorExp() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getPerFisicasPorExp() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst;
    }    
    
    
    
    
    /***********************
     * Personas Jurídicas **
     ***********************/
    
    /**
     * Método que devuelve las persona jurídica según su id
     * @param id
     * @return 
     */
    public PerJuridica getPerJuridicaPorId(Long id){
        PerJuridica result;
        Date date;
        try{
            result = perJurFacade.find(id);
            logger.log(Level.INFO, "Ejecutando el método getPerJuridicaPorId() desde el servicio RUP");
            return result;
        }catch(Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getPerJuridicaPorId() desde el servicio RUP. " + date + ". ", ex);
            return null;
        }
    }    
    
    /**
     * Método que devuelve las personas jurídicas más allá de su estado
     * @return 
     */
    public List<PerJuridica> getPerJuridicas(){
        List<PerJuridica> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = perJurFacade.findAll();
            logger.log(Level.INFO, "Ejecutando el método getPerJuridicas() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getPerJuridicas() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst;
    }    
    
    /**
     * Método que devuelve las personas jurídicas habilitadas
     * @return 
     */
    public List<PerJuridica> getPerJuridicasHabilitadas(){
        List<PerJuridica> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = perJurFacade.getHabilitados();
            logger.log(Level.INFO, "Ejecutando el método getPerJuridicasHabilitadas() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getPerJuridicasHabilitadas() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst; 
    }    
    
    /**
     * Método que devuelve las personas jurídica cuyo cuit coincide con el parámetros de búsqueda
     * @return 
     */
    public PerJuridica getPerJuridicasPorCuit(Long cuit){
        PerJuridica perJur = new PerJuridica();
        Date date;
        try{
            perJur = perJurFacade.getByCuit(cuit);
            logger.log(Level.INFO, "Ejecutando el método getPerJuridicasPorCuit() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getPerJuridicasPorCuit() desde el servicio RUP. " + date + ". ", ex);
        }      
        return perJur; 
    }    
    
    /**
     * Método que devuelve las personas jurídicas vinculadas a la razón social
     * @param razonSocial
     * @return 
     */
    public List<PerJuridica> getPerJuridicasPorRazonSocial(String razonSocial){
        List<PerJuridica> lstEst = new ArrayList();
        Date date;
        try{
            lstEst = perJurFacade.getByRazonSocial(razonSocial);
            logger.log(Level.INFO, "Ejecutando el método getPerJuridicasPorNombre() desde el servicio RUP");
        }
        catch (Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getPerJuridicasPorNombre() desde el servicio RUP. " + date + ". ", ex);
        }      
        return lstEst; 
    }   
    
    public void createPerJuridica(PerJuridica perJur){
        Date date;
        try{
            perJurFacade.create(perJur);
            logger.log(Level.INFO, "Ejecutando el método createPerJuridica() desde el servicio RUP");
        }catch(Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método createPerJuridica() desde el servicio RUP. " + date + ". ", ex);
        }
    }    
    
    public void editPerJuridica(PerJuridica perJur){
        Date date;
        try{
            perJurFacade.edit(perJur);
            logger.log(Level.INFO, "Ejecutando el método editPerJuridica() desde el servicio RUP");
        }catch(Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método editPerJuridica() desde el servicio RUP. " + date + ". ", ex);
        }
    }
    
    public TipoPersonaJuridica getTipoPerJuridica(Long id){
        TipoPersonaJuridica tpj;
        Date date;
        try{
            tpj = tipoPerJurFacade.find(id);
            logger.log(Level.INFO, "Ejecutando el método getTipoPerJuridica() desde el servicio RUP");
        }catch(Exception ex){
            tpj = null;
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getTipoPerJuridica() desde el servicio RUP. " + date + ". ", ex);
        }
        return tpj;
    }
    
    public List<TipoPersonaJuridica> getTipoPersonaJuridicaAll(){
        List<TipoPersonaJuridica> lstPerJur = new ArrayList();
        Date date;
        try{
            lstPerJur = tipoPerJurFacade.findAll();
            logger.log(Level.INFO, "Ejecutando el método getTipoPersonaJuridicaAll() desde el servicio RUP");
        }catch(Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getTipoPersonaJuridicaAll() desde el servicio RUP. " + date + ". ", ex);
        }
        return lstPerJur;
    }
    
    public TipoPersonaJuridica getTipoPerJurByNombre(String nombre){
        TipoPersonaJuridica tipoPerJur;
        Date date;  
        
        try{
            tipoPerJur = tipoPerJurFacade.getExistente(nombre);
            logger.log(Level.INFO, "Ejecutando el método getTipoPerJurByNombre() desde el servicio RUP");
        }catch(Exception ex){
            tipoPerJur = null;
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getTipoPerJurByNombre() desde el servicio RUP. " + date + ". ", ex);
        }
        return tipoPerJur;
    }
    
    public Estado getEstadoByNombre(String nombre){
        Estado est;
        Date date;
        
        try{
            est = estadoFacade.getExistente(nombre);
            logger.log(Level.INFO, "Ejecutando el método getEstadoByNombre() desde el servicio RUP");
        }catch(Exception ex){
            est = null;
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getEstadoByNombre() desde el servicio RUP. " + date + ". ", ex);
        }
        return est;
    }
    
    /*************
     * Usuarios **
     *************/   
    
    /**
     * Método que devuelve el usuario rup según el nombre
     * @param nombre
     * @return 
     */
    public Usuario getUsuarioByNombre(String nombre){
        Usuario us;
        Date date;
        try{
            us = usRupFacade.getUsuario(nombre);
            logger.log(Level.INFO, "Ejecutando el método getUsuarioByNombre() desde el servicio RUP");
        }catch(Exception ex){
            us = null;
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getUsuarioByNombre() desde el servicio RUP. " + date + ". ", ex);
        }
        return us;
    }
    
    public ReasignaRazonSocial getUltimaRazSocActiva(Establecimiento est){
        ReasignaRazonSocial rrs;
        Date date;
        try{
            rrs = reasignaRazSocFacade.getUltimaActiva(est);
            logger.log(Level.INFO, "Ejecutando el método getUltimaRazSocActiva() desde el servicio RUP");
        }catch(Exception ex){
            rrs = null;
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método getUltimaRazSocActiva() desde el servicio RUP. " + date + ". ", ex);
        }
        return rrs;
    }
    
    public void createRazSoc(ReasignaRazonSocial reasRazSoc){
        Date date;
        try{
            reasignaRazSocFacade.create(reasRazSoc);
            logger.log(Level.INFO, "Ejecutando el método createRazSoc() desde el servicio RUP");
        }catch(Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método createRazSoc() desde el servicio RUP. " + date + ". ", ex);
        }
    }
    
    public void editRazSoc(ReasignaRazonSocial reasRazSoc){
        Date date;
        try{
            reasignaRazSocFacade.edit(reasRazSoc);
            logger.log(Level.INFO, "Ejecutando el método editRazSoc() desde el servicio RUP");
        }catch(Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método editRazSoc() desde el servicio RUP. " + date + ". ", ex);
        }
    }
    
    @Override
    public void deleteRazSoc(ReasignaRazonSocial reasRazSoc){
        Date date;
        try{
            reasignaRazSocFacade.remove(reasRazSoc);
            logger.log(Level.INFO, "Ejecutando el método deleteRazSoc() desde el servicio RUP");
        }catch(Exception ex){
            date = new Date(System.currentTimeMillis());
            logger.log(Level.SEVERE, "Hubo un error al ejecutar el método deleteRazSoc() desde el servicio RUP. " + date + ". ", ex);
        }
    }
}
