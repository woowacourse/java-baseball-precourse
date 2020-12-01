package baseball;

import java.util.Scanner;

/**
 * 숫자 야구 게임을 진행하는 클래스
 *
 * @version 1.0 2020-11-29
 */
public class BaseballGame {
    private Computer computer;
    private User user = new User();

    private static final int SIZE = 3;

    /**
     * 숫자 야구 게임을 시작하는 메서드
     */
    public void playGame() {
        this.computer = new Computer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                String input = scanner.nextLine();
                this.user.makeNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[잘못된 입력] 1에서 9사이의 서로 다른 숫자 3자리를 입력해주세요.");
                continue;
            }

            if (isCorrectAnswer()) {
                break;
            }
            checkNumber();
        }
    }

    /**
     * 사용자가 입력한 숫자가 정답인지 확인하고 정답이면 true, 오답이면 false를 반환
     *
     * @return 정답이면 true, 오답이면 false를 반환
     */
    private boolean isCorrectAnswer() {
        if (this.computer.getNumber().equals(this.user.getNumber())) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    /**
     * 힌트를 제공하기 위해 사용자의 입력값을 검사하는 메서드
     *
     * strike : 같은 자리에 같은 숫자가 있는 경우
     * ball : 다른 자리에 같은 숫자가 있는 경우
     */
    private void checkNumber() {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < SIZE; i++) {

            if (this.isStrike(i)) {
                strike++;
            } else if (isBall(i)) {
                ball++;
            }
        }

        printHint(strike, ball);

    }

    /**
     * 사용자와 컴퓨터의 숫자 하나가 같은 자리에 같은 숫자가 있는 경우인지 판단하는 메서드
     *
     * @param index 검사해야하는 위치값
     * @return 같은 자리에 같은 숫자가 있으면 true, 아니면 false
     */
    private boolean isStrike(int index) {
        return this.computer.getNumber().charAt(index) == this.user.getNumber().charAt(index);
    }

    /**
     * 사용자의 숫자 하나가 같은 자리는 아니지만 컴퓨터의 숫자안에 존재하는지 판단하는 메서드
     *
     * @param index 사용자의 숫자에 검사해야하는 위치값
     * @return 사용자의 숫자 하나가 같은 자리는 아니지만 컴퓨터의 숫자안에 존재한다면 true, 아니면 false
     */
    private boolean isBall(int index) {
        return this.computer.getNumber().contains(String.valueOf(this.user.getNumber().charAt(index)));
    }

    /**
     * 힌트를 출력해주는 메서드 strike도 ball도 없다면 "낫싱"을 출력합니다.
     *
     * @param strike 같은 자리에 같은 숫자가 있는 경우를 나타낸 int 타입의 값
     * @param ball 다른 자리에 같은 숫자가 있는 경우를 나타낸 int 타입의 값
     */
    private void printHint(int strike, int ball) {
        StringBuilder sb = new StringBuilder();

        if (ball > 0) {
            sb.append(ball + "볼 ");
        }
        if (strike > 0) {
            sb.append(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb);

    }
}
