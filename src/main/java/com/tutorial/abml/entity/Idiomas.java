
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
@Table (name="tblidiomas")
public class Idiomas implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String idioma;
    private String porcentaje_oral;
    private String porcentaje_escrita;
    private String porcentaje_lectura;


    public Idiomas() {
    }

    public Idiomas(int id,String idioma, String porcentaje_oral, String porcentaje_escrita, String porcentaje_lectura) {
        this.id = id;
        this.idioma = idioma;
        this.porcentaje_oral = porcentaje_oral;
        this.porcentaje_escrita = porcentaje_escrita;
        this.porcentaje_escrita = porcentaje_lectura;
    }

    
    
}
