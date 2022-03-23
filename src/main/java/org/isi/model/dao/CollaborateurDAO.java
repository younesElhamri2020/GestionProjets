package org.isi.model.dao;
import java.util.List;

import org.isi.bean.Collaborateur;
import org.isi.bean.CollaborateurCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaborateurDAO extends JpaRepository<Collaborateur, Long>{

	
  //**** les requetes GRUD*********

	 public Collaborateur findByCodeCollaborateur(String codeCollaborateur);
    public Collaborateur findByNom(String nom);
    public Collaborateur findByPrenom(String prenom);
   

	//La suppression:
	
    public int deleteByCodeCollaborateur(String codeCollaborateur);
  //**** les requetes native**********
	
	
  //**** les requetes JPAQL ********
 
}