package fr.eni.formation.banque.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Operation implements Serializable {
	
	private static final long serialVersionUID = -727083465148813150L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOperation")
	private long id;
	
	private LocalDate date;
	private String libelle;
	private double montant;
	
	public Operation() {
	}

	public Operation(LocalDate date, String libelle, double montant) {
		this.setDate(date);
		this.setLibelle(libelle);
		this.setMontant(montant);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant)  {
		this.montant = montant;
	}
	

	public String toString() {
		return "Operation [date=" + date + ", libelle=" + libelle + ", montant=" + montant + "]";
	}

	
	

}
