package com.tutorial.abml.controller;

import com.tutorial.abml.dto.UsuarioDto;
import com.tutorial.abml.dto.Mensaje;
import com.tutorial.abml.entity.UsuarioOld;
import com.tutorial.abml.service.UsuarioServiceOld;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin ( origins = "//localhost:4200")
// @CrossOrigin(origins = "https://frontend-sebaveloce.web.app")

public class UsuarioController {
    
@Autowired // Hace que toda la clase UsuarioService se cree un objeto y la guarda dentro de usuarioService
    UsuarioServiceOld usuarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<UsuarioOld>> list(){
        List<UsuarioOld> list = usuarioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<UsuarioOld> getById(@PathVariable("id") int id){
        if(!usuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        UsuarioOld usuario = usuarioService.getOne(id).get();
        return new ResponseEntity(usuario, HttpStatus.OK);
    }
 
   

    //@PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/crear")
     public ResponseEntity<?> create(@RequestBody UsuarioDto usuarioDto){
        UsuarioOld usuario = new UsuarioOld();
        
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido(usuarioDto.getApellido());
        usuario.setFecha_nacimiento(usuarioDto.getFecha_nacimiento());
        usuario.setDomicilio(usuarioDto.getDomicilio());
        usuario.setNacionalidad(usuarioDto.getNacionalidad());
        usuario.setMail(usuarioDto.getMail());
        usuario.setPassword(usuarioDto.getPassword());
        usuario.setSobre_mi(usuarioDto.getSobre_mi());
        usuario.setOcupacion(usuarioDto.getOcupacion());
        usuario.setImagen_background_header(usuarioDto.getImagen_background_header());
        usuario.setImagen_perfil(usuarioDto.getImagen_perfil());
        usuario.setPerfil(usuarioDto.getPerfil());
        
                
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("El usuario fue creado"), HttpStatus.OK);
    }

     
     
    //@PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody UsuarioDto usuarioDto){
        
        UsuarioOld usuario = usuarioService.getOne(id).get();
        
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido(usuarioDto.getApellido());
        usuario.setFecha_nacimiento(usuarioDto.getFecha_nacimiento());
        usuario.setDomicilio(usuarioDto.getDomicilio());
        usuario.setNacionalidad(usuarioDto.getNacionalidad());
        usuario.setMail(usuarioDto.getMail());
        usuario.setPassword(usuarioDto.getPassword());
        usuario.setSobre_mi(usuarioDto.getSobre_mi());
        usuario.setOcupacion(usuarioDto.getOcupacion());
        usuario.setImagen_background_header(usuarioDto.getImagen_background_header());
        usuario.setImagen_perfil(usuarioDto.getImagen_perfil());
        usuario.setPerfil(usuarioDto.getPerfil());

        
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("Registro de usuario Actualizado"), HttpStatus.OK);
    }

    
    
    //@PreAuthorize ("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!usuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de Usuario"), HttpStatus.NOT_FOUND);
        usuarioService.delete(id);
        return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
    }    
}
