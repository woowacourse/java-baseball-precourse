package model;

public class BaseballNumber {
	private int number;

	public BaseballNumber(int number) {
		this.number = number;
	}

	public BaseballNumber(String number) {
		this.number = Integer.parseInt(number);
	}
}
