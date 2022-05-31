
package com.tutorial.abml.dao;

import com.tutorial.abml.entity.UsuarioOld;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LoginDaoImp implements LoginDao{

    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<UsuarioOld> getUsuarios() {
    String query = "FROM Usuario";
    return entityManager.createQuery(query).getResultList();
    } // El Entity Manager tiene que ejecutar la consulta Query y el resuntado lo transformamos en un result list y lo devolvemos

    @Override
    public void eliminar(int id) {
    UsuarioOld usuario = entityManager.find(UsuarioOld.class, id);
    entityManager.remove(usuario);
    }

    @Override
    public void registrar(UsuarioOld usuario) {
    entityManager.merge(usuario);
    }
    
    @Override
    public boolean verificarCredenciales(UsuarioOld usuario){
        String query = "FROM Usuario WHERE mail = '"+usuario.getMail()+"' AND password = "+usuario.getPassword()+"";
    List<UsuarioOld> lista = entityManager.createQuery(query).getResultList();
    
        return !lista.isEmpty();
    }
}
