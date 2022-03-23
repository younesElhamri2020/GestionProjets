package org.isi.model.webService.Provided;

import java.util.List;


import org.isi.bean.Collaborateur;
import org.isi.bean.CollaborateurCompetence;
import org.isi.model.dao.CollaborateurDAO;
import org.isi.model.service.facade.CollaborateurService;
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
@RequestMapping("GestionProjet/Collaborateur")
public class CollaborateurRest {
  
	@Autowired
	private CollaborateurService collaborateurService;
	@Autowired
	private  CollaborateurDAO collaborateurDAO;
	
	@PutMapping("/colaborateurUpdate")
	public Collaborateur update(@RequestBody Collaborateur c) {
		return collaborateurService.update(c);
	}

	@GetMapping("nom/{nom}")
	public Collaborateur findByNom(@PathVariable String nom) {
		return collaborateurService.findByNom(nom);
	}
	
	@GetMapping("prenom/{prenom}")
	public Collaborateur findByPrenom(@PathVariable String prenom) {
		return collaborateurService.findByNom(prenom);
	} 
	
	@PostMapping("/")
	public void save(@RequestBody Collaborateur c) {
		if(c==null) {
			System.out.println("null am3alam");
		}else{
			System.out.println(c.getCodeCollaborateur());
			System.out.println(c.getPrenom());
			System.out.println(c.getNom());
			
			// collaborateurService.save(c, c.getCollaborateurCompetnces());

		}
		collaborateurService.save(c, c.getCollaborateurCompetences());
	
	}
	
	@GetMapping("/")
	public List<Collaborateur> findAll(){
		return collaborateurService.findAll();
	}
	@GetMapping("codeCollaborateur/{codeCollaborateur}")
	public Collaborateur findByCodeCollaborateur(@PathVariable String codeCollaborateur) {
		return collaborateurService.findByCodeCollaborateur(codeCollaborateur);
	}
    @DeleteMapping("codeCollaborateur/{codeCollaborateur}")
	public int deleteByCodeCollaborateur(@PathVariable String codeCollaborateur) {
		return collaborateurService.deleteByCodeCollaborateur(codeCollaborateur);
	}
    @DeleteMapping("idCollaborateur/{id}")
    public void deleteById(@PathVariable Long id) {
    	collaborateurService.deleteById(id);
    }
}
