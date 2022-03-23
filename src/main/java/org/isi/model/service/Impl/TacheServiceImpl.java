package org.isi.model.service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.isi.bean.Affectation;
import org.isi.bean.Collaborateur;
import org.isi.bean.CollaborateurCompetence;
import org.isi.bean.Competence;
import org.isi.bean.Projet;
import org.isi.bean.Tache;
import org.isi.model.dao.TacheDAO;
import org.isi.model.service.facade.AffectationService;
import org.isi.model.service.facade.CollaborateurService;
import org.isi.model.service.facade.CompetenceService;
import org.isi.model.service.facade.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TacheServiceImpl implements TacheService {
@Autowired
private TacheDAO tacheDAO;
@Autowired
private CompetenceService competenceService;

@Autowired
private CollaborateurService colabService;
@Autowired
private AffectationService affectationService;
@Override
public Tache update(Tache t) {
	return tacheDAO.save(t);
}
@Override
public int deleteByProjetIntituleP(String intituleP) {
	// TODO Auto-generated method stub
	return tacheDAO.deleteByProjetIntituleP(intituleP);
}
@Override
@Transactional
public int deleteById(Long idTache) {
	affectationService.deleteByTache(tacheDAO.find(idTache));
		 tacheDAO.deleteById(idTache);
		 return 1;
}

@Override
public List<Tache> findByProjetIntituleP(String intituleP) {
	// TODO Auto-generated method stub
	return tacheDAO.findByProjetIntituleP(intituleP);
}
@Override
public List<Tache> findByIdProjet(Long idProjet) {
	// TODO Auto-generated method stub
	return tacheDAO.findByIdProjet(idProjet);
}
@Override
public Tache find(Long idTache) {
	return tacheDAO.find(idTache);
}

@Override
public Set<Collaborateur> listC(Long idTache){
	int i=0;
	int ii=0;
	Set<Collaborateur> finale= new HashSet<Collaborateur>();
	Set<Collaborateur> finalee= new HashSet<Collaborateur>();
	Tache t =find(idTache);
	List<Competence> tc= t.getCompetences();
	List<Collaborateur> colab =colabService.findAll();
	for(Competence cp:tc) {
		Long a = cp.getIdCompetence();
		for(Collaborateur cl:colab) {
			List<CollaborateurCompetence> compColab= cl.getCollaborateurCompetences();
			for(CollaborateurCompetence pp:compColab) {
				Competence competencee = pp.getCompetence();
				long b=competencee.getIdCompetence();
				if(b==a) {
				i=i+1;
				}
			}
			if(i>0) {
				finale.add(cl);
				i=0;
				List<Affectation> affec =affectationService.findbyIdTache(idTache);
				if(affec.size()!=0) {
					for(Collaborateur cll:finale) {
						for(Affectation affect:affec) {
							Affectation affecta=affectationService.affectation(affect.getTache().getIdTache(), cll.getIdCollaborateur());
							if(affecta==null) {
								ii=ii+1;
							}
							else {
								System.out.println("deja affecter");
							}
						}
						if(ii>0) {
							finalee.add(cll);
							ii=0;
						}
					}
				}else {
					finalee=finale;
				}
				
				
				
			}
			
		}
	}
	return finalee;
}
@Override
@Transactional
public int save(Projet projet, List<Tache> taches) {
	
	if (taches.size()==0) {
		return -1;
	}
		
	else {
     for (Tache tache: taches) {
    	 List<Competence> cp=tache.getCompetences();
    	 List<Competence> list=new ArrayList<Competence>();
    	 for(Competence cc:cp) {
    		
    		 Competence comp=competenceService.findByDesignation(cc.getDesignation());
    		 Competence compt= new Competence();
    		 compt.setIdCompetence(comp.getIdCompetence());
    		 compt.setDesignation(comp.getDesignation());
    		 list.add(compt);
    		
    	 }
    	 tache.setCompetences(list);
         tache.setProjet(projet);
    	 tacheDAO.save(tache);
     }
	return 1;
	}
}

@Override
public List<Tache> findAll() {
	
	return tacheDAO.findAll();
}
@Override
public Tache findByIntitule(String intitule) {
	return tacheDAO.findByIntitule(intitule);
}
	



}
