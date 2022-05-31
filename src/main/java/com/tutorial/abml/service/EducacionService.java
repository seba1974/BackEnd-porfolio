
package com.tutorial.abml.service;

import com.tutorial.abml.entity.Educacion;
import com.tutorial.abml.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducacionService {

    @Autowired
    EducacionRepository educacionRepository;

    
    public List<Educacion> list(){
        return educacionRepository.findAll();
    }

    
    public Optional<Educacion> getOne(int id){
        return educacionRepository.findById(id);
    }

  

    public void  save(Educacion educacion){
        educacionRepository.save(educacion);
    }
    
    public void delete(int id){
        educacionRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return educacionRepository.existsById(id);
    }

   
}
