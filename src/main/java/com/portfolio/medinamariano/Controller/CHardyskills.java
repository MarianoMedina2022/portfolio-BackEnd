/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.medinamariano.Controller;

import com.portfolio.medinamariano.Dto.dtoHardyskills;
import com.portfolio.medinamariano.Entity.hardyskills;
import com.portfolio.medinamariano.Security.Controller.Mensaje;
import com.portfolio.medinamariano.Service.Shardyskills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author maria
 */
@RestController
@RequestMapping("/skills")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"https://frontendmedinamariano.web.app","http://localhost:4200"})
public class CHardyskills {

	@Autowired
	Shardyskills shardyskills;

	@GetMapping("/lista")
	public ResponseEntity<List<hardyskills>> list() {
		List<hardyskills> list = shardyskills.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<hardyskills> getById(@PathVariable("id") int id) {
		if (!shardyskills.existsById(id)) {
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		}
		hardyskills hardYskills = shardyskills.getOne(id).get();
		return new ResponseEntity(hardYskills, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!shardyskills.existsById(id)) {
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		}
		shardyskills.delete(id);
		return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody dtoHardyskills dtohardyskills) {
		if (StringUtils.isBlank(dtohardyskills.getNombre())) {
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		}
		if (shardyskills.existsByNombre(dtohardyskills.getNombre())) {
			return new ResponseEntity(new Mensaje("Esa skill existe"), HttpStatus.BAD_REQUEST);
		}

		hardyskills hardYskills = new hardyskills(dtohardyskills.getNombre(), dtohardyskills.getPorcentaje());
		shardyskills.save(hardYskills);

		return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHardyskills dtohardyskills) {
		//Validamos si existe el ID
		if (!shardyskills.existsById(id)) {
			return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
		}
		//Compara nombre de skills
		if (shardyskills.existsByNombre(dtohardyskills.getNombre()) && shardyskills.getByNombre(dtohardyskills.getNombre()).get().getId() != id) {
			return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
		}
		//No puede estar vacio
		if (StringUtils.isBlank(dtohardyskills.getNombre())) {
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		}

		hardyskills hardYskills = shardyskills.getOne(id).get();
		hardYskills.setNombre(dtohardyskills.getNombre());
		hardYskills.setPorcentaje((dtohardyskills.getPorcentaje()));

		shardyskills.save(hardYskills);
		return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

	}
}
