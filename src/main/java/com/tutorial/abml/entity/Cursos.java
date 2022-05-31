
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
@Table (name="tblcursos")

public class Cursos implements Serializable{
    
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String anio;
    private String curso;
    private String dictado_por;

    public Cursos() {
    }

    public Cursos(int id, String anio, String curso, String dictado_por) {
        this.id = id;
        this.anio = anio;
        this.curso = curso;
        this.dictado_por = dictado_por;
    }
 
    
    
}
