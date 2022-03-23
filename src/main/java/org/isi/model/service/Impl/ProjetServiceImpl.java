package org.isi.model.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.isi.bean.Projet;
import org.isi.bean.Tache;
import org.isi.model.dao.ProjetDAO;
import org.isi.model.service.facade.ProjetService;
import org.isi.model.service.facade.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetServiceImpl implements ProjetService{

	@Autowired
	private ProjetDAO projetDAO; 
	
	@Autowired
	private TacheService tacheService;
	@Override
	public Projet findByIntituleP(String intituleP) {
		return projetDAO.findByIntituleP(intituleP);
	}

	

	@Override
	public List<Projet> findAll() {
		// TODO Auto-generated method stub
		return projetDAO.findAll();
	}


	@Override
	@Transactional
	public int deleteByIntituleP(String intituleP) {
		Projet p =findByIntituleP(intituleP);
		if(p==null) {
			return -1;
		}
		else {
		List<Tache> taches=p.getTaches();
		if(taches.size()==0) {
			System.out.println("vide");
		}else {
			for(Tache t:taches) {
				tacheService.deleteById(t.getIdTache());
			}
		}
	projetDAO.deleteByIntituleP(intituleP);
		return 1;
		}
	}
	



	@Override
	@Transactional
	public int save(Projet projet) {
		Projet existenceProjet = findByIntituleP(projet.getIntituleP());
		if (existenceProjet != null) {
			return -1;}
			else {
				CalculVhp(projet,projet.getTaches());
				projetDAO.save(projet);
				if(projet.getTaches().size()==0)
				System.out.println("vide");
				else {
					tacheService.save(projet, projet.getTaches());	
				}
			return 1;
		}
	}


    
	private void CalculVhp(Projet projet, List<Tache> taches) {
		int vhProjet=0;
		for(Tache tache: taches) {
			vhProjet+=tache.getVhTache();
		}
		projet.setVhProjet(vhProjet);
	}
	@Override
	public Projet findProjet(Long idProjet) {
		return projetDAO.findProjet(idProjet);
	}
	@Override
	public int nbheureAffecter(Long idProjet) {
		Projet p=findProjet(idProjet);
		if(p==null) {
			return 0;
		}else {
			int a=0;
			int b =projetDAO.nbheureAffecter(idProjet);
			return a+b;
		}
		
	}
	@Override
	public int nbheureRester(String intituleP) {
		Projet p =findByIntituleP(intituleP);
		int a =p.getVhProjet();
		int b =nbheureAffecter(p.getIdProjet());
		return a-b;
	}
	@Override
	public int tauxRealisation(String intituleP) {
		Projet p =findByIntituleP(intituleP);
		int a =p.getVhProjet();
		int b =nbheureAffecter(p.getIdProjet());
		int c=(b*100)/a;
		return c;
	}
	



	

}