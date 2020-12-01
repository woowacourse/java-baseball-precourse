package domain;

/**
 * 유저(사용자) 클래스
 * 기능 1. 유저가 가진 유저 객체를 싱글톤 형태로 리턴
 */
public class User extends Player {
	private static User user = new User();

	private User() {
	}
	
	/** 유저가 가진 유저 객체를 싱글톤 형태로 리턴 */
	public static User getInstance() {
		return user;
	}
}
