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
        List<Integer> answer = new ArrayList<>();
        final int answerLength = 3;
        final int startInclusive = 0;
        final int endInclusive = 9;

        for (int i = 0; i < answerLength; i++) {
            int currentValue;
            do {
                currentValue = RandomUtils.nextInt(startInclusive, endInclusive);
            } while (answer.contains(currentValue));
            answer.add(currentValue);
        }

        int intAnswer = 0;
        for (int i = 0; i < answerLength; i++) {
            intAnswer += (int) Math.pow(10, i) * answer.get(i);
        }

        return intAnswer;
    }

    public static void playBaseball(int answer, Scanner scanner) {
        final String pleaseInputNumberMessage = "숫자를 입력해주세요 : ";

        Hint hint = new Hint(0, 0);
        String strAnswer = toStringAnswer(answer);
        while (!isCorrect(hint)) {
            System.out.print(pleaseInputNumberMessage);
            String submittedAnswer = scanner.nextLine();
            boolean validationResult = isSubmittedAnswerValid(submittedAnswer);
            if (!validationResult) {
                throw new IllegalArgumentException();
            }
            hint = checkAnswer(strAnswer, submittedAnswer);
            printHint(hint);
        }
    }

    public static boolean isCorrect(Hint hint) {
        return hint.getStrike() == 3;
    }

    public static String toStringAnswer(int answer) {
        final String headZero = "0";
        String strAnswer = Integer.toString(answer);
        if (isHeadZeroOmitted(strAnswer)) {
            strAnswer = headZero + strAnswer;
        }
        return strAnswer;
    }

    public static boolean isHeadZeroOmitted(String strAnswer) {
        return strAnswer.length() == 2;
    }

    public static void printHint(Hint hint) {
        final String ballText = "볼";
        final String space = " ";
        final String strikeText = "스트라이크";
        final String nothingText = "낫싱";
        final String newLine = "\n";
        final String congratulationMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

        StringBuilder sb = new StringBuilder();
        if (hint.getBall() > 0) {
            sb.append(hint.getBall() + ballText + space);
        }
        if (hint.getStrike() > 0) {
            sb.append(hint.getStrike() + strikeText);
        }
        if (sb.length() == 0) {
            sb.append(nothingText);
        }
        sb.append(newLine);
        if (isCorrect(hint)) {
            sb.append(congratulationMessage + newLine);
        }
        System.out.print(sb.toString());
    }

    public static boolean isSubmittedAnswerValid(String submittedAnswer) {
        if (submittedAnswer.length() != 3) {
            return false;
        }

        IntStream intStream = submittedAnswer.chars()
            .filter(element -> element >= 48 && element <= 57);

        return intStream.count() == 3;
    }

    public static GameStatus decideNext(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        final String play = "1";
        final String quit = "2";
        String input = scanner.nextLine();
        if (!(input.equals(play) || input.equals(quit))) {
            throw new IllegalArgumentException();
        }
        if (input.equals(quit)) {
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
