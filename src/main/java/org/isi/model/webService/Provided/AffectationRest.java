package org.isi.model.webService.Provided;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.isi.bean.Affectation;
import org.isi.bean.Collaborateur;
import org.isi.bean.Tache;
import org.isi.model.service.facade.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("GestionProjet/Affectation")
public class AffectationRest {

	@Autowired
	private AffectationService affectationService;
	
	@GetMapping("tauxTache/intitule/{intitule}")
	public int tauxRealisationTache(@PathVariable String intitule) {
		return affectationService.tauxRealisationTache(intitule);
	}
	@GetMapping("sumHeure/idt/{idTache}/idp/{idProjet}")
	public int SumTacheHAffectation(@PathVariable Long idTache,@PathVariable Long idProjet) {
		return affectationService.SumTacheHAffectation(idTache, idProjet);
	}
	@PostMapping("/")
	public void save(@RequestBody Affectation affectation) {
		affectationService.save(affectation);
	}

	@GetMapping("/")
	public List<Affectation> findAll() {
		return affectationService.findAll();
	}
	@PostMapping("/affectation/")
	 public int affectation(@RequestBody Affectation  t ) {
		 return affectationService.affectation(t);
	}
	@GetMapping("/projet/{idProjet}/colab/{idColab}")
	public int sum(@PathVariable Long idProjet,@PathVariable Long idColab) {
		return affectationService.sum(idProjet, idColab);
	}
	@GetMapping("/id/{idColab}/idP/{idProjet}")
	public List<Affectation> findColab(@PathVariable Long idColab,@PathVariable Long idProjet) {
		return affectationService.findColab(idColab,idProjet);
	}
	@GetMapping("/detailAffectationTache/idTache/{idTach}")
	public List<Affectation> detail(@PathVariable Long idTach){
		return affectationService.detail(idTach);
	}
	@GetMapping("/max/idTache/{idTache}/idCollaborateur/{idColab}")
	public int max(@PathVariable Long idTache,@PathVariable Long idColab) {
		return affectationService.max(idTache, idColab);
	}
	@GetMapping("/details/idTache/{idTache}")
	 public List<Affectation> details(@PathVariable Long idTache){
		return affectationService.details(idTache);
	}
    @GetMapping("listeTache/idProjet/{idProjet}")
	public List<Affectation> TacheProjet(@PathVariable Long idProjet) {
		return affectationService.TacheProjet(idProjet);
	}
	
}