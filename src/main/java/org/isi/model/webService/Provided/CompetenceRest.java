package org.isi.model.webService.Provided;

import java.util.List;

import org.isi.bean.Competence;
import org.isi.model.service.facade.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("GestionProjet/Competence")
public class CompetenceRest {

	@Autowired
	private CompetenceService competenceService;
	
	@GetMapping("designation/{designation}")
	public List<Competence> findByDesignationn(@PathVariable String designation) {
		return competenceService.findByDesignationn(designation);
	}
	@GetMapping("d/{designation}")
	public Competence findByDesignation(@PathVariable String designation) {
		return competenceService.findByDesignation(designation);
	}
	@PostMapping("/")
	public void save(@RequestBody Competence competence) {
		competenceService.save(competence);
	}
	@DeleteMapping("/idCompetence/{id}")
	public void deleteById(@PathVariable Long id) {
		competenceService.deleteById(id);
	}

	
	@RequestMapping(method =RequestMethod.PUT, value ="/idCompetence/{id}")
	public void updateC(@PathVariable Long id,@RequestBody Competence c ) {
		competenceService.updateC(id,c);
	}

	@GetMapping("/")
	public List<Competence> findAll(){
		return competenceService.findAll();
	}
	
}