package org.isi.model.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.isi.bean.Affectation;
import org.isi.bean.Collaborateur;
import org.isi.bean.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface AffectationDAO extends JpaRepository<Affectation, Long>{

	@Query(value="SELECT sum(a.vht) FROM projet p,tache t , affectation a WHERE p.id_projet = t.id_projet  AND t.id_tache=a.id_tache AND  p.id_projet=?1 AND a.id_collaborateur=?2 " , nativeQuery = true)
	public int sum(Long idProjet, Long idColab);
	
	@Query(value = "SELECT a.id , a.id_tache, a.id_collaborateur , a.vht FROM affectation a , projet p, tache t WHERE p.id_projet = t.id_projet AND  t.id_tache = a.id_tache AND  a.id_collaborateur=?1 AND p.id_projet=?2", nativeQuery = true)
	public List<Affectation> findColab(Long idColab, Long idProjet);
	
	@Query(value="select count(DISTINCT a.id_collaborateur) as  sumcollabAffectation from projet p,affectation a,tache t WHERE p.id_projet = t.id_projet and  t.id_tache = a.id_tache and p.id_projet=?1 " , nativeQuery = true) 
    public int SumcollabAffectation(Long idProjet);
	
	
	@Query(value="select SUM(a.vht) from projet p,affectation a,tache t WHERE p.id_projet = t.id_projet and  t.id_tache = a.id_tache and   t.id_tache=?1 and p.id_projet=?2" , nativeQuery = true) 
    public int SumTacheHAffectation(Long idTache, Long idProjet);
	
	@Query(value = "SELECT a.id , a.id_tache, a.id_collaborateur , a.vht FROM affectation a , projet p, tache t WHERE p.id_projet = t.id_projet AND  t.id_tache = a.id_tache AND  a.id_tache=?1 AND p.id_projet=?2", nativeQuery = true)
	public List<Affectation> findTach(Long idTache, Long idProjet);

	@Query(value ="select a.id,a.id_tache, a.id_collaborateur , a.vht from tache t, collaborateur c , affectation a where t.id_tache=a.id_tache  and a.id_collaborateur=c.id_collaborateur and t.id_tache=?1 GROUP BY a.id_collaborateur ", nativeQuery = true)
	public List<Affectation> detail(Long idTach);
	
	@Query(value =" select sum(a.vht) from tache t , collaborateur c, affectation a where t.id_tache=a.id_tache and c.id_collaborateur=a.id_collaborateur and t.id_tache=?1 and a.id_collaborateur=?2", nativeQuery = true)
	public int max(Long idTache, Long idColab);
	
	@Query(value = "select a.id,a.id_tache, a.id_collaborateur , a.vht, sum(a.vht), c.nom from tache t, collaborateur c , affectation a where t.id_tache=a.id_tache  and a.id_collaborateur=c.id_collaborateur and t.id_tache=?1  GROUP BY a.id_collaborateur", nativeQuery = true)
	public List<Affectation> details(Long idTach);
	
	
	@Query(value ="select a.*, t.* from projet p, tache t, collaborateur c , affectation a where p.id_projet=t.id_projet and t.id_tache=a.id_tache  and a.id_collaborateur=c.id_collaborateur and t.id_projet=?1 GROUP BY a.id_tache  ", nativeQuery = true)
	public List<Affectation> TacheProjet(Long idProjet);
	
	 public void deleteByTache(Tache tache);
	 @Query(value="select a.* from affectation a where a.id_tache=?1 and a.id_collaborateur=?2", nativeQuery = true)
	 public Affectation affectation(Long idTache,Long idColab);
	 
	 @Query(value = "select a.* from affectation a where a.id_tache=?1",nativeQuery = true)
	 public List<Affectation>findbyIdTache(Long idTache);
	
	
	
	
}
