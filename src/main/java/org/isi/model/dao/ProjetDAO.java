package org.isi.model.dao;



import org.isi.bean.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetDAO extends JpaRepository<Projet, Long>{


		public Projet findByIntituleP(String intituleP);
		public int deleteByIntituleP(String intituleP);
		
		@Query(value = "SELECT SUM(a.vht) from projet p , tache t , affectation a WHERE p.id_projet=t.id_projet and t.id_tache=a.id_tache and p.id_projet=?1" , nativeQuery = true)
		public int nbheureAffecter(Long idProjet);
		
		@Query(value = "SELECT p.* from projet p , tache t , affectation a WHERE p.id_projet=t.id_projet and t.id_tache=a.id_tache and p.id_projet=?1 group by p.id_projet" , nativeQuery = true)
		public Projet findProjet(Long idProjet);
		
 
}
