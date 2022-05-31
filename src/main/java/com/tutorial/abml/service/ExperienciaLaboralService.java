package com.tutorial.abml.service;

import com.tutorial.abml.entity.ExperienciaLaboral;
import com.tutorial.abml.repository.IExperienciaLaboralRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ExperienciaLaboralService {
    
    @Autowired
    IExperienciaLaboralRepository iexperienciaLaboralRepository;
    
    public List<ExperienciaLaboral> list(){
    return iexperienciaLaboralRepository.findAll();
    }

    
    public Optional<ExperienciaLaboral> getOne(int id){
        return iexperienciaLaboralRepository.findById(id);
    }

  

    public void  save(ExperienciaLaboral experiencialaboral){
        iexperienciaLaboralRepository.save(experiencialaboral);
    }
    
    public void delete(int id){
        iexperienciaLaboralRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return iexperienciaLaboralRepository.existsById(id);
    }

    
}
