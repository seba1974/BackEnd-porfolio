
package com.tutorial.abml.repository;

import com.tutorial.abml.entity.RedesSociales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRedesSocialesRepository extends JpaRepository <RedesSociales, Integer>{
    
}
