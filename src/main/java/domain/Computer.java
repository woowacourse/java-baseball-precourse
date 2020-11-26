package domain;

public class Computer extends Player {
	private static Computer computer = new Computer();
	
	public static Computer getInstance() {
		return computer;
	}
}
