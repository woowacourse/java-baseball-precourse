package baseball;

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
        while (strike != 3) {
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
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String regameChoice = scanner.nextLine();
        if (regameChoice.equals("1")) {
            playGame(scanner);
            return;
        }
        if (regameChoice.equals("2")) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public String inputPlayerNumber(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumber = scanner.nextLine();
        number.checkCorrectCondition(playerNumber);
        return playerNumber;
    }
}
