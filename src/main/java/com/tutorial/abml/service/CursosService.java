
package com.tutorial.abml.service;

import com.tutorial.abml.entity.Cursos;
import com.tutorial.abml.repository.ICursosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CursosService {
    
    @Autowired
    ICursosRepository icursosRepository;
    
    public List<Cursos> list(){        
        return icursosRepository.findAll();
    }
    
    public Optional<Cursos> getOne(int id){
        return icursosRepository.findById(id);
    }

    public void  save(Cursos cursos){
        icursosRepository.save(cursos);
    }
    
    public void delete(int id){
        icursosRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return icursosRepository.existsById(id);
    } 
    
}
