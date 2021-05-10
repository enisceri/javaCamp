package lesson5_eTrade_HW1.dataAccess.abstracts;

import java.util.List;

import lesson5_eTrade_HW1.entities.concretes.User;

public interface UserDao {
	void addNewUserToSystem(User user);
	List<User> getAll();
}
