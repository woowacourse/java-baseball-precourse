package baseball;

import enums.GameProcess;
import enums.RefereeCall;

import java.util.Scanner;

public class Application {

    Number number;
    Referee referee;

    Application() {
        number = new Number();
        referee = new Referee();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Application application = new Application();
        application.init(scanner);
    }

    public void init(Scanner scanner) {
        playGame(scanner);
    }

    public void playGame(Scanner scanner) {
        int strike = 0;
        int ball = 0;
        String computerNumber = number.getComputerNumber();
        while (strike != GameProcess.OUT_3STIRKE.getValue()) {
            String playerNumber = inputPlayerNumber(scanner);

            int[] strikeAndBall = referee.compareNumberOfPlayerAndComputer(playerNumber, computerNumber);
            strike = strikeAndBall[0];
            ball = strikeAndBall[1];

            System.out.println(playerNumber + " : " + computerNumber);
            System.out.println(referee.getHint(strike, ball));
        }
        askRegame(scanner);
    }

    public void askRegame(Scanner scanner) {
        System.out.println(RefereeCall.OUT_3STRIKE.getCall());
        System.out.println(RefereeCall.ASK_REGAME.getCall());
        int regameChoice = scanner.nextInt();
        if (regameChoice == GameProcess.ACCEPT_REGAME.getValue()) {
            scanner.nextLine(); // 버퍼비우기
            playGame(scanner);
            return;
        }
        if (regameChoice == GameProcess.REJECT_REGAME.getValue()) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public String inputPlayerNumber(Scanner scanner) {
        System.out.print(RefereeCall.REQUEST_NUMBER.getCall());
        String playerNumber = scanner.nextLine();
        number.checkCorrectCondition(playerNumber);
        return playerNumber;
    }
}
