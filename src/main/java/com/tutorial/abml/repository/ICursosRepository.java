
package com.tutorial.abml.repository;

import com.tutorial.abml.entity.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursosRepository extends JpaRepository<Cursos, Integer>{
    
}
