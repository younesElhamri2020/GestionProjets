package org.isi.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@NamedQuery(name="Collaborateur.findAll", query="SELECT cl FROM Collaborateur cl")
public class Collaborateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCollaborateur;
	@Column(length = 10)
	private String codeCollaborateur;
	private String nom;
	private String prenom;
	
	

	@OneToMany(mappedBy="collaborateur", fetch=FetchType.EAGER)
	private List<CollaborateurCompetence> collaborateurCompetences;
	
	@OneToMany(mappedBy="collaborateur")
	private List<Affectation> affectation;
	
	public Collaborateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collaborateur(String codeCollaborateur, String nom, String prenom) {
		super();
		this.codeCollaborateur = codeCollaborateur;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Long getIdCollaborateur() {
		return idCollaborateur;
	}
	public void setIdCollaborateur(Long idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}
	public String getCodeCollaborateur() {
		return codeCollaborateur;
	}
	public void setCodeCollaborateur(String codeCollaborateur) {
		this.codeCollaborateur = codeCollaborateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	} 
	
	
	@JsonIgnore
	public List<CollaborateurCompetence> getCollaborateurCompetences() {
		return collaborateurCompetences;
	}
	@JsonSetter
	public void setCollaborateurCompetences(List<CollaborateurCompetence> collaborateurCompetences) {
		this.collaborateurCompetences = collaborateurCompetences;
	}
	@JsonIgnore
	public List<Affectation> getAffectation() {
		return affectation;
	}
	@JsonSetter
	public void setAffectation(List<Affectation> affectation) {
		this.affectation = affectation;
	}
	@Override
	public String toString() {
		return "Collaborateur [codeCollaborateur=" + codeCollaborateur + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	

}