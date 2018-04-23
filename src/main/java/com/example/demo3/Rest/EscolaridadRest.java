package com.example.demo3.Rest;

import com.example.demo3.service.EscolaridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo3.model.Escolaridad;
import javax.ws.rs.*;
import java.util.List;

@Path("escolaridad")
@Component
public class EscolaridadRest {

    @Autowired
    @Qualifier("escolaridadService")
    private EscolaridadService escolaridadService;

    @POST
    @Path("put")
    @Produces("application/json")
    @Consumes("application/json")
    public Escolaridad put(Escolaridad escolaridad)throws Exception{

        if (escolaridad.getId()!=null){
           // escolaridadService.update(escolaridad);
        }else {
            escolaridadService.save(escolaridad);
        }

        return escolaridad;
    }

/*
    @POST
    @Path("put")
    @Produces("application/json")
    @Consumes("application/json")
    public Escolaridad put(Escolaridad escolaridad)throws Exception{

            if (escolaridad.getId()!=null){
                escolaridadService.update(escolaridad);
            }else {
                escolaridadService.save(escolaridad);
            }

        return escolaridad;
    }

    @POST
    @Path("delete")
    @Consumes("application/json")
    @Produces("application/json")
    public Escolaridad delete(Escolaridad escolaridad)throws Exception{
        escolaridadService.delete(escolaridad);
        return escolaridad;
    }

    @GET
    @Path("id")
    @Produces("application/json")
    public Escolaridad byId (@QueryParam("id") Long id) throws Exception{
        return escolaridadService.getById(id);
    }
*/

    @POST
    @Path("list")
    @Consumes("application/json")
    @Produces("application/json")
    public List<Escolaridad> list( ) {
        return escolaridadService.getList();
    }

}
