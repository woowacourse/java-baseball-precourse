package domain;

/**
 * 컴퓨터(상대방) 클래스
 * 기능 1. 컴퓨터가 가진 컴퓨터 객체를 싱글톤 형태로 리턴
 */
public class Computer extends Player {
	private static Computer computer = new Computer();

	private Computer() {
	}

	/** 컴퓨터가 가진 컴퓨터 객체를 싱글톤 형태로 리턴 */
	public static Computer getInstance() {
		return computer;
	}
}
