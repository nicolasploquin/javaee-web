package fr.eni.formation.banque.dao;

import java.util.List;

import fr.eni.formation.banque.model.Client;

public interface BanqueDao {
	
	List<Client> readClients();
	Client readClient(long id);
	Client readClientNom(String nom);
	void createClient(Client client);

}
