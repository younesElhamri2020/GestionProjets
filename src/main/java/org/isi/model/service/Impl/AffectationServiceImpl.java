package org.isi.model.service.Impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.isi.bean.Affectation;
import org.isi.bean.Collaborateur;
import org.isi.bean.Projet;
import org.isi.bean.Tache;
import org.isi.model.dao.AffectationDAO;
import org.isi.model.service.facade.AffectationService;
import org.isi.model.service.facade.CollaborateurService;
import org.isi.model.service.facade.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffectationServiceImpl implements AffectationService{

	@Autowired
	private AffectationDAO affectationDAO;
	@Autowired
	private TacheService tacheService;
	@Autowired
	private CollaborateurService collaborateurService;
	@Override
	public void save(Affectation affectation) {
		Affectation f= new Affectation();
		Tache t= tacheService.find(affectation.getTache().getIdTache());
		Collaborateur colab =collaborateurService.findByCodeCollaborateur(affectation.getCollaborateur().getCodeCollaborateur());
		f.setTache(t);
		f.setCollaborateur(colab);
		f.setVhT(affectation.getVhT());
		affectationDAO.save(f);
	}

	@Override
	public List<Affectation> findAll() {
		return affectationDAO.findAll();
	}
	@Override
	public int sum(Long idProjet, Long idColab) {
		return affectationDAO.sum(idProjet, idColab);
	}
	@Override
	public List<Affectation> findColab(Long idColab, Long idProjet){
		return affectationDAO.findColab(idColab,idProjet); 
	}
	@Override
	public int SumcollabAffectation(Long idProjet) {
		return affectationDAO.SumcollabAffectation(idProjet);
	}
	@Override
	 public int SumTacheHAffectation(Long idTache, Long idProjet) {
		return affectationDAO.SumTacheHAffectation(idTache, idProjet);
	 }
	@Override
	public List<Affectation> findTach(Long idTache, Long idProjet){
		return affectationDAO.findTach(idTache, idProjet);
	}
	@Override
	public Affectation affectation(Long idTache,Long idColab) {
		return affectationDAO.affectation(idTache, idColab);
	}
	@Override
	public List<Affectation>findbyIdTache(Long idTache){
		return affectationDAO.findbyIdTache(idTache);
	}
	@Override
	public int affectation(Affectation af) {
		Tache t =tacheService.find(af.getTache().getIdTache());
		Projet p =t.getProjet();
		int vhp=p.getVhProjet();
		int nbc=p.getNbrCollaborateur();
		int moy=vhp/nbc;
		int nbrHT=0;
		int nbrHTT=0;
		int nbRest=0;
		int SumColAff = SumcollabAffectation(p.getIdProjet());
		
		if(SumColAff<p.getNbrCollaborateur()) {
		    Collaborateur colab =collaborateurService.findByCodeCollaborateur(af.getCollaborateur().getCodeCollaborateur());
		    List<Affectation> l= findColab(colab.getIdCollaborateur(),p.getIdProjet());

		    if(l.size()!=0) {
			  nbrHT = sum(p.getIdProjet(), colab.getIdCollaborateur());

			  if(nbrHT>0) {

				if(moy>= nbrHT + af.getVhT()  ) {
					List<Affectation> lt=findTach(t.getIdTache(),p.getIdProjet());
					if(lt.size()!=0) {
						Affectation affect=affectation(t.getIdTache(), colab.getIdCollaborateur());
						if(affect==null) {
							nbrHTT=SumTacheHAffectation(t.getIdTache(),p.getIdProjet());
							nbRest=t.getVhTache()-nbrHTT;
							if(nbRest>=af.getVhT()) {
								save(af);
								return 1;
							}
							else {
								return 2;
							}
						}else {
							System.out.println("pas save");
						}
						
					}else {
						if(t.getVhTache()>=af.getVhT()) {
							save(af);
							return 1;
						}
						else {
							return -2;
						}
					}	
				}
				else {
					return 3;
				}
			}
		 }else { 
			if(moy>= af.getVhT()) {
				List<Affectation> lt=findTach(t.getIdTache(),p.getIdProjet());
				if(lt.size()!=0) {
					nbrHTT=SumTacheHAffectation(t.getIdTache(),p.getIdProjet());
					nbRest=t.getVhTache()-nbrHTT;
					if(nbRest>=af.getVhT()) {
						save(af);
						return 1;
					}
					else {
						return 2;
					}
				}else {
					if(t.getVhTache()>=af.getVhT()) {
						save(af);
						return 1;
					}
					else {
						return -2;
					}
				}
		     }
			else {
				return 3;
			}
	     }
		    return 0;
	   
	  }
	  else{
		return -1;
	  }
	}
	@Override
	public List<Affectation> detail(Long idTach){
		return affectationDAO.detail(idTach);
	}
	@Override
	public int max(Long idTache, Long idColab) {
		return affectationDAO.max(idTache, idColab);
	}
	@Override
	public List<Affectation> details(Long idTach){
		List b =new ArrayList<>();
		List a =  affectationDAO.details(idTach);
		for(int i = 0 ; i < a.size(); i++) {
			b.add(a);
		}
		return affectationDAO.details(idTach);
	}
	@Override
	public List<Affectation> TacheProjet(Long idProjet){
		return affectationDAO.TacheProjet(idProjet);
	}
	@Override
	 public void deleteByTache(Tache tache) {
		affectationDAO.deleteByTache(tache);
	}
	@Override
	 public int tauxRealisationTache(String intitule){
		Tache tache=tacheService.findByIntitule(intitule);
		int a =tache.getVhTache();
		int b =SumTacheHAffectation(tache.getIdTache(),tache.getProjet().getIdProjet());
		int c=(b*100)/a;
		return c;
	}
}