
package com.tutorial.abml.repository;

import com.tutorial.abml.entity.ExperienciaLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Integer>{
//    Optional<ExperienciaLaboral> findByNombre(String nombre);
//    boolean existsByNombre (String nombre);
    
}
