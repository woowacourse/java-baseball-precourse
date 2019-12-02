import java.util.Scanner;

/**
 * 클래스 이름      PlayGame
 * 버전 정보        1.0
 * 날짜            2019.12.01
 * 저작권          YebinK
 */

public class PlayGame {
    /* 입력받은 값과 정답을 비교하며 숫자야구게임을 진행하는 클래스 */

    PlayerInput p = new PlayerInput();

    /** 정답 숫자 */
    private int [] answer = new int[3];

    /** 사용자가 입력한 숫자 */
    private int [] userInput = new int[3];

    /** 정답과 입력 숫자를 비교해 strike 수를 세는 변수 */
    private int strikeCount = 0;

    /** 정답과 입력 숫자를 비교해 ball 수를 세는 변수 */
    private int ballCount = 0;

    /**
     * 게임 전체를 컨트롤하는 함수.
     * 정답을 생성하고, 정답을 맞출 때까지 사용자의 입력을 받아 값을 비교하고 결과를 출력한다.
     */
    public void playCmd() {
        RandomNumber rn = new RandomNumber();
        answer = rn.setNumber();

        while (strikeCount != 3) {
            initializeCount();
            userInput = p.getInput();
            compare();
            printResult();
        }
    }

    /**
     * 정답과 입력된 숫자를 비교하는 함수
     */
    public void compare() {
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                count(i, j);
            }
        }
    }

    /**
     * 정답 숫자 3개와 입력 숫자 3개를 각각 비교
     * @param i 정답 숫자를 세는 index
     * @param j 입력 숫자를 세는 index
     */
    public void count(int i, int j) {
        if (answer[i] == userInput[j] && i == j) strikeCount++;
        if (answer[i] == userInput[j] && i != j) ballCount++;
    }

    /**
     * 결과 출력 함수
     */
    public void printResult() {

        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart();
        } else if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (ballCount == 0) {
            System.out.println(strikeCount + " 스트라이크");
        } else if (strikeCount == 0) {
            System.out.println(ballCount + " 볼");
        } else System.out.println(strikeCount + " 스트라이크 " + ballCount + " 볼");
    }

    /**
     * strikeCount와 ballCount 초기화
     */
    public void initializeCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    /**
     * 사용자가 정답을 맞춘 후 새로운 게임을 시작할지 묻는 함수
     */
    public void restart() {
        Scanner sc = new Scanner(System.in);
        int cmd = sc.nextInt();

        if (cmd == 1) {
            initializeCount();
            playCmd();
        }
        return;
    }
}