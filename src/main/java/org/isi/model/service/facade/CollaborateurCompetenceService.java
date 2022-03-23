package org.isi.model.service.facade;

import java.util.List;


import org.isi.bean.Collaborateur;
import org.isi.bean.CollaborateurCompetence;

public interface CollaborateurCompetenceService {

 public int save(Collaborateur collaborateur, List<CollaborateurCompetence> collaborateurCompetences);
 public void delete(Long c);
	

	public List<CollaborateurCompetence> find(Long c);
	public List<CollaborateurCompetence> findColab(Long c);
	public void deleteColab(Long c);
	public void update(Collaborateur C, List<CollaborateurCompetence> cc);
}
