
package com.tutorial.abml.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="tblproyectos")
public class Proyectos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String fecha;
    private String descripcion;
    private String link;
    private String imagen;

    public Proyectos() {
    }

    public Proyectos(int id, String nombre, String fecha, String descripcion, String link, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.link = link;
        this.imagen = imagen;
    }
    
    
    
    
}
