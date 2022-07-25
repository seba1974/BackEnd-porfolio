
package com.tutorial.abml.controller;

import com.tutorial.abml.dao.LoginDao;
import com.tutorial.abml.entity.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin ( origins = "//localhost:4200")
// @CrossOrigin(origins = "https://frontend-sebaveloce.web.app")
@RequestMapping ("/login")
public class AuthControllerOld {
    
    @Autowired
    private LoginDao loginDao;
  
    @RequestMapping (value = "/validar", method = RequestMethod.POST)
    public String login(@RequestBody Perfil usuario) {
      if(loginDao.verificarCredenciales(usuario)){
        return "OK";
      }
        return "FAIL";
    }
    
}
