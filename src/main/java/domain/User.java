package domain;

public class User extends Player {
	private static User user = new User();
	
	public static User getInstance() {
		return user;
	}
}
