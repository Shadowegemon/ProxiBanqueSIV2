package dao;

import java.util.List;

import metier.BankAccount;

public interface IDaoAccount {

	public List<BankAccount> getAllAccountByIdClient(long id);
	public void updateAccountByid(long id, double money);
	public List<BankAccount> getAllAccount();
	public BankAccount getAccountById(long id);
	public void removeAccountById(BankAccount ba);
}
