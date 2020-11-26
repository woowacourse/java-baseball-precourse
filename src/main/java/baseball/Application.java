package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import utils.RandomUtils;

public class Application {

    public enum GameStatus {
        play, quit
    }

    public static int generateAnswer() {
        List<Integer> answer = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++) {
            int currentValue;
            do {
                currentValue = RandomUtils.nextInt(0, 9);
            } while (answer.contains(currentValue));
            answer.add(currentValue);
        }

        int intAnswer = 0;
        for (int i = 0; i < 3; i++) {
            intAnswer += (int) Math.pow(10, i) * answer.get(i);
        }

        return intAnswer;
    }

    public static void playBaseball(int answer, Scanner scanner) {
        Hint hint = new Hint(0, 0);
        String strAnswer = toStringAnswer(answer);
        while (hint.getStrike() != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String submittedAnswer = scanner.nextLine();
            boolean validationResult = isSubmittedAnswerValid(submittedAnswer);
            if (!validationResult) {
                throw new IllegalArgumentException();
            }
            hint = checkAnswer(strAnswer, submittedAnswer);
            printHint(hint);
        }
    }

    public static String toStringAnswer(int answer) {
        String strAnswer = Integer.toString(answer);
        if (strAnswer.length() == 2) {
            strAnswer = "0" + strAnswer;
        }
        return strAnswer;
    }

    public static void printHint(Hint hint) {
        StringBuffer sb = new StringBuffer();
        if (hint.getBall() > 0) {
            sb.append(hint.getBall() + "볼 ");
        }
        if (hint.getStrike() > 0) {
            sb.append(hint.getStrike() + "스트라이크");
        }
        if (sb.length() == 0) {
            sb.append("낫싱");
        }
        sb.append("\n");
        if (hint.getStrike() == 3) {
            sb.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        }
        System.out.print(sb.toString());
    }

    public static boolean isSubmittedAnswerValid(String submittedAnswer) {
        if (submittedAnswer.length() != 3) {
            return false;
        }

        IntStream intStream = submittedAnswer.chars()
            .filter(element -> element >= 48 && element <= 57);
        if (intStream.count() < 3) {
            return false;
        }

        return true;
    }

    public static GameStatus decideNext(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int input;
        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException();
        }

        if (input != 1 && input != 2) {
            throw new IllegalArgumentException();
        }
        if (input == 2) {
            return GameStatus.quit;
        }
        return GameStatus.play;
    }

    public static Hint checkAnswer(String answer, String submittedAnswer) {

        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) == submittedAnswer.charAt(i)) {
                strike++;
            }
            if (answer.charAt(i) == submittedAnswer.charAt((i + 1) % 3)) {
                ball++;
            }
            if (answer.charAt(i) == submittedAnswer.charAt((i + 2) % 3)) {
                ball++;
            }
        }

        return new Hint(strike, ball);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        GameStatus currentGameStatus = GameStatus.play;
        while (currentGameStatus.equals(GameStatus.play)) {
            int answer = generateAnswer();
            playBaseball(answer, scanner);
            currentGameStatus = decideNext(scanner);
        }
    }
}
