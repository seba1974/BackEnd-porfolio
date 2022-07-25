 
package com.tutorial.abml.repository;

import com.tutorial.abml.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerfilRepository extends JpaRepository<Perfil, Integer>{
    
}
