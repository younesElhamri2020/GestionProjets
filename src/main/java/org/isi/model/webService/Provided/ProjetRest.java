package org.isi.model.webService.Provided;

import java.util.List;

import org.isi.bean.Projet;
import org.isi.model.service.facade.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("GestionProjet/Projet")
public class ProjetRest {

	@Autowired
	private ProjetService projetService;
	
	@DeleteMapping("/intituleP/{intituleP}")
	public int deleteByIntituleP(@PathVariable String intituleP) {
		return projetService.deleteByIntituleP(intituleP);
	}
	@PostMapping("/")
	public int save(@RequestBody Projet projet) {
		return projetService.save(projet);
	}

	@GetMapping("/intituleP/{intituleP}")
	public Projet findByIntituleP(@PathVariable String intituleP) {
	 return  projetService.findByIntituleP(intituleP);
	}
	
	@GetMapping("/id/{idProjet}")
	public int nbheureAffecter(@PathVariable Long idProjet) {
		return projetService.nbheureAffecter(idProjet);
	}
	@GetMapping("/intitul/{intituleP}")
	public int nbheureRester(@PathVariable String intituleP) {
		return projetService.nbheureRester(intituleP);
	}
	@GetMapping("/taux/intitule/{intituleP}")
	public int tauxRealisation(@PathVariable String intituleP) {
		return projetService.tauxRealisation(intituleP);
	}
	
	@GetMapping("/")
	public List<Projet> findAll() {
		return projetService.findAll();
	}
}