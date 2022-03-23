package org.isi.model.dao;


import java.util.List;


import org.isi.bean.Collaborateur;

import org.isi.bean.CollaborateurCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface CollaborateurCompetenceDAO extends JpaRepository<CollaborateurCompetence, Long>{

	@Modifying
	@Query(value="delete from collaborateur_competence where collaborateur_competence.id = ?1", nativeQuery = true)
	public void delete(Long c);
	@Query(value="SELECT * FROM collaborateur_competence  WHERE collaborateur_competence.id_competence  =?1", nativeQuery = true)
	public List<CollaborateurCompetence> find(Long c);
	@Query(value="SELECT * FROM collaborateur_competence  WHERE collaborateur_competence.id_collaborateur  =?1", nativeQuery = true)
	public List<CollaborateurCompetence> findColab(Long c);
}
