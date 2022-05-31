
package com.tutorial.abml.Security.repository;


import com.tutorial.abml.Security.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario , Integer>{
    Optional<Usuario> findByNombreUsuario (String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario); // cambio de by por By
    boolean existsByEmail(String email); // cambio de by por By

}
