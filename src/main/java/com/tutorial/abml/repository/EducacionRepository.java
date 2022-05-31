
package com.tutorial.abml.repository;

import com.tutorial.abml.entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer> {
   
}
