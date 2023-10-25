package util;

import java.util.HashSet;
import java.util.Set;

public class InputException {
	private String inputNumber;	
	
	public InputException(String inputNumber) {

		isStringLengthCorrect(inputNumber);
		isDigitPlayerNumber(inputNumber);
		isDifferentPlayerNumber(inputNumber);
		
		this.inputNumber = inputNumber;
	}

	public String getInputNumber() {
		return inputNumber;
	}

	public static void isStringLengthCorrect(String word) throws IllegalArgumentException {
        if (word.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. ");
        }
    }


    public static void isDifferentPlayerNumber(String word) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        if (set.size() != word.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
    public static void isDigitPlayerNumber(String word) {
    	for (int i = 0; i < word.length(); i++) {
    		isDigitCharInString(word, i);
    	}
    }

    public static void isDigitCharInString(String word, int index) throws IllegalArgumentException {
        if (!Character.isDigit(word.charAt(index))) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
