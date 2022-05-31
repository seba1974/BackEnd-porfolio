
package com.tutorial.abml.service;

import com.tutorial.abml.entity.Skills_Hard;
import com.tutorial.abml.repository.ISkillsHardRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Skills_HardService {
    
    @Autowired
    ISkillsHardRepository iskillsHardRepository;
    
    public List<Skills_Hard> list(){
        return iskillsHardRepository.findAll();
    }
    
    public Optional<Skills_Hard> getOne(int id){
        return iskillsHardRepository.findById(id);
    }
    
    public void save(Skills_Hard skills_hard){
        iskillsHardRepository.save(skills_hard);
    }
    
    public void delete (int id){
        iskillsHardRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iskillsHardRepository.existsById(id);
    }
    
    
}
