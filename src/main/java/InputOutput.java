/**
 * InputOutput 클래스는 사용자 입력과 출력을 담당합니다.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputOutput {
    private static Scanner sc;

    public InputOutput() {
        sc = new Scanner(System.in);
    }

    public List getInput(int digit) {
        List<Integer> input = new ArrayList<>();
        System.out.print("숫자를 입력해주세요: ");

        String inputVal = sc.nextLine();
        int inputLen = inputVal.length();
        for (int i = 0; i < inputLen; i++) {
            input.add(inputVal.charAt(i) - '0');
        }
        return input;
    }

    public void printResult(Score score, int digit) {
        if (score.strikeCount == digit) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return;
        } else if (score.strikeCount == 0 && score.ballCount == 0) {
            System.out.println("낫싱");
            return;
        } else if (score.strikeCount == 0) {
            System.out.println(score.ballCount + "볼");
            return;
        } else if (score.ballCount == 0) {
            System.out.println(score.strikeCount + "스트라이크");
            return;
        }
        System.out.println(score.strikeCount + "스트라이크 " + score.ballCount + "볼");
    }

    public boolean isExit() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        int inputVal = sc.nextInt();
        if (inputVal == 1) {
            return true;
        }
        return false;
    }

}