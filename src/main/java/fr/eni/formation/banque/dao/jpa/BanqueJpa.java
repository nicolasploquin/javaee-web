package fr.eni.formation.banque.dao.jpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.eni.formation.banque.dao.BanqueDao;
import fr.eni.formation.banque.model.Client;
import fr.eni.formation.banque.model.Compte;
import fr.eni.formation.banque.model.Operation;

public class BanqueJpa implements BanqueDao {
	
//	private EntityManagerFactory emfactory;

//	@PersistenceContext
//	EntityManager em;
		
	public BanqueJpa() {
		
//		emfactory = 
//				Persistence.createEntityManagerFactory("localhost-mysql-banque-web");
//		
		initBanque();
	}
	
	private void initBanque() {
		Client cli1 = new Client("leblanc","marc");
		Compte cpt1 = new Compte("1234", "Compte courant");
		Compte cpt2 = new Compte("2345", "Livret A");
		cpt1.getOperations().add(new Operation(LocalDate.of(2018, 11, 2),"Salaire Renault",1300.0));
		cpt1.getOperations().add(new Operation(LocalDate.of(2018, 11, 5),"TAN Novembre 2018",-56.0));
		cpt1.getOperations().add(new Operation(LocalDate.of(2018, 11, 3),"Free Mobile",-15.99));
		cpt1.getOperations().add(new Operation(LocalDate.of(2018, 11, 8),"impots.gouv.fr",-130.0));
		cpt1.getOperations().add(new Operation(LocalDate.of(2018, 11, 15),"CAF",68.0));
		cpt1.getOperations().add(new Operation(LocalDate.of(2018, 11, 6),"E.Leclerc",-86.51));
		cpt2.getOperations().add(new Operation(LocalDate.of(2018, 1, 2),"Intérêts 2017",32.2));
		cpt2.getOperations().add(new Operation(LocalDate.of(2018, 7, 12),"Placement",200.0));
		cli1.getComptes().add(cpt1);
		cli1.getComptes().add(cpt2);
		
		createClient(cli1);
		createClient(new Client("Troadec","Nolwenn"));
		createClient(new Client("Dupont","Luc"));
		createClient(new Client("Durand","Marie"));

	}
	

	@Override
	public List<Client> readClients() {
		EntityManager em = JpaUtil.getEntityManager();
		return em.createQuery("from Client", Client.class).getResultList();
	}

	@Override
	public Client readClient(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		return em.find(Client.class, id);
	}

	@Override
	public Client readClientNom(String nom) {
		EntityManager em = JpaUtil.getEntityManager();
		TypedQuery<Client> query = 
				em.createQuery("from Client as cli where cli.nom = :nom", Client.class);
		query.setParameter("nom", nom);
		return query.getResultStream().findFirst().orElse(null);
	}

	@Override
	public void createClient(Client client) {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(client);
		
		em.getTransaction().commit();
	}

}
