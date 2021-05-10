package lesson5_eTrade_HW1;

import lesson5_eTrade_HW1.business.concretes.UserManager;
import lesson5_eTrade_HW1.core.concretes.GoogleAccountManagerAdapter;
import lesson5_eTrade_HW1.dataAccess.concretes.HibernateUserDao;
import lesson5_eTrade_HW1.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		// basarili user ornegi
		User user1 = new User(1,"Enis", "Çeri", "enis@hotmail.com","123456");
		// basarili user ornegi 2
		User user2 = new User(2,"Mehmet", "Can", "memo@hotmail.com","123456");
		// gecersiz mail ornegi
		User user3 = new User(3,"Engin", "Demirog", "engin@hotmail.co","123456");
		// gecersiz sifre ornegi
		User user4 = new User(4,"Engin", "Demirog", "engin@gmail.com","123");
		// gecersiz ad veya soyad ornegi
		User user5 = new User(5,"E", "D", "engin@gmail.com","123456");
		// google ile login
		User user6 = new User(6,"sdsE", "sdsD", "yavuz@hotmail.com","123456");
		// google'da asagidaki bilgilerle uyeligi olup google hesabi ile giris ornegi.
		User user7 = new User(7,"Kerem", "Gunduz", "kerem@hotmail.com","123456");

		UserManager userManager = new UserManager(new HibernateUserDao(), new GoogleAccountManagerAdapter());
		
		
		System.out.println("SIGN UP SIMULATION\n-------------");
		userManager.signUp(user1);
		System.out.println("*******************************");
		userManager.signUp(user2);
		System.out.println("*******************************");
		userManager.signUp(user3);
		System.out.println("*******************************");
		userManager.signUp(user4);
		System.out.println("*******************************");
		userManager.signUp(user5);
		System.out.println("*******************************");
		userManager.signUp(user6);
		System.out.println("*******************************");
		userManager.signUpWithGoogle(user7);
		
		System.out.println("_________________________");
		System.out.println("Sign In Simulation\n--------------------");
		userManager.signIn("memo@hotmail.com", "123456");
		userManager.signInWithGoogle("yavuz@hotmail.com", "123456");
		
		System.out.println("\n\n");

	}

}
