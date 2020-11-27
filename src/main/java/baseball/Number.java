package baseball;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.Set;

public class Number {
    public String getComputerNumber() {
        int computerNumberInt = RandomUtils.nextInt(100, 999);
        String computerNumber = computerNumberInt + "";
        while (hasZero(computerNumber) || isRepeated(computerNumber)) {
            computerNumber = getComputerNumber();
        }
        return computerNumber;
    }

    public boolean isNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isThreeDigitNumber(String number) {
        int playerNumberInt = Integer.parseInt(number);
        if (100 <= playerNumberInt && playerNumberInt < 1000) {
            return true;
        }
        return false;
    }

    public boolean hasZero(String number) {
        String zero = "0";
        if (number.contains(zero)) {
            return true;
        }
        return false;
    }

    public boolean isRepeated(String number) {
        int lengthOfNumber = number.length();
        String[] numberDigitArr = number.split("");
        Set<String> numberDigitSet = new HashSet<>();
        for (int i = 0; i < number.length(); i++) {
            numberDigitSet.add(numberDigitArr[i]);
        }
        if (numberDigitSet.size() != lengthOfNumber) {
            return true;
        }
        return false;
    }

    public void checkCorrectCondition(String number) {
        if (!isNumberFormat(number)) {
            throw new IllegalArgumentException();
        }
        if (!isThreeDigitNumber(number)) {
            throw new IllegalArgumentException();
        }
        if (hasZero(number)) {
            throw new IllegalArgumentException();
        }
        if (isRepeated(number)) {
            throw new IllegalArgumentException();
        }
    }
}
