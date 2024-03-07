package baseball;

import java.util.Scanner;

// computer에서 랜덤으로 생성한 숫자 3개를 가져온다.
// 플레이어가 입력한 3개의 숫자와 비교한다.

// 1. 같은 수, 같은 자리 = 스트라이크
// 2. 같은 수, 다른 자리 = 볼
// 3. 같은 수 x = 포볼

public class GameController {

    Scanner scanner = new Scanner(System.in);

    Computer computer;

    public GameController() {
        computer = new Computer();
    }

    public void gameStart() {

        // 무한 루프
        while (true) {

            System.out.print("숫자를 입력해주세요 : ");
            int[] playerNum = new int[3];   // 크기가 3인 배열 생성

            for (int i = 0; i < playerNum.length; i++) {
                playerNum[i] = scanner.nextInt();   // 3개의 수 입력
            }

            // 초기화
            int strike = 0;
            int ball = 0;

            // 플레이어와 컴퓨터 숫자 비교
            for (int i = 0; i < 3; i++) {   // 플레이어가 입력한 수
                for (int j = 0; j < 3; j++) {   // 컴퓨터의 수
                    if (playerNum[i] == computer.getRandomNum()[j]) {
                        if (i == j) {   // 플레이어의 수와 컴퓨터의 수가 같으면
                            strike = strike + 1;    // 스트라이크 = 기존 0 + 1;
                        } else {    // 같은 게 없다면
                            ball = ball + 1;    // 볼 = 기존 0 + 1;
                        }
                    }
                }
                System.out.print(strike + "스트라이크 " + ball + "볼");
            }

            // 모두 안 맞을 때
            if (strike == 0 && ball == 0) {
                System.out.println("포볼");
            }

            // 모두 스트라이크일 때
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
