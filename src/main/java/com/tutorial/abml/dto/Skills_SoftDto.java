
package com.tutorial.abml.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Skills_SoftDto {
    @NotBlank
    private String habilidad;
    @NotBlank
    private String porcentaje;

    public Skills_SoftDto() {
    }

    public Skills_SoftDto(String habilidad, String porcentaje) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }
    
}
