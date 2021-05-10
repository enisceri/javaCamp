package lesson5_eTrade_HW1.googleAccounts;

import lesson5_eTrade_HW1.entities.concretes.User;

public class GoogleAccountManager {
	public void signIn(String email, String password)
	{
		// Google'un veri tabani olmali bu tarafta. 
		// Veri tabani icin sadece 1 ornek ekledim. Asagidaki kod sadece simulasyon amaclidir
		// bu sekilde yazilmamalidir !
		if(email == "yavuz@hotmail.com" && password == "123456")
		{
			System.out.println("Login with Google account is successful");
		}
		else
		{
			System.out.println("Failed to login !!");
		}
	}
	
	public void signUp(User user)
	{
		
	}
	
	// some codes
}
