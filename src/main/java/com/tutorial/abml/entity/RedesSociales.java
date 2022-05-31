
package com.tutorial.abml.entity;

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
@Table (name="tblredes_sociales")
public class RedesSociales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String red;
    private String link;
    private String imagen;

    public RedesSociales() {
    }

    public RedesSociales(int id, String red, String link, String imagen) {
        this.id = id;
        this.red = red;
        this.link = link;
        this.imagen = imagen;
    }
    
    
    
}
