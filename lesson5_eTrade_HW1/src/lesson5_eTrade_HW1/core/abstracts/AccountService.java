package lesson5_eTrade_HW1.core.abstracts;

import lesson5_eTrade_HW1.entities.concretes.User;

public interface AccountService {
	void signIn(String email, String password);
}
