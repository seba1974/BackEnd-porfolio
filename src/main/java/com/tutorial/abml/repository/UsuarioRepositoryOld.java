 
package com.tutorial.abml.repository;

import com.tutorial.abml.entity.UsuarioOld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositoryOld extends JpaRepository<UsuarioOld, Integer>{
    
}
