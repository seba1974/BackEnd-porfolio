
package com.tutorial.abml.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdiomasDto {
    
    @NotBlank
    private String idioma;
    @NotBlank
    private String porcentaje_oral;
    @NotBlank
    private String porcentaje_escrita;
    @NotBlank
    private String porcentaje_lectura;

    public IdiomasDto() {
    }

    public IdiomasDto(String dni, String idioma, String porcentaje_oral, String porcentaje_escrita,String porcentaje_lectura) {
        
        this.idioma = idioma;
        this.porcentaje_oral = porcentaje_oral;
        this.porcentaje_escrita = porcentaje_escrita;
        this.porcentaje_lectura = porcentaje_lectura;
    }

    
    
}
