package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Integer> numberList;

	public Player() {
		this(new ArrayList<>());
	}

	public Player(List<Integer> numberList) {
		this.numberList = numberList;
	}

	public List<Integer> getNumberList() {
		return numberList;
	}

	public void setNumberList(List<Integer> numberList) {
		this.numberList = numberList;
	}
}
