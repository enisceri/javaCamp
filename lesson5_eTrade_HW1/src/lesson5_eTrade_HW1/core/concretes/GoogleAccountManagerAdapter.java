package lesson5_eTrade_HW1.core.concretes;

import lesson5_eTrade_HW1.core.abstracts.AccountService;
import lesson5_eTrade_HW1.entities.concretes.User;
import lesson5_eTrade_HW1.googleAccounts.GoogleAccountManager;

public class GoogleAccountManagerAdapter implements AccountService{
	public void signIn(String email, String password)
	{
		GoogleAccountManager accountManager = new GoogleAccountManager();
		accountManager.signIn(email, password);
		
	}

}
