package org.isi.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="CollaborateurCompetence.findAll", query="SELECT ccc FROM CollaborateurCompetence ccc")
public class CollaborateurCompetence implements Serializable{
	 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String niveau;
	
	//bi-directional many-to-one association to Tache
	@ManyToOne
	
	@JoinColumn(name="idCompetence")
	private Competence competence;
	
	//bi-directional many-to-one association to Collaborateur
	@ManyToOne
	@JoinColumn(name="idCollaborateur")
	private Collaborateur collaborateur;

	public CollaborateurCompetence() {

	}

	public CollaborateurCompetence(Long id, String niveau) {
		super();
		this.id = id;
		this.niveau = niveau;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public CollaborateurCompetence(String niveau) {
		super();
		this.niveau = niveau;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "CollaborateurCompetnce [id=" + id + ", niveau=" + niveau + "]";
	}
	
	
	
	
}
