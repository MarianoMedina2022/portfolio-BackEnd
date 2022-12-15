/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.medinamariano.Repository;

import com.portfolio.medinamariano.Entity.hardyskills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author maria
 */
public interface Rhardyskills extends JpaRepository<hardyskills, Integer>{
	Optional<hardyskills> findByNombre(String nombre);
	public boolean existsByNombre(String nombre);
	
}
