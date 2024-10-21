package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> computerNumbers = generateRandomNumbers();  // 컴퓨터가 생성한 숫자
        int attempts = 0;
        boolean isCorrect = false;

        System.out.println("1부터 9까지 서로 다른 숫자로 이루어진 3자리 숫자를 맞춰보세요!");

        // 게임 루프
        while (!isCorrect) {
            System.out.print("추측할 숫자를 입력하세요 (예: 123): ");
            String input = scanner.nextLine();

            // 입력 검증
            if (!isValidInput(input)) {
                System.out.println("잘못된 입력입니다. 1부터 9까지의 중복 없는 3자리 숫자를 입력하세요.");
                continue;
            }

            ArrayList<Integer> userNumbers = parseInputToList(input);

            // 스트라이크와 볼 계산
            int strike = calculateStrike(computerNumbers, userNumbers);
            int ball = calculateBall(computerNumbers, userNumbers);

            System.out.println(strike + " 스트라이크, " + ball + " 볼");
            attempts++;

            if (strike == 3) {
                System.out.println("축하합니다! " + attempts + "번 만에 맞추셨습니다.");
                isCorrect = true;
            }
        }

        scanner.close();
    }

    // 컴퓨터가 1부터 9까지 서로 다른 3자리 숫자를 생성
    private static ArrayList<Integer> generateRandomNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);  // 숫자 섞기
        return new ArrayList<>(numbers.subList(0, 3));  // 앞에서 3개의 숫자 선택
    }

    // 입력값 검증
    private static boolean isValidInput(String input) {
        if (input.length() != 3 || !input.matches("[1-9]+")) {
            return false;  // 입력값이 1~9 사이의 세 자리 숫자가 아닌 경우
        }
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char ch : input.toCharArray()) {
            uniqueChars.add(ch);
        }
        return uniqueChars.size() == 3;  // 중복되지 않은 세 자리 숫자인지 확인
    }

    // 입력 문자열을 숫자 리스트로 변환
    private static ArrayList<Integer> parseInputToList(String input) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }

    // 스트라이크 계산
    private static int calculateStrike(ArrayList<Integer> computerNumbers, ArrayList<Integer> userNumbers) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    // 볼 계산
    private static int calculateBall(ArrayList<Integer> computerNumbers, ArrayList<Integer> userNumbers) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.contains(userNumbers.get(i)) && !computerNumbers.get(i).equals(userNumbers.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}


