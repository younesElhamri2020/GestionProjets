package org.isi.model.service.Impl;


import java.util.List;


import org.isi.bean.Collaborateur;
import org.isi.bean.CollaborateurCompetence;


import org.isi.model.dao.CollaborateurDAO;
import org.isi.model.service.facade.CollaborateurCompetenceService;
import org.isi.model.service.facade.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CollaborateurServiceImpl implements CollaborateurService {
@Autowired
private  CollaborateurDAO collaborateurDAO;

@Autowired
private CollaborateurCompetenceService  collaborateurCompetenceService;




	@Override
	public Collaborateur findByNom(String nom) {
		
		return collaborateurDAO.findByNom(nom);
	}

	@Override
	public Collaborateur findByPrenom(String prenom) {
		// TODO Auto-generated method stub
		return collaborateurDAO.findByPrenom(prenom);
	}


	@Override
	@Transactional
	public void deleteById(Long id) {
		collaborateurDAO.deleteById(id);
		collaborateurCompetenceService.deleteColab(id);
	}


	

	@Override
	public Collaborateur findByCodeCollaborateur(String codeCollaborateur) {
		return collaborateurDAO.findByCodeCollaborateur(codeCollaborateur);
	}
  @Transactional
	public int deleteByCodeCollaborateur(String codeCollaborateur) {
		return collaborateurDAO.deleteByCodeCollaborateur(codeCollaborateur);
	}

@Override
public List<Collaborateur> findAll() {
	
	return collaborateurDAO.findAll();
}

@Override
@Transactional
public int save(Collaborateur collaborateur, List<CollaborateurCompetence> collaborateurCompetences) {
	Collaborateur col=findByCodeCollaborateur(collaborateur.getCodeCollaborateur());
	if(col==null) {
		 collaborateurDAO.save(collaborateur);
		
		collaborateurCompetenceService.save(collaborateur, collaborateurCompetences);
		return 1;
	}else {
		return -1;
	}
	
}

@Override
public Collaborateur update(Collaborateur c) {
	return collaborateurDAO.save(c);
}



	

	

}
