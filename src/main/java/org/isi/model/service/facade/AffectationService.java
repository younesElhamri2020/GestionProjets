package org.isi.model.service.facade;


import java.util.List;

import org.isi.bean.Affectation;
import org.isi.bean.Tache;



public interface AffectationService {

	public void save(Affectation affectation);
	public List<Affectation> findAll();
	public int affectation(Affectation af);
	public int sum(Long idProjet, Long idColab);
	public List<Affectation> findColab(Long idColab, Long idProjet);
	public int SumcollabAffectation(Long idProjet);
	 public int SumTacheHAffectation(Long idTache, Long idProjet);
	 public List<Affectation> findTach(Long idTache, Long idProjet);
	 
	 public List<Affectation> detail(Long idTach);
	 public int max(Long idTache, Long idColab);
	 public List<Affectation> TacheProjet(Long idProjet);
	 public List<Affectation>findbyIdTache(Long idTache);
	
	 
	 public List<Affectation> details(Long idTach);
	 public void deleteByTache(Tache tache);
	 public Affectation affectation(Long idTache,Long idColab);
	 public int tauxRealisationTache(String intitule);
	 
}