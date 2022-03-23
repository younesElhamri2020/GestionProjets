package org.isi.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;




@Entity
@NamedQuery(name="Competence.findAll", query="SELECT c FROM Competence c")
public class Competence implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCompetence;
	private String designation;
	
	
	@ManyToMany(mappedBy = "competences")
	private List<Tache> tache;

	@OneToMany(mappedBy="competence", fetch=FetchType.EAGER)
	private List<CollaborateurCompetence> collaborateurCompetence;
	
	public Competence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Competence(String designation) {
		super();
		this.designation = designation;
	}
	public Long getIdCompetence() {
		return idCompetence;
	}
	public void setIdCompetence(Long idCompetence) {
		this.idCompetence = idCompetence;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
    @JsonIgnore
	public List<Tache> getTache() {
		return tache;
	}
    @JsonSetter
	public void setTache(List<Tache> tache) {
		this.tache = tache;
	}
    
    @JsonIgnore
	public List<CollaborateurCompetence> getCollaborateurCompetence() {
		return collaborateurCompetence;
	}
    @JsonSetter
	public void setCollaborateurCompetence(List<CollaborateurCompetence> collaborateurCompetence) {
		this.collaborateurCompetence = collaborateurCompetence;
	}
	@Override
	public String toString() {
		return "Competence [idCompetence=" + idCompetence + ", designation=" + designation + "]";
	}
	
	
	
	

}