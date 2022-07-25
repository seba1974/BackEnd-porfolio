
package com.tutorial.abml.dto;

import com.tutorial.abml.entity.Perfil;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String fecha_nacimiento;
    @NotBlank
    private String domicilio;
    @NotBlank
    private String nacionalidad;
    @NotBlank
    private String mail;
    @NotBlank
    private String password;
    @NotBlank
    private String sobre_mi;
    @NotBlank
    private String ocupacion;
    @NotBlank
    private String imagen_background_header;
    @NotBlank
    private String imagen_perfil;
    @NotBlank
    private String perfil;

    public PerfilDto() {
    }

    public PerfilDto(String nombre, String apellido, String fecha_nacimiento, String domicilio, String nacionalidad, String mail, String password, String sobre_mi, String ocupacion, String imagen_background_header, String imagen_perfil, String perfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.domicilio = domicilio;
        this.nacionalidad = nacionalidad;
        this.mail = mail;
        this.password = password;
        this.sobre_mi = sobre_mi;
        this.ocupacion = ocupacion;
        this.imagen_background_header = imagen_background_header;
        this.imagen_perfil = imagen_perfil;
        this.perfil = perfil;
    }

    
    
}
