package baseball;

import utils.RandomUtils;

import java.util.Scanner;

public class Application {
    static boolean[] checkDistinct;
    static final int PLAY = 0;
    static final int ING = 1;
    static final int FINISH = 2;
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        int ongoingInput = PLAY;
        checkDistinct = new boolean[10];
        int[] systemNum = getDistinctNumber();

        while(ongoingInput < FINISH) {
            // 플레이어가 3자리 수를 입력한다.
            System.out.print("숫자를 입력해주세요 : ");
            char[] charUserNum = scanner.next().toCharArray();

            // 정상적인 입력인지 체크
            validateInput(charUserNum);

            // 플레이어 input 문자에서 숫자로 변경
            int[] userNum = charToInt(charUserNum);

            // 스트라이크 체크하기
            int strikeCnt = checkStrike(userNum, systemNum);

            // 정답 체크하기
            if (strikeCnt == 3) {
                System.out.println(strikeCnt + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                ongoingInput = scanner.nextInt();
            }

            // 게임을 완전히 종료할 지 체크하기
            if(ongoingInput == FINISH) {
                break;
            } else if(ongoingInput == ING) {
                checkDistinct = new boolean[10];
                systemNum = getDistinctNumber();
                ongoingInput = PLAY;
                continue;
            }

            // 볼 체크하기
            int ballCnt = checkBall(userNum, systemNum);

            // 결과 출력하기
            if (ballCnt == 0 && strikeCnt == 0) {
                System.out.println("낫싱");
            } else if (ballCnt == 0) {
                System.out.println(strikeCnt + "스트라이크");
            } else if (strikeCnt == 0) {
                System.out.println(ballCnt + "볼");
            } else {
                System.out.println(ballCnt + "볼" + " " + strikeCnt + "스트라이크");
            }
        }

    }

    private static void validateInput(char[] charUserNum) throws IllegalArgumentException {
        if(charUserNum.length > 3) {
            throw new IllegalArgumentException("3자리수를 입력해야합니다.");
        }

        for (int i = 0; i < 3; i++) {
            int tmp = charUserNum[i] - '0';
            if(tmp > 9 || tmp < 1) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
        }
    }

    private static int[] charToInt(char[] charUserNum) {
        int[] userNum = new int[3];
        for (int i = 0; i < 3; i++) {
            int tmp = charUserNum[i] - '0';
            userNum[i] = tmp;
        }
        return userNum;
    }

    private static int[] getDistinctNumber() {
        int[] systemNum = new int[3];
        int numCnt = 0;
        while (numCnt < 3) {
            int tmp = RandomUtils.nextInt(1, 9);
            if (!isDistinct(tmp)) {
                systemNum[numCnt] = tmp;
                numCnt++;
            }
        }
        return systemNum;
    }

    private static boolean isDistinct(int checkNum) {
        if(checkDistinct[checkNum]) {
            return true;
        } else {
            checkDistinct[checkNum] = true;
            return false;
        }
    }

    private static int checkStrike(int[] userNum, int[] systemNum) {
        int strikeCnt = 0;
        for (int i = 0; i < 3; i++) {
            if(userNum[i] == systemNum[i]) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    private static int checkBall(int[] userNum, int[] systemNum) {
        int ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            int tmp = userNum[i];
            if(tmp != systemNum[i] && checkDistinct[tmp]) {
                ballCnt++;
            }
        }
        return ballCnt;
    }

}