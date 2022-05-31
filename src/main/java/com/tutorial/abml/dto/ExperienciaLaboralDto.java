
package com.tutorial.abml.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperienciaLaboralDto {
    
    @NotBlank
    private String empresa;
    @NotBlank
    private String puesto;
    @NotBlank
    private String ubic_empresa;
    @NotBlank
    private String area_cobertura;
    @NotBlank
    private String img_logo;
    @NotBlank
    private String fecha_ingreso;
    @NotBlank
    private String fecha_egreso;
    @NotBlank
    private String descripcion;

    public ExperienciaLaboralDto() {
    }

    public ExperienciaLaboralDto(String empresa, String ubic_empresa, String area_cobertura, String puesto, String fecha_ingreso, String fecha_egreso, String img_logo, String descripcion) {
        
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