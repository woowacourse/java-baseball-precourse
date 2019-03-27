import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameManager {
    private Computer computer;
    private BufferedReader bufferdreader;
    private static int computerNumber[];

    GameManager() {
        bufferdreader = new BufferedReader(new InputStreamReader(System.in));
    }

    /*
     *  초기화, 컴퓨터 객체 새로 생성
     */
    private void init() {
        computer = new Computer();
    }

    /*
     *  게임 시작 메소드
     */
    public void startGame() throws Exception {
        init();
        computerNumber = computer.getComputerNumber();
        //System.out.println("컴퓨터 예측 숫자 : "+computerNumber[0]+computerNumber[1]+computerNumber[2]);
        int userNumber[] = new int[3];
        do {
            String number = userNumber();
            saveUserNumber(userNumber, number);
        } while (!getState(userNumber));

    }

    /*
     *  사용자가 선택한 번호를 저장하는 메소드
     */
    private void saveUserNumber(int userNumber[], String number) {
        for (int i = 0; i < number.length(); i++) {
            userNumber[i] = number.charAt(i) - 48;
        }
    }

    /*
     *  사용자가 숫자를 입력하는 메소드
     */
    private String userNumber() throws Exception {
        String number = "";

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            number = bufferdreader.readLine();
            if (checkUserNumber(number)) break;
        }

        return number;
    }

    /*
     *  사용자가 입력한 숫자가 유효한지 체크하는 메소드
     */
    private boolean checkUserNumber(String number) {

        if (number.equals("") || number.charAt(0) == ' ' || number.charAt(1) == ' ' || number.charAt(2) == ' ') {
            System.out.println("공백 없이 세자리 수를 입력해야합니다.");
            return false;
        }

        if (number.length() != 3) {
            System.out.println("3자리 수를 입력해야합니다.");
            return false;
        }

        if (number.charAt(0) == number.charAt(1) || number.charAt(0) == number.charAt(2) || number.charAt(1) == number.charAt(2)) {
            System.out.println("서로 다른 세자리 수를 입력헤야합니다.");
            return false;
        }

        return true;
    }

    /*
     *  컴퓨터가 정한 번호와 사용자가 입력한 번호를 비교해 결과 상태 확인하는 메소드
     */
    private boolean getState(int userNumber[]) throws Exception {
        int strike = 0;
        int ball = 0;

        if (computerNumber[0] == userNumber[0]) strike++;
        if (computerNumber[1] == userNumber[1]) strike++;
        if (computerNumber[2] == userNumber[2]) strike++;
        if (computerNumber[0] != userNumber[0] && (computerNumber[0] == userNumber[1] || computerNumber[0] == userNumber[2]))
            ball++;
        if (computerNumber[1] != userNumber[1] && (computerNumber[1] == userNumber[0] || computerNumber[1] == userNumber[2]))
            ball++;
        if (computerNumber[2] != userNumber[2] && (computerNumber[2] == userNumber[0] || computerNumber[2] == userNumber[1]))
            ball++;

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            endGame();
            return true;
        }
        if (strike > 0) {
            System.out.print(strike + " 스트라이크 ");
        }
        if (ball > 0) {
            System.out.print(ball + " 볼");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱!");
        }
        System.out.println();

        return false;

    }

    /*
     *  게임종료와 새로운 게임시작 중 선택하는 메소드
     */

    private void endGame() throws Exception {
        boolean end = false;
        while (!end) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String command = bufferdreader.readLine();
            end = checkEndCommand(command);
        }
    }

    private boolean checkEndCommand(String command) throws Exception {
        if (command.equals("1")) {
            startGame();
            return true;
        } else if (command.equals("2")) {
            System.out.println("게임을 완전히 종료합니다.");
            return true;
        } else {
            System.out.println("다시 입력해주세요.");
        }

        return false;
    }

}
