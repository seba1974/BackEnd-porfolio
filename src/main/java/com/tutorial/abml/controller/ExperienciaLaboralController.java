
package com.tutorial.abml.controller;

import com.tutorial.abml.dto.ExperienciaLaboralDto;
import com.tutorial.abml.dto.Mensaje;
import com.tutorial.abml.entity.ExperienciaLaboral;
import com.tutorial.abml.service.ExperienciaLaboralService;
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
@RequestMapping("/experiencialaboral")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaLaboralController {
    
    @Autowired
    ExperienciaLaboralService experienciaLaboralService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaLaboral>> list(){
        List<ExperienciaLaboral> list = experienciaLaboralService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id") int id){
        if(!experienciaLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        ExperienciaLaboral experiencialaboral = experienciaLaboralService.getOne(id).get();
        return new ResponseEntity(experiencialaboral, HttpStatus.OK);
    }

   

    //@PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/crear")
     // public ResponseEntity<?> create(@PathVariable("id")int id, @RequestBody ExperienciaLaboralDto experienciaLaboralDto){    
     //   ExperienciaLaboral experiencialaboral = experienciaLaboralService.getOne(id).get();
                
        public ResponseEntity<?> create(@RequestBody ExperienciaLaboralDto experienciaLaboralDto){
        ExperienciaLaboral experiencialaboral = new ExperienciaLaboral();
        experiencialaboral.setEmpresa(experienciaLaboralDto.getEmpresa());
        experiencialaboral.setPuesto(experienciaLaboralDto.getPuesto());
        experiencialaboral.setUbic_empresa(experienciaLaboralDto.getUbic_empresa());
        experiencialaboral.setArea_cobertura(experienciaLaboralDto.getArea_cobertura());
        experiencialaboral.setImg_logo(experienciaLaboralDto.getImg_logo());
        experiencialaboral.setFecha_ingreso(experienciaLaboralDto.getFecha_ingreso());
        experiencialaboral.setFecha_egreso(experienciaLaboralDto.getFecha_egreso());        
        experiencialaboral.setDescripcion(experienciaLaboralDto.getDescripcion());
        
        experienciaLaboralService.save(experiencialaboral);
        return new ResponseEntity(new Mensaje("Experiencia Laboral creada"), HttpStatus.OK);
    }

    //@PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ExperienciaLaboralDto experienciaLaboralDto){
        ExperienciaLaboral experiencialaboral = experienciaLaboralService.getOne(id).get();
        experiencialaboral.setEmpresa(experienciaLaboralDto.getEmpresa());
        experiencialaboral.setPuesto(experienciaLaboralDto.getPuesto());
        experiencialaboral.setUbic_empresa(experienciaLaboralDto.getUbic_empresa());
        experiencialaboral.setArea_cobertura(experienciaLaboralDto.getArea_cobertura());
        experiencialaboral.setImg_logo(experienciaLaboralDto.getImg_logo());
        experiencialaboral.setFecha_ingreso(experienciaLaboralDto.getFecha_ingreso());
        experiencialaboral.setFecha_egreso(experienciaLaboralDto.getFecha_egreso());        
        experiencialaboral.setDescripcion(experienciaLaboralDto.getDescripcion());
        
        experienciaLaboralService.save(experiencialaboral);
        return new ResponseEntity(new Mensaje("Registro de Experiencia Laboral Actualizado"), HttpStatus.OK);
    }

    //@PreAuthorize ("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!experienciaLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de experienica Laboral"), HttpStatus.NOT_FOUND);
        experienciaLaboralService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia Laboral eliminada"), HttpStatus.OK);
    }
    
}
