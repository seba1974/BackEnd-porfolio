
package com.tutorial.abml.dto;



import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducacionDto {

    @NotBlank
    private String institucion;
    @NotBlank
    private String titulo;
    @NotBlank
    private String imagen;
    @NotBlank
    private String estado;
    @NotBlank
    private String promedio;
    @NotBlank
    private String anio_inicio;
    @NotBlank
    private String anio_fin;

    public EducacionDto() {
    }

    public EducacionDto(String institucion, String titulo, String imagen, String estado, String promedio, String anio_inicio, String anio_fin) {
        
        this.institucion = institucion;
        this.titulo = titulo;
        this.imagen = imagen;
        this.estado = estado;
        this.promedio = promedio;
        this.anio_inicio = anio_inicio;
        this.anio_fin = anio_fin;
    }

    
}

