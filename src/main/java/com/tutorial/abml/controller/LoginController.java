
package com.tutorial.abml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tutorial.abml.dao.LoginDao;
import com.tutorial.abml.entity.UsuarioOld;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping (value = "/api")
@CrossOrigin ( origins = "//localhost:4200")
// @CrossOrigin(origins = "http://https://frontend-sebaveloce.web.app")
public class LoginController {
    
    @Autowired
    private LoginDao loginDao;
       
       
    // Listar Usuarios de Login **OK**
    @RequestMapping (value = "/login/listar", method = RequestMethod.GET)
    public List<UsuarioOld> getUsuarios() {
       return loginDao.getUsuarios();
    }
    
    
    // Crear Usuarios de Login **OK**
    @RequestMapping (value = "/login/crear", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody UsuarioOld usuario) {
       loginDao.registrar(usuario);
    }
    
    // Borrar un Usuario de Login **OK**
    @RequestMapping (value = "/login/borrar/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable int id) {
        loginDao.eliminar(id);
    }
}
 