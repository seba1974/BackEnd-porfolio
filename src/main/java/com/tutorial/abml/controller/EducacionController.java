
package com.tutorial.abml.controller;

import com.tutorial.abml.dto.Mensaje;
import com.tutorial.abml.dto.EducacionDto;
import com.tutorial.abml.entity.Educacion;

import com.tutorial.abml.service.EducacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/educacion")
@CrossOrigin ("http://localhost:4200")     //("//https://frontend-sebaveloce.web.app")
// @CrossOrigin(origins = "https://frontend-sebaveloce.web.app")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

   

    @PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/crear")
     //public ResponseEntity<?> create(@PathVariable("id")int id, @RequestBody EducacionDto educacionDto){    
     //   Educacion educacion = educacionService.getOne(id).get();
        
    public ResponseEntity<?> create(@RequestBody EducacionDto educacionDto){
        Educacion educacion = new Educacion();
        
        educacion.setInstitucion(educacionDto.getInstitucion());
        educacion.setTitulo(educacionDto.getTitulo());
        educacion.setImagen(educacionDto.getImagen());
        educacion.setEstado(educacionDto.getEstado());
        educacion.setPromedio(educacionDto.getPromedio());
        educacion.setAnio_inicio(educacionDto.getAnio_inicio());
        educacion.setAnio_fin(educacionDto.getAnio_fin());
        
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("La Educacion fue creada"), HttpStatus.OK);
    }

    @PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EducacionDto educacionDto){
        
        Educacion educacion = educacionService.getOne(id).get();
        
        educacion.setInstitucion(educacionDto.getInstitucion());
        educacion.setTitulo(educacionDto.getTitulo());
        educacion.setImagen(educacionDto.getImagen());
        educacion.setEstado(educacionDto.getEstado());
        educacion.setPromedio(educacionDto.getPromedio());
        educacion.setAnio_inicio(educacionDto.getAnio_inicio());
        educacion.setAnio_fin(educacionDto.getAnio_fin());
        
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Registro de Educacion Actualizado"), HttpStatus.OK);
    }

    @PreAuthorize ("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de educacion"), HttpStatus.NOT_FOUND);
        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminado"), HttpStatus.OK);
    }


}
