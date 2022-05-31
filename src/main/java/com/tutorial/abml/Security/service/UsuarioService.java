
package com.tutorial.abml.Security.service;


import com.tutorial.abml.Security.entity.Usuario;
import com.tutorial.abml.Security.repository.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario); // cambio by por By
    }
    
    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);// Cambio by por By
    }
    
    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
