package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameRole {

    public static void startGame() {
        while (true) {
            InputRole inputRole = new InputRole();
            checkGameResult(inputRole.getInputValue());
            return;
        }
    }

    public static String getRandomNumber() {
        String randomNumber = "";

        while (randomNumber.length() != 3) {
            String randomChar = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!randomNumber.contains(randomChar)) {
                randomNumber = randomNumber.concat(randomChar);
            }
        }

        return randomNumber;
    }

    private static void checkGameResult(String input) {
        int ball = 0;
        int strike = 0;
        String computerNumber = getRandomNumber();

        for (int i = 0; i < input.length(); i++) {
            char number = computerNumber.charAt(i);
            if (number == input.charAt(i)) {
                strike++;
                continue;
            }
            if (input.contains(String.valueOf(number))){
                ball++;
            }
        }
        System.out.println("computerNumber = " + computerNumber);
        System.out.println("input = " + input);
        System.out.println("strike = " + strike);
        System.out.println("ball = " + ball);

    }


}
