package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    
    public static void main(String[] args) {
        playGame();
    }

    // 숫자 야구 게임의 메인 로직
    private static void playGame() {
        boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            List<Integer> computerNumbers = generateRandomNumbers();
            boolean isGameWon = false;

            while (!isGameWon) {
                System.out.print("숫자를 입력해 주세요 : ");
                String input = scanner.nextLine();
                validateInput(input);
                List<Integer> playerNumbers = convertInputToNumbers(input);
                isGameWon = printResult(computerNumbers, playerNumbers);
            }

            playAgain = askToRestart(scanner);
        }

        System.out.println("게임 종료");
    }

    // 사용자 입력 검증
    private static void validateInput(String input) {
        if (input.length() != 3 || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    // 입력된 문자열을 숫자 리스토로 변환
    private static List<Integer> convertInputToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }

    // 컴퓨터와 사용자의 숫자 비교후 결과 출력
    private static boolean printResult(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strike++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3스트라이크");
            return true;
        }

        if (strike > 0 || ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }

        return false;
    }

    // 사용자가 게임을 다시 시작할지 여부
    private static boolean askToRestart(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    // 1부터 9까지 서로 다른 3개의 랜덤 숫자를 생성
    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
