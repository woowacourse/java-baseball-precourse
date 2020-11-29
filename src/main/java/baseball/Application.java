package baseball;

import utils.RandomUtils;

import java.util.Scanner;

public class Application {
    static boolean[] checkDistinct;
    static final int PLAY = 0;
    static final int ING = 1;
    static final int END = 2;
    static int ongoingStatus;
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        // 세 개의 중복되지 않은 수 정하기
        checkDistinct = new boolean[10];
        int[] systemNum = getDistinctNumber();

        ongoingStatus = PLAY;
        while(ongoingStatus < END) {
            // 플레이어가 입력
            System.out.print("숫자를 입력해주세요 : ");
            char[] charUserNum = scanner.next().toCharArray();

            // 정상적인 입력인지 체크 (같은 숫자 중복 입력, 3자리가 아 수 입력, 숫자가 아닌것 입력)
            try {
                validateNumberInput(charUserNum);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            // 플레이어 input 문자에서 숫자로 변경
            int[] userNum = charToInt(charUserNum);

            // 스트라이크 체크하기
            int strikeCnt = checkStrike(userNum, systemNum);

            // 정답 체크하기
            if(checkAnswer(strikeCnt)) {
                ongoingStatus = scanner.nextInt();
            }

            // 게임을 완전히 종료할 지 체크
            if(ongoingStatus == END) {
                break;
            } else if(ongoingStatus == ING) {
                checkDistinct = new boolean[10];
                systemNum = getDistinctNumber();
                ongoingStatus = PLAY;
                continue;
            }

            // 볼 체크하기
            int ballCnt = checkBall(userNum, systemNum);

            // 결과 출력하기
            printResult(ballCnt, strikeCnt);
        }
    }

    private static void validateNumberInput(char[] charUserNum) {
        if(charUserNum.length != 3) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 3자리수를 입력해야합니다. 다시 입력해주세요.");
        }

        boolean[] checkDuplication = new boolean[10];
        for (int i = 0; i < 3; i++) {
            int tmp = charUserNum[i] - '0';
            if(tmp > 9 || tmp < 1) {
                throw new IllegalArgumentException("잘못 입력하셨습니다. 숫자가 아닙니다. 다시 입력해주세요.");
            } else if(!checkDuplication[tmp]) {
                checkDuplication[tmp] = true;
            } else {
                throw new IllegalArgumentException("잘못 입력하셨습니다. 각 자리수 숫자는 달라야 합니다. 다시 입력해주세요.");
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
            if (isDistinct(tmp)) {
                systemNum[numCnt] = tmp;
                numCnt++;
            }
        }
        return systemNum;
    }

    private static boolean isDistinct(int checkNum) {
        if(!checkDistinct[checkNum]) {
            checkDistinct[checkNum] = true;
            return true;
        } else {
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

    private static boolean checkAnswer(int strikeCnt) {
        if (strikeCnt == 3) {
            System.out.println(strikeCnt + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        } else {
            return false;
        }
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

    private static void printResult(int ballCnt, int strikeCnt) {
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