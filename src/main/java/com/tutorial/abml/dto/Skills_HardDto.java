
package com.tutorial.abml.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Skills_HardDto {
    @NotBlank
    private String habilidad;
    @NotBlank
    private String porcentaje;

    public Skills_HardDto() {
    }

    public Skills_HardDto(String habilidad, String porcentaje) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }
    
    
}
