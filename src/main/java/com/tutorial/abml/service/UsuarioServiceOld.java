
package com.tutorial.abml.service;

import com.tutorial.abml.entity.UsuarioOld;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tutorial.abml.repository.UsuarioRepositoryOld;

@Service
@Transactional
public class UsuarioServiceOld {
@Autowired
    UsuarioRepositoryOld usuarioRepository;

    
    public List<UsuarioOld> list(){
        return usuarioRepository.findAll();
    }

   
    public Optional<UsuarioOld> getOne(int id){
        return usuarioRepository.findById(id);
    }

    // public List<Usuario> findByEmailAddress(String emailAddress){
    //     Usuario findByEmailAddress
    //     
    //}
    
    
    
    
    
    public void  save(UsuarioOld usuario){
        usuarioRepository.save(usuario);
    }
    
    public void delete(int id){
        usuarioRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return usuarioRepository.existsById(id);
    }

}
