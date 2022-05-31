
package com.tutorial.abml.repository;

import com.tutorial.abml.entity.Idiomas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIdiomasRepository extends JpaRepository<Idiomas, Integer>{
    
}
