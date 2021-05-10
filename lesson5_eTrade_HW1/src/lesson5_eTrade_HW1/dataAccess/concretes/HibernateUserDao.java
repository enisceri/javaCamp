package lesson5_eTrade_HW1.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import lesson5_eTrade_HW1.dataAccess.abstracts.UserDao;
import lesson5_eTrade_HW1.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	private List<User> users;
	
	public HibernateUserDao() {
		users = new ArrayList<User>();	
	} 
	
	public List<User> getList()
	{
		return this.users;
	}
	
	@Override
	public void addNewUserToSystem(User user) {		
		users.add(user);
		System.out.println("Kullanici veri tabanina eklendi");
		
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
