
package com.tutorial.abml.controller;

import com.tutorial.abml.dto.CursosDto;
import com.tutorial.abml.dto.Mensaje;
import com.tutorial.abml.entity.Cursos;
import com.tutorial.abml.service.CursosService;
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
// @CrossOrigin ("http://localhost:4200")     //("//https://frontend-sebaveloce.web.app")
 @CrossOrigin ( origins = "https://frontend-sebaveloce.web.app")
@RequestMapping ("/cursos")
public class CursosController {
    
    @Autowired
    CursosService cursosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Cursos>> list(){
        List<Cursos> list = cursosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Cursos> getById(@PathVariable("id") int id){
        if(!cursosService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        Cursos cursos = cursosService.getOne(id).get();
        return new ResponseEntity(cursos, HttpStatus.OK);
    }

   

    @PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody CursosDto cursosDto){
        Cursos cursos = new Cursos();
        
        cursos.setAnio(cursosDto.getAnio());
        cursos.setCurso(cursosDto.getCurso());
        cursos.setDictado_por(cursosDto.getDictado_por());
        
        cursosService.save(cursos);
        return new ResponseEntity(new Mensaje("El curso fue creado"), HttpStatus.OK);
    }

    @PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody CursosDto cursosDto){
        
        Cursos cursos = cursosService.getOne(id).get();
        
        cursos.setAnio(cursosDto.getAnio());
        cursos.setCurso(cursosDto.getCurso());
        cursos.setDictado_por(cursosDto.getDictado_por());
        
        cursosService.save(cursos);
        return new ResponseEntity(new Mensaje("Registro de cursos fue Actualizado"), HttpStatus.OK);
    }

    @PreAuthorize ("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!cursosService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de cursos"), HttpStatus.NOT_FOUND);
        cursosService.delete(id);
        return new ResponseEntity(new Mensaje("curso eliminado"), HttpStatus.OK);
    }
    
}
