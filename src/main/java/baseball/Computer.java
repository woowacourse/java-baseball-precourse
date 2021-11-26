package baseball;

import java.util.List;

import com.model.BaseballFactory;

public class Computer {
	public List<Integer> createRandomBaseballNumbers() {
		return BaseballFactory.createComputerBaseballNumbers();
	}

}
