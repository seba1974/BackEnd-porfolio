
package com.tutorial.abml.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursosDto {
    
    @NotBlank
    private String anio;
    @NotBlank
    private String curso;
    @NotBlank
    private String dictado_por;

    public CursosDto() {
    }

    public CursosDto(String anio, String curso, String dictado_por) {
        
        this.anio = anio;
        this.curso = curso;
        this.dictado_por = dictado_por;
    }
    
    
    
}
