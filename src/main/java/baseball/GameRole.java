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
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return numbers.toString().replaceAll("[^0-9]", "");
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
