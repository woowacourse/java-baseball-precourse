package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        playNumberBaseballGame();
    }

    private static void playNumberBaseballGame() {
        Console scanner = new Console(System.in);
        System.out.println("숫자 야구 게임을 시작합니다. 1부터 9까지 서로 다른 숫자로 이루어진 3자리 수를 맞춰보세요.");

        while (true) {
            // 컴퓨터가 생각한 3개의 숫자를 무작위로 생성
            List<Integer> computerNumbers = generateRandomNumbers();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = scanner.readLine();

                if (input.length() != 3 || !input.matches("[1-9]+")) {
                    System.out.println("잘못된 입력입니다. 1부터 9까지 서로 다른 3자리 숫자를 입력하세요.");
                    continue;
                }

                int[] guess = new int[3];
                for (int i = 0; i < 3; i++) {
                    guess[i] = Character.getNumericValue(input.charAt(i));
                }

                int strikes = 0;
                int balls = 0;

                for (int i = 0; i < 3; i++) {
                    if (guess[i] == computerNumbers.get(i)) {
                        strikes++;
                    } else if (computerNumbers.contains(guess[i])) {
                        balls++;
                    }
                }

                if (strikes == 3) {
                    System.out.println("3 스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else if (strikes > 0 || balls > 0) {
                    System.out.println(balls + "볼 "+ strikes + "스트라이크");
                } else {
                    System.out.println("낫싱");
                }
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            int playAgain = scanner.readLine();
            scanner.readLine();

            if (playAgain==2) {
                System.out.println("게임을 종료합니다.");
                break;
            }
            else if (playAgain != 1) {
                System.out.println("잘못된 입력입니다. 1 또는 2를 입력하세요.");
                break;
            }
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        int n = Randoms.pickNumberInRange(1, 100);
        numbers.add(n / 100); // 백의 자리 숫자
        numbers.add((n % 100) / 10); // 십의 자리 숫자
        numbers.add(n % 10); // 일의 자리 숫자
        return numbers
    }
}

