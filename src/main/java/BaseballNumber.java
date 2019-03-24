package main.java;

/**
 * 숫자야구에 사용될 숫자를 받아  생성<br>
 * BaseballNumber 객체 생성시, 난수를 포함하며 난수를 통해 정렬된다.
 */
public class BaseballNumber implements Comparable<BaseballNumber> {
	private double randomNumber = Math.random();
	private int number;

	public BaseballNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public int compareTo(BaseballNumber baseballNumber) {
		if (this.randomNumber >= baseballNumber.randomNumber) {
			return 1;
		} else {
			return -1;
		}
	}
}