package org.isi.bean;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@NamedQuery(name="Tache.findAll", query="SELECT t FROM Tache t")
public class Tache implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTache;
	private String intitule;
	@JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date dateDebutT;
	@JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date dateFinT;
	private int vhTache;
	
	@ManyToMany
	@JoinTable(name = "TacheCompetence"
	           ,joinColumns = {
	        		          @JoinColumn(name="idTache")
	            }
	           ,inverseJoinColumns = {
	        		          @JoinColumn(name="idCompetence")
	           }
	           )
	
	private List<Competence> competences;
	
	@OneToMany(mappedBy= "tache")
	private List<Affectation> affectation;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name="idProjet")
	private Projet projet;
	
	public Tache() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Tache(String intitule, Date dateDebutT, Date dateFinT, int vhTache) {
		super();
		this.intitule = intitule;
		this.dateDebutT = dateDebutT;
		this.dateFinT = dateFinT;
		this.vhTache = vhTache;
	}


	public Long getIdTache() {
		return idTache;
	}
	public void setIdTache(Long idTache) {
		this.idTache = idTache;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public Date getDateDebutT() {
		return dateDebutT;
	}
	public void setDateDebutT(Date dateDebutT) {
		this.dateDebutT = dateDebutT;
	}
	public Date getDateFinT() {
		return dateFinT;
	}
	public void setDateFinT(Date dateFinT) {
		this.dateFinT = dateFinT;
	}
	

	public int getVhTache() {
		return vhTache;
	}


	public void setVhTache(int vhTache) {
		this.vhTache = vhTache;
	}

 
	@JsonIgnore
	public List<Competence> getCompetences() {
	return competences;
    }

	@JsonSetter
    public void setCompetences(List<Competence> competences) {
	this.competences = competences;
    }

    @JsonIgnore
	public List<Affectation> getAffectation() {
		return affectation;
	}
	@JsonSetter
	public void setAffectation(List<Affectation> affectation) {
		this.affectation = affectation;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTache == null) ? 0 : idTache.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tache other = (Tache) obj;
		if (idTache == null) {
			if (other.idTache != null)
				return false;
		} else if (!idTache.equals(other.idTache))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Tache [idTache=" + idTache + ", intitule=" + intitule + ", dateDebutT=" + dateDebutT + ", dateFinT="
				+ dateFinT + ", vhTache=" + vhTache + "]";
	}


}