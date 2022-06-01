
package com.tutorial.abml.controller;

import com.tutorial.abml.dto.Mensaje;
import com.tutorial.abml.dto.ProyectosDto;
import com.tutorial.abml.entity.Proyectos;
import com.tutorial.abml.service.ProyectosService;
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
@CrossOrigin ( origins = "//localhost:4200")
// @CrossOrigin ( origins = "https://frontend-sebaveloce.web.app")
@RequestMapping ("/proyectos")
public class ProyectosController {
    
    @Autowired
    ProyectosService proyectosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

   

    //@PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody ProyectosDto proyectosDto){
        Proyectos proyectos = new Proyectos(); 
        
        proyectos.setNombre(proyectosDto.getNombre());
        proyectos.setFecha(proyectosDto.getFecha());
        proyectos.setDescripcion(proyectosDto.getDescripcion());
        proyectos.setLink(proyectosDto.getLink());
        proyectos.setImagen(proyectosDto.getImagen());
        
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("El proyecto fue creado"), HttpStatus.OK);
    }

    //@PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProyectosDto proyectosDto){
        
        Proyectos proyectos = proyectosService.getOne(id).get();
        
        proyectos.setNombre(proyectosDto.getNombre());
        proyectos.setFecha(proyectosDto.getFecha());
        proyectos.setDescripcion(proyectosDto.getDescripcion());
        proyectos.setLink(proyectosDto.getLink());
        proyectos.setImagen(proyectosDto.getImagen());
        
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Registro de proyectos fue Actualizado"), HttpStatus.OK);
    }

    //@PreAuthorize ("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de proyectos"), HttpStatus.NOT_FOUND);
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("curso eliminado"), HttpStatus.OK);
    }
    
}
