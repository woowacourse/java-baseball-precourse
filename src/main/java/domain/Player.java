package domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
	private List<Integer> numbers = new ArrayList<Integer>();
	
	public Integer getNumber(int idx) {
		return numbers.get(idx);
	}

	public void setNumber(Integer number) {
		numbers.add(number);
	}
	
	public void clearNumbers() {
		this.numbers = new ArrayList<Integer>();
	}
}
