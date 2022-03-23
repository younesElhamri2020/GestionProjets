package org.isi.model.service.facade;

import java.util.List;

import org.isi.bean.Collaborateur;
import org.isi.bean.CollaborateurCompetence;



public interface CollaborateurService {
	
	public Collaborateur update(Collaborateur c);

	public Collaborateur findByNom(String nom);
	
	public Collaborateur findByPrenom(String prenom);
	
	public Collaborateur findByCodeCollaborateur(String codeCollaborateur);
	
	public int deleteByCodeCollaborateur(String codeCollaborateur);
	
	public  void deleteById(Long id);
	
	public int save(Collaborateur collaborateur, List<CollaborateurCompetence> collaborateurCompetences);
	
	public List<Collaborateur> findAll();
}