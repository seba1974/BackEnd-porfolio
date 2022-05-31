
package com.tutorial.abml.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RedesSocialesDto {
    @NotBlank
    private String red;
    @NotBlank
    private String link;
    @NotBlank
    private String imagen;

    public RedesSocialesDto() {
    }

    public RedesSocialesDto(String red, String link, String imagen) {
        this.red = red;
        this.link = link;
        this.imagen = imagen;
    }
    
    
    
}
