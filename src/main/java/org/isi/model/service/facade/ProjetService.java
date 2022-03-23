package org.isi.model.service.facade;

import java.util.List;

import org.isi.bean.Projet;

public interface ProjetService {

	public Projet findByIntituleP(String intituleP);
	public int deleteByIntituleP(String intituleP);
	public int save(Projet projet);
	
	public List<Projet> findAll();
	public int nbheureAffecter(Long idProjet);
	public int nbheureRester(String intituleP);
	public int tauxRealisation(String intituleP);
	public Projet findProjet(Long idProjet);
	
	
	
}