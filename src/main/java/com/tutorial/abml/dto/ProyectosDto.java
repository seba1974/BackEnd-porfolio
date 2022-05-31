package com.tutorial.abml.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProyectosDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String fecha;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String link;
    @NotBlank
    private String imagen;

    
    
    
    public ProyectosDto() {
    }

    public ProyectosDto(String nombre, String fecha, String descripcion, String link, String imagen) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.link = link;
        this.imagen = imagen;
    }


}