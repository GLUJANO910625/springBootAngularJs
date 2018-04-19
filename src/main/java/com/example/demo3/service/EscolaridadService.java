package com.example.demo3.service;

import com.example.demo3.Dao.EscolaridadDao;
import com.example.demo3.model.Escolaridad;
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

    //no se a subido el cambio del servicio
 /*   @Transactional
    public void save(Escolaridad escolaridad)throws Exception{

            escolaridad.setFechaRegistro(new Date());
            escolaridadDao.save(escolaridad);

    }

    @Transactional
    public void update(Escolaridad escolaridad)throws Exception{

            Escolaridad escolaridadOriginal = this.getById(escolaridad.getId());

            //validacion si se quiere actualizar el ID se cancela la operación
            if (!escolaridad.getId().equals(escolaridadOriginal.getId())) {
                throw new Exception("Id no se puede actualizar");
            }

            if (escolaridad.getFechaRegistro() != null) {
                String escolaridadFecha = new SimpleDateFormat("yyyy-MM-dd").format(escolaridad.getFechaRegistro());
                String originalEscolaridadFecha = new SimpleDateFormat("yyyy-MM-dd").format(escolaridadOriginal.getFechaRegistro());
                if (!escolaridadFecha.equals(originalEscolaridadFecha)) {
                    throw new Exception("FechaRegistro no se puede actualizar.");
                }
            }


            escolaridadOriginal.setCodigo(escolaridad.getCodigo());
            escolaridadOriginal.setDescripcion(escolaridad.getDescripcion());
            escolaridadOriginal.setNombre(escolaridad.getNombre());
            escolaridadOriginal.setRequiereTitulo(escolaridad.getRequiereTitulo());

            escolaridadDao.update(escolaridadOriginal);

    }
    @Transactional
    public void delete(Escolaridad escolaridad)throws Exception{

            Escolaridad escolaridadEliminar = this.getById(escolaridad.getId());

            if (escolaridadEliminar.getId() == null){
                throw new Exception("El registro del Especialidad no se encontro.");
            }

            escolaridadDao.delete(escolaridadEliminar);

    }

    public Escolaridad getById(Long id){
        return (Escolaridad) escolaridadDao.getById(Escolaridad.class, id);
    }*/

/*
    public List<Escolaridad> getList(Escolaridad escolaridad){
        Escolaridad escolaridad1 = new Escolaridad();
        escolaridad1.setCodigo("ESC001");

        List<Escolaridad> escolaridadList = new ArrayList<>();
        List<Serializable> serializableList = this.escolaridadDao.list(escolaridad1);

        for (Serializable serializable : serializableList) {
            escolaridadList.add((Escolaridad) serializable);
        }
        return escolaridadList;
    }
*/

    public List<Escolaridad> getList() {
        Escolaridad escolaridad = new Escolaridad();
        return (List<Escolaridad>) escolaridadDao.findAll(escolaridad);
    }

}
