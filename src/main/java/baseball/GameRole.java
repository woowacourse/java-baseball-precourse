package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class GameRole {
    private static int ball;
    private static int strike;

    public static void startGame() {
        InputRole inputRole = new InputRole();
        OutputRole outputRole = new OutputRole();
        String computerNumber = getRandomNumber();

        while (true) {
            ball = 0;
            strike = 0;
            calculateGameResult(inputRole.getInputValue(), computerNumber, outputRole);

            if (!outputRole.isStrike(strike)) {
                continue;
            }

            if (outputRole.restartResult()) {
                computerNumber = getRandomNumber();
                continue;
            }
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

    private static void calculateGameResult(String input, String computerNumber, OutputRole outputRole) {


        for (int i = 0; i < computerNumber.length(); i++) {
            char number = computerNumber.charAt(i);
            if (number == input.charAt(i)) {
                strike++;
                continue;
            }
            if (input.contains(String.valueOf(number))) {
                ball++;
            }
        }
        outputRole.printResult(strike, ball);


    }


}
