/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.medinamariano.Service;

import com.portfolio.medinamariano.Entity.hardyskills;
import com.portfolio.medinamariano.Repository.Rhardyskills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class Shardyskills {
	@Autowired
	Rhardyskills rhardyskills;
	
	public List<hardyskills> list(){
	return rhardyskills.findAll();
	}
	
	public Optional<hardyskills> getOne(int id){
		return rhardyskills.findById(id);
	}
	
	public Optional<hardyskills> getByNombre(String nombre){
	return rhardyskills.findByNombre(nombre);
	}
	
	public void save(hardyskills skill){
		rhardyskills.save(skill);
	}
	
	public void delete(int id){
		rhardyskills.deleteById(id);
	}
	
	public boolean existsById(int id){
		return rhardyskills.existsById(id);
	}
	
	public boolean existsByNombre(String nombre){
		return rhardyskills.existsByNombre(nombre);
	}
}
