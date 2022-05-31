
package com.tutorial.abml.service;

import com.tutorial.abml.entity.RedesSociales;
import com.tutorial.abml.repository.IRedesSocialesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RedesSocialesService {
    
    @Autowired
    IRedesSocialesRepository iredesSocialesRepository;
    
    public List<RedesSociales> list(){        
        return iredesSocialesRepository.findAll();
    }
    
    public Optional<RedesSociales> getOne(int id){
        return iredesSocialesRepository.findById(id);
    }

    public void  save(RedesSociales redessociales){
        iredesSocialesRepository.save(redessociales);
    }
    
    public void delete(int id){
        iredesSocialesRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return iredesSocialesRepository.existsById(id);
    }
    
}
