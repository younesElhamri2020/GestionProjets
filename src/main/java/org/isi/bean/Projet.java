package org.isi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@NamedQuery(name="Projet.findAll", query="SELECT p FROM Projet p")
public class Projet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProjet;
	private String intituleP;
	@JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date dateDebutP;
	@JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date dateFinP;
	private int nbrCollaborateur;
	private int vhProjet;
	
	
	@OneToMany(mappedBy="projet", fetch=FetchType.EAGER)
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Tache> taches =new ArrayList<Tache>();

	
	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Projet(String intituleP, Date dateDebutP, Date dateFinP, int nbrCollaborateur, int vhProjet) {
		super();
		this.intituleP = intituleP;
		this.dateDebutP = dateDebutP;
		this.dateFinP = dateFinP;
		this.nbrCollaborateur = nbrCollaborateur;
		this.vhProjet = vhProjet;
	}



	public Long getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(Long idProjet) {
		this.idProjet = idProjet;
	}
	public String getIntituleP() {
		return intituleP;
	}
	public void setIntituleP(String intituleP) {
		this.intituleP = intituleP;
	}
	public Date getDateDebutP() {
		return dateDebutP;
	}
	public void setDateDebutP(Date dateDebutP) {
		this.dateDebutP = dateDebutP;
	}
	public Date getDateFinP() {
		return dateFinP;
	}
	public void setDateFinP(Date dateFinP) {
		this.dateFinP = dateFinP;
	}
	
	public int getNbrCollaborateur() {
		return nbrCollaborateur;
	}
	public void setNbrCollaborateur(int nbrCollaborateur) {
		this.nbrCollaborateur = nbrCollaborateur;
	}
	
	public int getVhProjet() {
		return vhProjet;
	}
	public void setVhProjet(int vhProjet) {
		this.vhProjet = vhProjet;
	}

@JsonIgnore
	public List<Tache> getTaches() {
		return taches;
	}

@JsonSetter
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebutP == null) ? 0 : dateDebutP.hashCode());
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
		Projet other = (Projet) obj;
		if (dateDebutP == null) {
			if (other.dateDebutP != null)
				return false;
		} else if (!dateDebutP.equals(other.dateDebutP))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Projet [idProjet=" + idProjet + ", intituleP=" + intituleP + ", dateDebutP=" + dateDebutP
				+ ", dateFinP=" + dateFinP + ", nbrCollaborateur=" + nbrCollaborateur + ", vhProjet=" + vhProjet + "]";
	}

	

	
	
	
	
	

}
