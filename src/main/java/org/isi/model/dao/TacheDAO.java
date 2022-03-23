package org.isi.model.dao;
import java.util.List;

import org.isi.bean.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheDAO extends JpaRepository<Tache, Long>{

	//**** les requetes GRUD**********
	
	public int deleteByProjetIntituleP(String intituleP);
	public List<Tache> findByProjetIntituleP(String intituleP);
	public Tache findByIntitule(String intitule);
	

	
    //**** les requetes native**********
	@Query(value="SELECT * FROM tache  WHERE tache.id_tache  =?1", nativeQuery = true)
	public Tache find(Long idTache);
	@Query(value="SELECT * FROM tache  WHERE tache.id_projet  =?1", nativeQuery = true)
	public List<Tache> findByIdProjet(Long idProjet);
	
    //**** les requetes JPAQL ********
}