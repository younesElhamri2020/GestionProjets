package org.isi.bean;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@NamedQuery(name="Affectation.findAll", query="SELECT af FROM Affectation af")
public class Affectation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int vhT;
	
	//bi-directional many-to-one association to Tache
	@ManyToOne
	@JoinColumn(name="idTache")
	private Tache tache;
	
	//bi-directional many-to-one association to Collaborateur
	@ManyToOne
	@JoinColumn(name="idCollaborateur")
	private Collaborateur collaborateur;
	
	
    
	public Affectation() {
		super();
	}

	
	
	

	public Affectation(Long id, int vhT) {
		super();
		this.id = id;
		this.vhT = vhT;
	}





	public Affectation(int vhT) {
		super();
		this.vhT = vhT;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getVhT() {
		return vhT;
	}

	public void setVhT(int vhT) {
		this.vhT = vhT;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}



	@Override
	public String toString() {
		return "Affectation [id=" + id + ", vhT=" + vhT + "]";
	}

	

	
	
	}
	
	
	

