package lesson3_inheritance_hw;

public class UserManager {
	public void createUser(User user)
	{
		System.out.println(user.getFirstName() + " " + user.getLastName() + " hesabiniz basariyla olustu.");
	}
	
	public void updateUser(User user)
	{
		System.out.println(user.getFirstName() + " " + user.getLastName() + " bilgileriniz guncellendi");
	}

}
