package baseball;

import enums.GameProcess;
import enums.RefereeCall;
import enums.Regame;

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
        int strike = GameProcess.NO_COUNT.getValue();
        int ball = GameProcess.NO_COUNT.getValue();
        String computerNumber = number.getComputerNumber();
        while (strike != GameProcess.OUT_3STIRKE.getValue()) {
            String playerNumber = inputPlayerNumber(scanner);
            int[] strikeAndBall = referee.comparePlayerWithComputer(playerNumber, computerNumber);
            strike = strikeAndBall[0];
            ball = strikeAndBall[1];

            System.out.println(referee.getHint(strike, ball));
        }
        askRegame(scanner);
    }

    public void askRegame(Scanner scanner) {
        System.out.println(RefereeCall.OUT_3STRIKE.getCall());
        System.out.println(RefereeCall.ASK_REGAME.getCall());
        String regameChoice = scanner.nextLine();
        if (regameChoice.equals(Regame.ACCEPT.getValue())) {
            playGame(scanner);
            return;
        }
        if (regameChoice.equals(Regame.REJECT.getValue())) {
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
