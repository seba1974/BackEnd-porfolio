package com.tutorial.abml.service;

import com.tutorial.abml.entity.Idiomas;
import com.tutorial.abml.repository.IIdiomasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IdiomasService {
    
    @Autowired
    IIdiomasRepository iIdiomasRepository;
    
    public List<Idiomas> list(){        
        return iIdiomasRepository.findAll();
    }
    
    public Optional<Idiomas> getOne(int id){
        return iIdiomasRepository.findById(id);
    }

    public void  save(Idiomas idiomas){
        iIdiomasRepository.save(idiomas);
    }
    
    public void delete(int id){
        iIdiomasRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return iIdiomasRepository.existsById(id);
    }
}
