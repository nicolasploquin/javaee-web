package fr.eni.formation.banque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Client implements Serializable {
	
	private static final long serialVersionUID = -1129184497020071590L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idClient")
	private long id;
	
	private String nom;
	private String prenom;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "idClient")
	private List<Compte> comptes = new ArrayList<>();
	
	public Client() {
	}

	public Client(String nom, String prenom) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toUpperCase();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom.substring(0,1).toUpperCase()
					+ prenom.substring(1).toLowerCase();
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	@Override
	public String toString() {
		return String.format("%s %s", prenom, nom);
	}
	
	
	
	
	
	
}
