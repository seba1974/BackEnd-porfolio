
package com.tutorial.abml.service;

import com.tutorial.abml.entity.Perfil;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tutorial.abml.repository.IPerfilRepository;

@Service
@Transactional
public class PerfilService {
@Autowired
    IPerfilRepository usuarioRepository;

    
    public List<Perfil> list(){
        return usuarioRepository.findAll();
    }

   
    public Optional<Perfil> getOne(int id){
        return usuarioRepository.findById(id);
    }

    // public List<Usuario> findByEmailAddress(String emailAddress){
    //     Usuario findByEmailAddress
    //     
    //}
    
    
    
    
    
    public void  save(Perfil usuario){
        usuarioRepository.save(usuario);
    }
    
    public void delete(int id){
        usuarioRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return usuarioRepository.existsById(id);
    }

}
