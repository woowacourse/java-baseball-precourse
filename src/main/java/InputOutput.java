import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * InputOutput 클래스는 사용자 입력과 출력을 담당합니다.
 */
public class InputOutput {
    Scanner sc;

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

    public void printResult(int strikeCount, int ballCount, int digit) {
        if (strikeCount == digit) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return;
        } else if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return;
        } else if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
            return;
        } else if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
            return;
        }
        System.out.println(strikeCount + "스트라이크 " + ballCount + "볼");
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
