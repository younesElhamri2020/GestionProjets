package org.isi.model.service.facade;

import java.util.List;

import org.isi.bean.Competence;

public interface CompetenceService {
	 public List<Competence> findByDesignationn(String designation);
	 public Competence findByDesignation(String designation);
		public int save(Competence competence);
		public  void deleteById(Long id);

	   
		public List<Competence> findAll();

		public void updateC(Long id, Competence c);
}
