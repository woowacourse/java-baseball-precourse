package baseballgame;

import java.util.Random;

public class BaseballGame {
    private final int MAX_NUM = 900;

    String getRandomNumber() {
        String randomNumber;

        do {
            randomNumber = Integer.toString(generateRandomNumber());

        } while (hasZero(randomNumber) || hasDuplicatedNumber(randomNumber));

        return randomNumber;

    }

    private int generateRandomNumber() {
        int randomNum;
        Random random = new Random();
        randomNum = random.nextInt(MAX_NUM) + 100;
        return randomNum;
    }

    private boolean hasZero(String number) {
        return number.contains("0");
    }

    private boolean hasDuplicatedNumber(String number) {
        String temp;

        for (int i = 0; i < 2; i++) {
            temp = number.replaceFirst(String.valueOf(number.charAt(i)), "");
            if (temp.contains(String.valueOf(number.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

}