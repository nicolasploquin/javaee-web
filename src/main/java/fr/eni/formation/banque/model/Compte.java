package fr.eni.formation.banque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Compte implements Serializable {

	private static final long serialVersionUID = -3843548199458975645L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCompte")
	private long id;
	
	private String numero;
	private String intitule;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCompte")
	private List<Operation> operations = new ArrayList<>();

	public Compte() {
	}

	public Compte(String numero, String intitule) {
		this.setNumero(numero);
		this.setIntitule(intitule);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public double getSolde() {
		
		return getOperations().stream()
			.map( ope -> ope.getMontant() ) // Operation -> Double
			.reduce( (m1, m2) -> m1.doubleValue() + m2.doubleValue() )
			.orElse(0.0)
		;

	}

	@Override
	public String toString() {
		return String.format(
				"Compte n°%s - %-20s : %+,12.2f €", 
				getNumero(), 
				getIntitule(),
				getSolde()
			);
	}


}
