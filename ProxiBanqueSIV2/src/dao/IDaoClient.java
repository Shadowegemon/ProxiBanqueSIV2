package dao;

import metier.Client;

public interface IDaoClient {
	public void addClient(Client cl);
	public void removeClient(Client cl);
	public Client getClientById(Long id);
}
