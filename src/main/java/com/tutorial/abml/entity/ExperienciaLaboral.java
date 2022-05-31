
package com.tutorial.abml.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Setter;
import lombok.Getter;

@Entity
@Setter
@Getter
@Table (name="tblexperiencia_laboral")
public class ExperienciaLaboral implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    private String empresa;
    private String ubic_empresa;
    private String area_cobertura;
    private String puesto;
    private String fecha_ingreso;
    private String fecha_egreso;
    private String img_logo;
    private String descripcion;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(int id,String empresa, String ubic_empresa, String area_cobertura, String puesto, String fecha_ingreso, String fecha_egreso, String img_logo, String descripcion) {
        this.id = id;
        this.empresa = empresa;
        this.ubic_empresa = ubic_empresa;
        this.area_cobertura = area_cobertura;
        this.puesto = puesto;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_egreso = fecha_egreso;
        this.img_logo = img_logo;
        this.descripcion = descripcion;
    }
    
    
}
