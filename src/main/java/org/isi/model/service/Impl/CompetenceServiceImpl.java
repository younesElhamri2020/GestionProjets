package org.isi.model.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.isi.bean.Competence;
import org.isi.model.dao.CompetenceDAO;
import org.isi.model.service.facade.CollaborateurCompetenceService;
import org.isi.model.service.facade.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetenceServiceImpl implements CompetenceService{

	@Autowired
	private CompetenceDAO competenceDAO;
	@Autowired
	private CollaborateurCompetenceService collaborateurCompetenceService;
	@Override
	public List<Competence> findByDesignationn(String designation) {
		return competenceDAO.findByDesignationn(designation);
	}
	@Override
	public Competence findByDesignation(String designation) {
		return competenceDAO.findByDesignation(designation);
	}
	@Override
	public int save(Competence competence) {
	Competence c=findByDesignation(competence.getDesignation());
		 if(c==null) {
	   if (competence.getDesignation()!= null)
		competenceDAO.save(competence);
	   return  1;
		 }
		 else {
			 return -1;
		 }
	}
	@Override
	public List<Competence> findAll() {
		
		return competenceDAO.findAll();
	}
    @Override
    @Transactional
	public void deleteById(Long id) {
		collaborateurCompetenceService.delete(id);
		competenceDAO.deleteById(id);
	}
    @Override
    @Transactional
    public void updateC(Long id, Competence c) {
    	
    	       if(competenceDAO.findById(id)==null) {
    	    	   System.out.println("errrrrr");
    	       }
    	       else {
    	    	   for(int i=0; i<competenceDAO.findAll().size();i++) {
    	       		Competence cp=competenceDAO.findAll().get(i);
    	       		if(cp.getIdCompetence().equals(id)) {
    	       		  
    	       		cp.setDesignation(c.getDesignation());
    	       
    	       		}
    	    	 
    	       }
    	       }
    		
    	
    }

	
   
	

}