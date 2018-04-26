package com.example.demo3.service;

/*import com.ddlab.rnd.exception.BeanValidationFailedException;*/
import com.example.demo3.Dao.EscolaridadDao;
import com.example.demo3.model.Escolaridad;
import liquibase.snapshot.EmptyDatabaseSnapshot;
import org.hibernate.cfg.beanvalidation.BeanValidationEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class EscolaridadService {
//prueba cambio.
    @Autowired
    @Qualifier(value = "escolaridadDao")
    private EscolaridadDao escolaridadDao;

    @Transactional
    public void save(Escolaridad escolaridad) throws Exception{
        /*try {*/
            escolaridad.setFechaRegistro(new Date());
            escolaridadDao.save(escolaridad);

        /*}catch (BeanValidationFailedException e){

        }*/
    }

    @Transactional
    public void update(Escolaridad escolaridad) throws Exception{
        /*try {*/
            Escolaridad escolaridadOriginal = this.getById(escolaridad.getId());

            if (escolaridad.getFechaRegistro() != null) {

                String escolaridadActual = new SimpleDateFormat("yyyy-MM-dd").format(escolaridad.getFechaRegistro());
                String originalescolaridadFecha = new SimpleDateFormat("yyyy-MM-dd").format(escolaridadOriginal.getFechaRegistro());
                if (!originalescolaridadFecha.equals(escolaridadActual)) {

                    throw new Exception("Fecha Registro no se puede Actualizar.");
                }
            }

            if (!escolaridad.getId().equals(escolaridadOriginal.getId())) {
                throw new Exception("Id no se puede actualizar");
            }

            escolaridadOriginal.setNombre(escolaridad.getNombre());
            escolaridadOriginal.setDescripcion(escolaridad.getDescripcion());
            escolaridadDao.update(escolaridadOriginal);


        /*}catch (BeanValidationFailedException e){

        }*/
    }

    /**
     * Metodo para la eliminacion de objetos de la base de datos invocando servicio de Jpa.
     * @param escolaridad
     * @return
     */
    @Transactional
    public Escolaridad delete(Escolaridad escolaridad)throws Exception{

        Escolaridad escolaridadEliminar = this.getById(escolaridad.getId());

        if(escolaridadEliminar.getId() != null){
            escolaridadDao.delete(escolaridadEliminar.getId());

        }else{
            throw new Exception("El registro no se encontro");
        }
        return null;
    }

    public Escolaridad getById(Long id){
        return (Escolaridad) escolaridadDao.findById(id);
    }

    public List<Escolaridad> getList() {
        Escolaridad escolaridad = new Escolaridad();
        return (List<Escolaridad>) escolaridadDao.findAll(escolaridad);
    }

}
