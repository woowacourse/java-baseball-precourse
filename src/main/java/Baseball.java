import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Baseball {
    private static String secretNumber;
    private static String inputNumber;

    public static void main(String[] args) {
        boolean playGame = true;

        while (playGame) {
            secretNumber = makeDifferentNumbers();
            scoreInput();
            playGame = playGameAgain();
        }
    }

    private static String makeDifferentNumbers() {
        int countOfCards = 3;
        int[] randomNumbers = new int[countOfCards];
        Random random = new Random();

        int i = 0;
        while (i < countOfCards) {
            int newRandomNumber = (random.nextInt(9));
            if (!isDuplicates(randomNumbers, newRandomNumber)) {
                randomNumbers[i] = newRandomNumber;
                i++;
            }
        }
        return Arrays.toString(randomNumbers).replaceAll("[^0-9]", "");
    }

    private static boolean isDuplicates(int[] array, int num) {
        for (int value : array) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }

    private static void scoreInput() {

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            inputNumber = getInputString();
            validateInput();

            if (inputNumber.equals(secretNumber)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                return;
            }

            System.out.println(getHint());
        }
    }

    private static String getHint() {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < secretNumber.length(); i++) {
            if (inputNumber.charAt(i) == secretNumber.charAt(i)) {
                strikeCount += 1;
                continue;
            }
            ballCount += getBallCount(i);
        }
        return formatHint(strikeCount, ballCount);
    }

    private static int getBallCount(int index) {
        int count = 0;
        for (int j = 0; j < secretNumber.length(); j++) {
            if (inputNumber.charAt(index) == secretNumber.charAt(j)) {
                count += 1;
            }
        }
        return count;
    }

    private static String formatHint(int strikeCount, int ballCount) {
        String strikeForm = "";
        String ballForm = "";

        if (strikeCount != 0) {
            strikeForm = strikeCount + " 스트라이크 ";
        }
        if (ballCount != 0) {
            ballForm = ballCount + "볼";
        }
        if (strikeCount == 0 && ballCount == 0) {
            ballForm = "낫싱";
        }
        return strikeForm + ballForm;
    }

    private static boolean playGameAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String AgainStatus = getInputString();

        return AgainStatus.equals("1");
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void validateInput() {
        while (inputNumber.length() != secretNumber.length()) {
            System.out.printf("%d 자리의 숫자를 입력해주세요.\n", secretNumber.length());
            inputNumber = getInputString();
        }
    }
}
