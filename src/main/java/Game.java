import java.util.Scanner;
import java.util.ArrayList;

/**
 * 숫자 야구 게임을 수행하는 클래스.
 * 사용자에게 수를 입력받고 컴퓨터와 비교,
 * 비교한 결과값 출력, 게임 종료 등의 기능을 수행한다.
 * @author giantim
 */
public class Game {
	/** 스트라이크의 수를 세는 변수 */
    private int strikeCount;
    /** 볼의 수를 세는 변수 */
    private int ballCount;
    /** 상대방  */
    private Computer myComputer;
    /** 사용자 */
    private Player myPlayer;
    /** 사용자에게 수를 입력받는 스캐너 */
    private Scanner in;
    
    /**
     * 생성자. 상대방, 플레이어, 스캐너를 초기화 한다.
     */
    public Game() {
        myComputer = new Computer();
        myPlayer = new Player();
        in = new Scanner(System.in);
    }
    
    /**
     * 게임을 실행한다. 반복문을 돌면서
     * 게임의 진행 상황을 검사한다.
     */
    private void run() {
        String input;
        String playerResult;
        boolean isRun = true;

        do {
            System.out.print(Constant.STR_INPUT);
            input = in.next();
            playerResult = myPlayer.inputNumber(input);
            isRun = checkResult(playerResult);
        } while (isRun);
    }
    
    /**
     * Player객체에서 사용자가 입력한 수를 검사한 결과값을 이용하여 게임을 진행한다.
     * 입력한 수의 형식에 대해 결과 문자열이 반환고 그 문자열을 출력한다.
     * @param result 사용자가 입력한 수를 검사한 결과 문자열
     * @return compareNumber() 사용자가 입력한 수가 유효한 수 이므로 수를 비교한다.
     * @return true 잘못된 수가 입력됨.
     */
	private boolean checkResult(String result) {
		switch (result) {
		case Constant.STR_EMPTY:
			return compareNumber();
		default:
			System.out.println(result);
			return true;
		}
	}
	
	/**
	 * 사용자가 입력한 수와 컴퓨터가 갖고 있는 수를 비교한다.
	 * 비교한 결과에 따라서 스트라이크, 볼, 낫싱, 게임 완료 등의
	 * 결과를 출력한다.
	 * @return 게임의 종료와 다시 진행 여부를 반환.
	 */
    private boolean compareNumber() {
        ArrayList<Integer> list = myComputer.getNumberSet();
        strikeCount = 0;
        ballCount = 0;

        for (int i = 0; i < Constant.NUM_SIZE; i++) {
            isSame(list.get(i), i);
        }
        if (strikeCount != Constant.NUM_SIZE) {
            printStrike();
            printBall();
            printNothing();
            System.out.println();
            return true;
        }
        return isContinue();
    }
    
    /**
     * 사용자가 입력한 수와 컴퓨터가 갖고 있는 수를 비교하여
     * 스트라이크와 볼의 개수를 센다.
     * @param num 컴퓨터가 갖고 있는 수의 한 자리 수
     * @param index num의 위치
     */
    private void isSame(int num, int index) {
        ArrayList<Integer> list = myPlayer.getNumberSet();

        if (list.get(index).equals(num)) {
            strikeCount = strikeCount + 1;
        } else if (list.contains(num)) {
            ballCount = ballCount + 1;
        }
    }
    
    /**
     * 스트라이크의 개수를 출력한다.
     */
    private void printStrike() {
        if (strikeCount != 0) {
            System.out.print(Integer.toString(strikeCount) + Constant.STR_STRIKE);
        }
    }
    
    /**
     * 볼의 개수를 출력한다.
     */
    private void printBall() {
        if (ballCount != 0) {
            System.out.print(Integer.toString(ballCount) + Constant.STR_BALL);
        }
    }
    
    /**
     * 스트라이크와 볼이 없을 때 결과를 출력한다.
     */
    private void printNothing() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print(Constant.STR_NOTHING);
        }
    }	
    
    /**
     * 3자리 수가 모두 동일할 때 게임의 종료 문구를 출력한다.
     */
    private void printEndGame() {
        System.out.println(Constant.STR_END_GAME);
        System.out.println(Constant.STR_QUESTION);
    }
    
    /**
     * 사용자에게 1 또는 2를 입력받아 게임의 재개 여부를 판단한다.
     * @return false 게임을 종료한다
     * @return true 게임을 재개한다.
     */
    private boolean isContinue() {
        String input;

        printStrike();
        printEndGame();
        do {
            input = in.next();
        } while (!checkValidation(input));
        if (input.equals("1")) {
            myComputer.restartGame();
            return true;
        }
        return false;
    }
    
    /**
     * 게임 종료 시 사용자에게 입력받은 값의 유효성을 검사한다.
     * @param input 사용자의 입력값
     * @return true 유효한 값
     * @return false 잘못된 값
     */
    private boolean checkValidation(String input) {
        if (input.equals("1") || input.equals("2")) {
            return true;
        }
        System.out.println(Constant.STR_VALIDATION);
        return false;
    }
    
    /**
     * main 함수.
     * @param args
     */
    public static void main(String args[]) {
        Game game = new Game();
        game.run();
    }
}