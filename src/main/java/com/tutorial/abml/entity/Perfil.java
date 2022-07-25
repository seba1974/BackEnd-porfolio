 
package com.tutorial.abml.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="tblperfil")
public class Perfil implements Serializable {
    @Column (name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "apellido")
    private String apellido;
    @Column (name = "fecha_nacimiento")
    private String fecha_nacimiento;
    @Column (name = "domicilio")
    private String domicilio;
    @Column (name = "nacionalidad")
    private String nacionalidad;
    @Column (name = "mail")
    private String mail;
    @Column (name = "password")
    private String password;
    @Column (name = "sobre_mi")
    private String sobre_mi;
    @Column (name = "ocupacion")
    private String ocupacion;
    @Column (name = "imagen_background_header")
    private String imagen_background_header;
    @Column (name = "imagen_perfil")
    private String imagen_perfil;
    @Column (name = "perfil")
    private String perfil;

    public Perfil() {
    }

    public Perfil(int id, String nombre, String apellido, String fecha_nacimiento, String domicilio, String nacionalidad, String mail, String password, String sobre_mi, String ocupacion, String imagen_background_header, String imagen_perfil, String perfil) {
        this.id = id;
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
