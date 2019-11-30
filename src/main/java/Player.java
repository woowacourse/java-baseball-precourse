import java.util.Scanner;

/**
 * Player class - 플레이어(사람)의 기능을 정의
 *
 * @version         1.01 2019-11-30
 * @author          김범준(ddaaac)
 */
public class Player {
    /* 플레이어는 추측을 하거나 추가 게임 여부를 정할 수 있음 */

    /**
     * 올바른 형식의 3자리 숫자를 입력받아 이 값을 리턴
     * @return 입력받은 3자리 숫자
     */
    public int guess() {
        String input;               // 입력받은 문자열
        int inputNumber;            // 문자열을 3자리 숫자로 변환한 숫자
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            input = scan.nextLine();
            try {
                inputNumber = Integer.parseInt(input);          // 문자열을 숫자로 변환
            } catch (Exception e) {                             // 숫자가 아니라면 다시 입력
                continue;
            }
            // 111~999 사이 숫자가 아니라면 다시 입력
            if (inputNumber >= 111 && inputNumber < 1000) {
                break;
            }
        }

        return inputNumber;
    }

    /**
     * 게임을 계속할지 종료할지 결정하는 메소드
     * @return 추가 게임 진행 여부 (게임을 계속하면 true, 아니면 false)
     */
    public boolean doMoreGame() {
        String input;                       // 입력받을 문자열
        String continueGame = "1";          // 추가 게임
        String quitGame = "2";              // 게임 종료
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = scan.nextLine();

            if (input.equals(continueGame)) {
                return true;
            } else if (input.equals(quitGame)) {
                return false;
            } else {
                System.out.println("다시 입력해주세요.");
            }
        }
    }
}
