package lesson5_eTrade_HW1.business.concretes;

import java.util.List;
import java.util.regex.Pattern;
import lesson5_eTrade_HW1.business.abstracts.UserService;
import lesson5_eTrade_HW1.core.abstracts.AccountService;
import lesson5_eTrade_HW1.dataAccess.abstracts.UserDao;
import lesson5_eTrade_HW1.entities.concretes.User;

public class UserManager implements UserService{
	private UserDao userDao;
	private AccountService accountService;
	
	private static final String EMAIL_PATTERN 
	= "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|info)(.[A-Z]{2})?$";

	 
	public UserManager(UserDao userDao, AccountService accountService) {
		this.userDao = userDao;
		this.accountService = accountService;
	}
	public UserDao getUserDao()
	{
		return userDao;
	}
	
	public boolean sendVerificationMail(User user)
	{
		if(validateUser(user))
		{
			System.out.println("Verification link of your membership has been sent."
					+ " If you click the link, your membership will be approved.");
			return true;
		}
		return false;
	}
	public boolean clickVerificationLink()
	{
		// kullanicinin tikladigi varsayilmistir.
		System.out.println("Your membership has been approved.");
		return true; 
	}

	
	public boolean validateUser(User user)
	{
		if(!isFirstOrLastNameValid(user))
		{
			return false;
		}
		
		if(user.getPassword().length() < 6)
		{
			System.out.println("Password must be at least 6 characters !!!");
			return false;
		}
		
		if(!isEmailValid(user.getEmail())) // mail gecerli formatta degilse 
		{
			System.out.println("Email is in invalid format."
					+ "Make sure it has the extension below.\r\n"
					+ "com, org, net, edu, gov");
			return false;
		}
		if(isEmailUsed(user.getEmail()))
		{
			System.out.println("This email has already received !!");
			return false;
		}
		
		return true;
	}
	
	public boolean isEmailValid(String email)
	{
		Pattern pattern = Pattern.compile(EMAIL_PATTERN,
				Pattern.CASE_INSENSITIVE);
				return pattern.matcher(email).find();
	}
	
	public boolean isEmailUsed(String email)
	{
		for (User user : userDao.getAll())
		{
			if(user.getEmail() == email)
			{
				return true;
			}		
		}
		return false;
		
	}
	
	public boolean isFirstOrLastNameValid(User user)
	{
		if(user.getFirstName().length() < 2 || user.getLastName().length() < 2)
		{
			System.out.println("Name and surname must contain at least 2 characters !!");
			return false;
		}
		return true;
	}

	
	@Override
	public boolean signUp(User user) {
		if(sendVerificationMail(user) && clickVerificationLink())
		{			
			System.out.println("User has successfully registered. Welcome " + 
		user.getFirstName() + " " + user.getLastName());
			userDao.addNewUserToSystem(user);	
			return true;
		}
		
			System.out.println("Please provide the terms, registration failed !!");
			return false;
	}

	@Override
	public void signIn(String email, String password) {	
		for (User user : userDao.getAll()) {
			if(email == user.getEmail() && password == user.getPassword())
			{
				System.out.println(user.getFirstName() + " " + user.getLastName()
				+ " welcome !");
				return;
			}	
		}
			
			System.out.println("Email or password is incorrect !!!");	
	}
	
	public void signInWithGoogle(String email, String password)
	{
		for (User user : userDao.getAll()) {
			if(user.getEmail() == email) // kullanici maili bizim sitede kayitliysa
			{
				this.accountService.signIn(email,password);
				return;
			}
		}
		
		System.out.println("Aren't you a member? Sign up please !");
	}

	public void signUpWithGoogle(User user)
	{
		signUp(user);	
	}
	
	
	@Override
	public List<User> getAll()
	{
		return userDao.getAll();
	}



}
