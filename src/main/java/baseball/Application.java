package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        while (true) {
            playGame();

            System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = Integer.parseInt(readLine());
            if (choice == 2) {
                break;
            }
        }

        System.out.println("게임 종료. 감사합니다!");
    }

    private static void playGame() {
        int[] computerNumbers = generateRandomNumbers();
        int[] userNumbers;
        int attempts = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("3자리 숫자를 입력하세요: ");
            int input = Integer.parseInt(readLine());
            userNumbers = parseUserInput(input);

            if (!isValidInput(userNumbers)) {
                System.out.println("잘못된 입력입니다. 1부터 9까지 서로 다른 수로 입력해주세요.");
                continue;
            }

            int[] result = compareNumbers(computerNumbers, userNumbers);
            int strikes = result[0];
            int balls = result[1];

            System.out.println(strikes + "스트라이크 " + balls + "볼");

            if (strikes == 3) {
                System.out.println("3개의 숫자를 모두 맞혔습니다. 축하합니다!");
                break;
            }

            attempts++;
        }

        System.out.println("게임 종료! 총 시도 횟수: " + attempts);
    }

    private static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int n = pickNumberInRange(1, 9);
            for (int j = 0; j < i; j++) {
                if (n == numbers[j]) {
                    i--;
                    break;
                }
            }
            numbers[i] = n;
        }
        return numbers;
    }

    private static int[] parseUserInput(int input) {
        int[] numbers = new int[3];
        numbers[2] = input % 10;
        numbers[1] = (input / 10) % 10;
        numbers[0] = input / 100;
        return numbers;
    }

    private static boolean isValidInput(int[] numbers) {
        if (numbers[0] == 0 || numbers[0] == numbers[1] || numbers[0] == numbers[2] || numbers[1] == numbers[2]) {
            return false;
        }
        return true;
    }

    private static int[] compareNumbers(int[] computerNumbers, int[] userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                strikes++;
            } else if (containsNumber(computerNumbers, userNumbers[i])) {
                balls++;
            }
        }

        return new int[]{strikes, balls};
    }

    private static boolean containsNumber(int[] numbers, int target) {
        for (int number : numbers) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }
}