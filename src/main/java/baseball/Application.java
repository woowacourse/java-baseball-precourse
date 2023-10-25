package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        String computer_number = generateNumber();

        do {
            System.out.print("숫자를 입력해주세요 : ");
            String s = input(3);
            Score score = check(computer_number, s);
            print(score);
            if (score.correct) {
                computer_number = restart();
            }
        } while (!computer_number.equals("1000"));
    }

    public static class Score {
        int ball = 0;
        int strike = 0;
        boolean correct = false;
    }
    public static String input(int length) {
        String str = Console.readLine();
        boolean matches = str.matches("[0-9]{" + length + "}+");
        if (matches) {
            return str;
        } else {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
    public static String generateNumber() {
        StringBuilder target_number = new StringBuilder();
        target_number.append(Randoms.pickNumberInRange(1, 9));
        for (int i = 0; i < 2; i++) {
            int new_number = Randoms.pickNumberInRange(1, 9);
            do {
                target_number.append(new_number);
            } while (target_number.indexOf(Integer.toString(new_number)) == -1);
        }
        return target_number.toString();
    }
}
