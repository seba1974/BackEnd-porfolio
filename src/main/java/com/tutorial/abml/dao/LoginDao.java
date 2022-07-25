
package com.tutorial.abml.dao;

import com.tutorial.abml.entity.Perfil;
import java.util.List;


public interface LoginDao {
    
    
    List<Perfil> getUsuarios();

    public void eliminar(int id);

    public void registrar(Perfil usuario);
    
    boolean verificarCredenciales(Perfil usuario);
    
}
