
package com.tutorial.abml.service;

import com.tutorial.abml.entity.Skills_Soft;
import com.tutorial.abml.repository.ISkillsSoftRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class Skills_SoftService {
    
    @Autowired
            ISkillsSoftRepository iskillsSoftRepository;
    
    public List<Skills_Soft> list(){
    return iskillsSoftRepository.findAll();
    }

    
    public Optional<Skills_Soft> getOne(int id){
        return iskillsSoftRepository.findById(id);
    }

  

    public void  save(Skills_Soft skills_soft){
        iskillsSoftRepository.save(skills_soft);
    }
    
    public void delete(int id){
        iskillsSoftRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return iskillsSoftRepository.existsById(id);
    }
    
}
