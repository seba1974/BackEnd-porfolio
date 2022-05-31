
package com.tutorial.abml.dao;

import com.tutorial.abml.entity.UsuarioOld;
import java.util.List;


public interface LoginDao {
    
    
    List<UsuarioOld> getUsuarios();

    public void eliminar(int id);

    public void registrar(UsuarioOld usuario);
    
    boolean verificarCredenciales(UsuarioOld usuario);
    
}
