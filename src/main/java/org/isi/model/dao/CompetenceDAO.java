package org.isi.model.dao;

import java.util.List;

import org.isi.bean.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceDAO extends JpaRepository<Competence, Long>{


	@Query("Select c from Competence c where c.designation like %?1%")
	public List<Competence> findByDesignationn(String designation);
	public Competence findByDesignation(String designation);


	
}