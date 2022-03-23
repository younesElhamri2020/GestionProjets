package org.isi.model.webService.Provided;

import java.util.List;
import java.util.Set;

import org.isi.bean.Collaborateur;
import org.isi.bean.Tache;
import org.isi.model.service.facade.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("GestionProjet/Tache")

public class TacheRest {
	@Autowired
	private TacheService tacheService;
	
	@PutMapping("update/tache/")
	public Tache update(@RequestBody Tache t) {
		return tacheService.update(t);
	}
	@GetMapping("findTache/intitule/{intitule}")
	public Tache findByIntitule(@PathVariable String intitule) {
		return tacheService.findByIntitule(intitule);
	}
	@GetMapping("/projet/intituleP/{intituleP}")
	public List<Tache> findByProjetIntituleP(@PathVariable String intituleP) {
		return tacheService.findByProjetIntituleP(intituleP);
	}
	@GetMapping("/projet/idProjet/{idProjet}")
	public List<Tache> findByIdProjet(@PathVariable Long idProjet) {
		return tacheService.findByIdProjet(idProjet);
	}
	@GetMapping("/colaborateur/idTache/{idTache}")
	public Tache find(@PathVariable Long idTache) {
		return tacheService.find(idTache);
	}
	
	@GetMapping("/colaborateur/id/{idTache}")
	public Set<Collaborateur> listC(@PathVariable Long idTache) {
		return tacheService.listC(idTache);
	}
	@GetMapping("/")
	public List<Tache> findAll() {
		return tacheService.findAll();
	}
	@DeleteMapping("/delete/idTache/{idTache}")
	public int deleteById(@PathVariable Long idTache) {
		return tacheService.deleteById(idTache);
	}

}
