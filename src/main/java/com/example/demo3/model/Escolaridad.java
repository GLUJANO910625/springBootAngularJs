package com.example.demo3.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="ESCOLARIDAD")
public class Escolaridad implements Serializable {

    @Id
    @Column(name = "ESCOLARIDAD_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ESCOLARIDAD_CODIGO", nullable = false, length = 15)
    private String codigo;

    @Column(name = "ESCOLARIDAD_NOMBRE", nullable = true, length = 150)
    private String nombre;

    @Column(name = "ESCOLARIDAD_DESCRIPCION", nullable = true, length = 150)
    private String descripcion;

    @Column(name = "ESCOLARIDAD_REQUIERETITULO", nullable = true)
    private Boolean requiereTitulo;

    @NotNull
    @Column(name = "ESCOLARIDAD_FECHAREGISTRO", nullable = false)
    private Date fechaRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getRequiereTitulo() {
        return requiereTitulo;
    }

    public void setRequiereTitulo(Boolean requiereTitulo) {
        this.requiereTitulo = requiereTitulo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}