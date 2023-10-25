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
    public static Score check(String target, String inputNum) {
        Score score = new Score();

        for (int i = 0; i < 3; i++) {
            char char1 = target.charAt(i);
            char char2 = inputNum.charAt(i);
            if (char1 == char2) {
                score.strike += 1;
            }
            else if (target.indexOf(char2) != -1){
                score.ball += 1;
            }
        }

        if (score.strike == 3) {
            score.correct = true;
        }
        return score;
    }

    public static void print(Score score) {
        if (score.ball == 0 && score.strike == 0) {
            System.out.println("낫싱");
        }
        else if (score.strike == 0) {
            System.out.println(score.ball + "볼");
        } else if (score.ball == 0) {
            System.out.println(score.strike + "스트라이크");
        } else {
            System.out.println(score.ball + "볼 " + score.strike + "스트라이크");
        }
        if (score.correct) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public static String restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String s = input(1);
        if (Objects.equals(s, "1")) {
            return generateNumber();
        }
        return "1000";
    }
}
