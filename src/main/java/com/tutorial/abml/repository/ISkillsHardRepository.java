
package com.tutorial.abml.repository;

import com.tutorial.abml.entity.Skills_Hard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsHardRepository extends JpaRepository<Skills_Hard, Integer>{
    
}
