package lesson5_eTrade_HW1.business.abstracts;

import java.util.List;

import lesson5_eTrade_HW1.entities.concretes.User;

public interface UserService {
	boolean signUp(User user);
	void signIn(String email, String password);
	void signInWithGoogle(String email, String password);
	void signUpWithGoogle(User user);
	public boolean validateUser(User user);
	public boolean isEmailUsed(String email);
	public boolean isEmailValid(String email);
	public boolean isFirstOrLastNameValid(User user);
	public boolean sendVerificationMail(User user);
	public boolean clickVerificationLink();
	List<User> getAll();
}
