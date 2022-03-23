package org.isi.model.service.facade;

import java.util.List;
import java.util.Set;

import org.isi.bean.Collaborateur;
import org.isi.bean.Projet;
import org.isi.bean.Tache;

public interface TacheService {
	
	public int deleteByProjetIntituleP(String intituleP);
	public int deleteById(Long idTache);
	public List<Tache> findByProjetIntituleP(String intituleP);
	public int save(Projet projet,List<Tache> taches);
	public List<Tache> findAll();
	public List<Tache> findByIdProjet(Long idProjet);
	public Set<Collaborateur> listC(Long idTache);
	public Tache find(Long idTache);
	public Tache findByIntitule(String intitule);
    public Tache update(Tache t);
	

}
