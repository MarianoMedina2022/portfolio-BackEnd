package com.Portfolio.MedinaMariano.Repository;

import com.Portfolio.MedinaMariano.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long>{
    
}
