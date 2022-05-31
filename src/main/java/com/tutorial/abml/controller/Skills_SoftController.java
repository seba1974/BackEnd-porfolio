
package com.tutorial.abml.controller;

import com.tutorial.abml.dto.Mensaje;
import com.tutorial.abml.dto.Skills_SoftDto;
import com.tutorial.abml.entity.Skills_Soft;
import com.tutorial.abml.service.Skills_SoftService;
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
@RequestMapping ("/skills_soft")
@CrossOrigin(origins = "https://frontend-sebaveloce.web.app")
public class Skills_SoftController {

@Autowired
    Skills_SoftService skills_softService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills_Soft>> list(){
        List<Skills_Soft> list = skills_softService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills_Soft> getById(@PathVariable("id") int id){
        if(!skills_softService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        Skills_Soft skills_soft = skills_softService.getOne(id).get();
        return new ResponseEntity(skills_soft, HttpStatus.OK);
    }

   

    //@PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/crear")
     public ResponseEntity<?> create(@RequestBody Skills_SoftDto skills_softDto){
        Skills_Soft skills_soft = new Skills_Soft();
        
        skills_soft.setHabilidad(skills_softDto.getHabilidad());
        skills_soft.setPorcentaje(skills_softDto.getPorcentaje());
       
        
        
        skills_softService.save(skills_soft);
        return new ResponseEntity(new Mensaje("El Skill_Soft fue creado"), HttpStatus.OK);
    }

    //@PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Skills_SoftDto skills_softDto){
        
        Skills_Soft skills_soft = skills_softService.getOne(id).get();
        
        skills_soft.setHabilidad(skills_softDto.getHabilidad());
        skills_soft.setPorcentaje(skills_softDto.getPorcentaje());
       
        
        skills_softService.save(skills_soft);
        return new ResponseEntity(new Mensaje("Registro de Skills_Soft fue Actualizado"), HttpStatus.OK);
    }

    //@PreAuthorize ("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!skills_softService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de Skills_Soft"), HttpStatus.NOT_FOUND);
        skills_softService.delete(id);
        return new ResponseEntity(new Mensaje("Skill_Soft eliminado"), HttpStatus.OK);
    }
}        
  