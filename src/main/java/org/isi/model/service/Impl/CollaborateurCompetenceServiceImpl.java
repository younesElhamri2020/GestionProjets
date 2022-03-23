package org.isi.model.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.isi.bean.Collaborateur;
import org.isi.bean.CollaborateurCompetence;
import org.isi.bean.Competence;
import org.isi.model.dao.CollaborateurCompetenceDAO;
import org.isi.model.dao.CompetenceDAO;
import org.isi.model.service.facade.CollaborateurCompetenceService;
import org.isi.model.service.facade.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaborateurCompetenceServiceImpl implements CollaborateurCompetenceService{
 
	@Autowired
	private CompetenceService competenceService;
	@Autowired
	private CollaborateurCompetenceDAO collaborateurCompetenceDAO;
	
	@Override
	public void update(Collaborateur C, List<CollaborateurCompetence> cc) {
		this.save(C,cc);
	}
	@Override
	@Transactional
	public int save(Collaborateur collaborateur, List<CollaborateurCompetence> collaborateurCompetences) {
		List<Competence> list=new ArrayList<Competence>();	
		if(collaborateurCompetences.isEmpty()) {
		      return 0;	
		}
		else{
		    collaborateurCompetences.forEach(e->{
			Competence competence=competenceService.findByDesignation(e.getCompetence().getDesignation());
			e.setCollaborateur(collaborateur);
			
			e.setCompetence(competence);
			e.setNiveau("débutant");
			collaborateurCompetenceDAO.save(e);
			
		});
		
		
		return 1;
	}}

	@Override
	@Transactional
	public List<CollaborateurCompetence> find(Long c) {
		
		return collaborateurCompetenceDAO.find(c);

	}

	
	@Override
	@Transactional
	public List<CollaborateurCompetence> findColab(Long c) {
		return collaborateurCompetenceDAO.findColab(c);
	}
	@Override
	@Transactional
	public void delete(Long c) {
		List<CollaborateurCompetence> cc=collaborateurCompetenceDAO.find(c);
		if(cc==null) {
			System.out.println("vide");
		}else {
			for(CollaborateurCompetence a:cc) {
				if(cc!=null) {
					collaborateurCompetenceDAO.delete(a.getId());
				
				}
			}	
		}
		
	}

	@Override
	@Transactional
	public void deleteColab(Long c) {
		System.out.println(c);
		List<CollaborateurCompetence> cc=collaborateurCompetenceDAO.findColab(c);
		if(cc==null) {
			System.out.println("vide");
		}else {
			for(CollaborateurCompetence a:cc) {
				if(cc!=null) {
					collaborateurCompetenceDAO.delete(a.getId());
				
				}
			}	
		}
		
	}
	


}
