
package com.tutorial.abml.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table (name="tbleducacion")
public class Educacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String institucion;
    private String titulo;
    private String imagen;
    private String estado;
    private String promedio;
    private String anio_inicio;
    private String anio_fin;

    public Educacion() {
    }

    public Educacion(int id,String institucion, String titulo, String imagen, String estado, String promedio, String anio_inicio, String anio_fin) {
        this.id = id;
        this.institucion = institucion;
        this.titulo = titulo;
        this.imagen = imagen;
        this.estado = estado;
        this.promedio = promedio;
        this.anio_inicio = anio_inicio;
        this.anio_fin = anio_fin;
    }

    
    
}