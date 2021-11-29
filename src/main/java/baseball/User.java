package baseball;

import java.util.ArrayList;

public class User {

	public ArrayList<Integer> getInputNumber() {
		String inputNumberString = InputView.getInputNumber();
		if (!Validator.checkInputNumber(inputNumberString)) {
			throw new IllegalArgumentException();
		}
		return getIntegerArrayListFromString(inputNumberString);
	}

	private ArrayList<Integer> getIntegerArrayListFromString(String str) {
		ArrayList<Integer> tmp = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			int num = Character.getNumericValue(str.charAt(i));
			tmp.add(num);
		}
		return tmp;
	}
}
