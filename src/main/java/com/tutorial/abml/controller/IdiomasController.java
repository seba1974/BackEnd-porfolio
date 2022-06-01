
package com.tutorial.abml.controller;

import com.tutorial.abml.dto.IdiomasDto;
import com.tutorial.abml.dto.Mensaje;
import com.tutorial.abml.entity.Idiomas;
import com.tutorial.abml.service.IdiomasService;
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
@RequestMapping("/idiomas")
@CrossOrigin ( origins = "//localhost:4200")
// @CrossOrigin(origins = "https://frontend-sebaveloce.web.app")

public class IdiomasController {
@Autowired
    IdiomasService idiomasService;

    @GetMapping("/lista")
    public ResponseEntity<List<Idiomas>> list(){
        List<Idiomas> list = idiomasService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Idiomas> getById(@PathVariable("id") int id){
        if(!idiomasService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        Idiomas idiomas = idiomasService.getOne(id).get();
        return new ResponseEntity(idiomas, HttpStatus.OK);
    }

   

    //@PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/crear")
     public ResponseEntity<?> create(@RequestBody IdiomasDto idiomasDto){
        Idiomas idiomas = new Idiomas();
        
        idiomas.setIdioma(idiomasDto.getIdioma());
        idiomas.setPorcentaje_oral(idiomasDto.getPorcentaje_oral());
        idiomas.setPorcentaje_escrita(idiomasDto.getPorcentaje_escrita());
        idiomas.setPorcentaje_lectura(idiomasDto.getPorcentaje_lectura());
        
        idiomasService.save(idiomas);
        return new ResponseEntity(new Mensaje("El idioma fue creado"), HttpStatus.OK);
    }

    //@PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody IdiomasDto idiomasDto){
        
        Idiomas idiomas = idiomasService.getOne(id).get();
        
        idiomas.setIdioma(idiomasDto.getIdioma());
        idiomas.setPorcentaje_oral(idiomasDto.getPorcentaje_oral());
        idiomas.setPorcentaje_escrita(idiomasDto.getPorcentaje_escrita());
        idiomas.setPorcentaje_lectura(idiomasDto.getPorcentaje_lectura());
        
        idiomasService.save(idiomas);
        return new ResponseEntity(new Mensaje("Registro de Idiomas fue Actualizado"), HttpStatus.OK);
    }

    //@PreAuthorize ("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!idiomasService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de Idiomas"), HttpStatus.NOT_FOUND);
        idiomasService.delete(id);
        return new ResponseEntity(new Mensaje("Idioma eliminado"), HttpStatus.OK);
    }    
}
