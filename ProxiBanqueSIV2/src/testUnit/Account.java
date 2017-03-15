package testUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.DaoAccount;
import metier.BankAccount;
import service.ServiceAccount;

public class Account {

	@Test
	public void TransferAccountToAccount() {
		
		BankAccount host = DaoAccount.getInstance().getAccountById(3);
		BankAccount dest = DaoAccount.getInstance().getAccountById(6);
		double tmpSolddest = dest.getSold();
		
		ServiceAccount.transferAccoutToAccount(host, dest, 1000);

		 dest = DaoAccount.getInstance().getAccountById(6);
		 assertTrue(dest.getSold() > tmpSolddest);
	}
	
	

}
