
package com.tutorial.abml.repository;

import com.tutorial.abml.entity.Skills_Soft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsSoftRepository extends JpaRepository<Skills_Soft, Integer>{
    
}
