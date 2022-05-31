
package com.tutorial.abml.service;

import com.tutorial.abml.entity.Proyectos;
import com.tutorial.abml.repository.IProyectosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProyectosService {
    
    @Autowired
    IProyectosRepository iproyectosRepository;
    
    public List<Proyectos> list(){        
        return iproyectosRepository.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return iproyectosRepository.findById(id);
    }

    public void  save(Proyectos proyectos){
        iproyectosRepository.save(proyectos);
    }
    
    public void delete(int id){
        iproyectosRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return iproyectosRepository.existsById(id);
    } 
    
}
