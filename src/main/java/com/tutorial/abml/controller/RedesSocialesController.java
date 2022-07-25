
package com.tutorial.abml.controller;

import com.tutorial.abml.dto.RedesSocialesDto;
import com.tutorial.abml.dto.Mensaje;
import com.tutorial.abml.entity.RedesSociales;
import com.tutorial.abml.service.RedesSocialesService;
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
@RequestMapping("/redessociales")
@CrossOrigin ("http://localhost:4200")     //("//https://frontend-sebaveloce.web.app")
// @CrossOrigin(origins = "https://frontend-sebaveloce.web.app")
public class RedesSocialesController {
    
    @Autowired
    RedesSocialesService redesSocialesService;

    @GetMapping("/lista")
    public ResponseEntity<List<RedesSociales>> list(){
        List<RedesSociales> list = redesSocialesService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<RedesSociales> getById(@PathVariable("id") int id){
        if(!redesSocialesService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        RedesSociales redessociales = redesSocialesService.getOne(id).get();
        return new ResponseEntity(redessociales, HttpStatus.OK);
    }

   
    @PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/crear")
     public ResponseEntity<?> create(@RequestBody RedesSocialesDto redesSocialesDto){    
        RedesSociales redessociales = new RedesSociales();
        
        redessociales.setRed(redesSocialesDto.getRed());
        redessociales.setLink(redesSocialesDto.getLink());
        redessociales.setImagen(redesSocialesDto.getImagen());
        
        
        redesSocialesService.save(redessociales);
        return new ResponseEntity(new Mensaje("La Red Social fue creada"), HttpStatus.OK);
    }

    @PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody RedesSocialesDto redesSocialesDto){
        
        RedesSociales redessociales = redesSocialesService.getOne(id).get();
        
        redessociales.setRed(redesSocialesDto.getRed());
        redessociales.setLink(redesSocialesDto.getLink());
        redessociales.setImagen(redesSocialesDto.getImagen());
        
        redesSocialesService.save(redessociales);
        return new ResponseEntity(new Mensaje("Registro de Red Social Actualizado"), HttpStatus.OK);
    }

    @PreAuthorize ("hasRole('ADMIN')")  
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!redesSocialesService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de Red Social"), HttpStatus.NOT_FOUND);
        redesSocialesService.delete(id);
        return new ResponseEntity(new Mensaje("Red Social eliminada"), HttpStatus.OK);
    }
    
}
