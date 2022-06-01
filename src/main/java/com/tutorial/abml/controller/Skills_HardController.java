
package com.tutorial.abml.controller;

import com.tutorial.abml.dto.Mensaje;
import com.tutorial.abml.dto.Skills_HardDto;
import com.tutorial.abml.entity.Skills_Hard;
import com.tutorial.abml.service.Skills_HardService;
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
@RequestMapping ("/skills_hard")
@CrossOrigin ( origins = "//localhost:4200")
// @CrossOrigin(origins = "https://frontend-sebaveloce.web.app")
public class Skills_HardController {

@Autowired
    Skills_HardService skills_hardService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills_Hard>> list(){
        List<Skills_Hard> list = skills_hardService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills_Hard> getById(@PathVariable("id") int id){
        if(!skills_hardService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        Skills_Hard skills_hard = skills_hardService.getOne(id).get();
        return new ResponseEntity(skills_hard, HttpStatus.OK);
    }

   

    //@PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/crear")
    
     public ResponseEntity<?> create(@RequestBody Skills_HardDto skills_hardDto){
        Skills_Hard skills_hard = new Skills_Hard();
        
        skills_hard.setHabilidad(skills_hardDto.getHabilidad());
        skills_hard.setPorcentaje(skills_hardDto.getPorcentaje());
       
        
        
        skills_hardService.save(skills_hard);
        return new ResponseEntity(new Mensaje("El idioma fue creado"), HttpStatus.OK);
    }

    //@PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Skills_HardDto skills_hardDto){
        
        Skills_Hard skills_hard = skills_hardService.getOne(id).get();
        
        skills_hard.setHabilidad(skills_hardDto.getHabilidad());
        skills_hard.setPorcentaje(skills_hardDto.getPorcentaje());
       
        
        skills_hardService.save(skills_hard);
        return new ResponseEntity(new Mensaje("Registro de Skills_Hard fue Actualizado"), HttpStatus.OK);
    }

    //@PreAuthorize ("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!skills_hardService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de Skills_Hard"), HttpStatus.NOT_FOUND);
        skills_hardService.delete(id);
        return new ResponseEntity(new Mensaje("Skill_Hard eliminado"), HttpStatus.OK);
    }        
    
}
