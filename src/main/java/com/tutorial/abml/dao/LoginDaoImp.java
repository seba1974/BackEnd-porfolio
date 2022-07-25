
package com.tutorial.abml.dao;

import com.tutorial.abml.entity.Perfil;
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
    public List<Perfil> getUsuarios() {
    String query = "FROM Usuario";
    return entityManager.createQuery(query).getResultList();
    } // El Entity Manager tiene que ejecutar la consulta Query y el resuntado lo transformamos en un result list y lo devolvemos

    @Override
    public void eliminar(int id) {
    Perfil usuario = entityManager.find(Perfil.class, id);
    entityManager.remove(usuario);
    }

    @Override
    public void registrar(Perfil usuario) {
    entityManager.merge(usuario);
    }
    
    @Override
    public boolean verificarCredenciales(Perfil usuario){
        String query = "FROM Usuario WHERE mail = '"+usuario.getMail()+"' AND password = "+usuario.getPassword()+"";
    List<Perfil> lista = entityManager.createQuery(query).getResultList();
    
        return !lista.isEmpty();
    }
}
