
package com.tutorial.abml.Security.repository;

import com.tutorial.abml.Security.entity.Rol;
import com.tutorial.abml.Security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre (RolNombre rolNombre);    
}
