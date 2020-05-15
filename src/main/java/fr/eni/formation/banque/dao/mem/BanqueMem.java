package fr.eni.formation.banque.dao.mem;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import fr.eni.formation.banque.dao.BanqueDao;
import fr.eni.formation.banque.model.Client;
import fr.eni.formation.banque.model.Compte;
import fr.eni.formation.banque.model.Operation;

public class BanqueMem implements BanqueDao {
	
	
	private List<Client> clients = new LinkedList<Client>();
	
	
	public BanqueMem() {
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
		clients.add(cli1);
		clients.add(new Client("Troadec","Nolwenn"));
		clients.add(new Client("Dupont","Luc"));
		clients.add(new Client("Durand","Marie"));
	}
	
	

	@Override
	public List<Client> readClients() {
		return clients;
	}

	@Override
	public Client readClient(long id) {
		return null;
	}

	@Override
	public Client readClientNom(String nom) {
		return clients.stream()
			.filter(cli -> cli.getNom().toLowerCase().contains(nom))
			.findFirst()
			.orElse(null);
	}

	@Override
	public void createClient(Client client) {
		clients.add(client);
	}

}
