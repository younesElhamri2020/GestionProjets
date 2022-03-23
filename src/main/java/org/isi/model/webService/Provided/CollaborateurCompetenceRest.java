package org.isi.model.webService.Provided;

import org.isi.bean.Collaborateur;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("GestionProjet/CollaborateurCompetence")
public class CollaborateurCompetenceRest {

	@PostMapping("/")
	 public void save(@RequestBody Collaborateur c) {
		
	 }

}
