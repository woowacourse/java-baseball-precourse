/*
 * @(#)Main.java        2019-12-01
 *
 * [저작권 및 라이센스 관련 정보를 여기에 작성한다.]
 */

import java.util.Scanner;

/**
 * @version         1.01 2019-12-01
 * @author          최근휘
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Baseball baseball = new Baseball();

        proceedGame(scanner, baseball);
    }

    public static void proceedGame(Scanner scanner, Baseball baseball) {
        /* "y"라면 계속 진행 */
        String proceed = "y";

        while (proceed.equals("y")) {
            oneGame(scanner, baseball);
            System.out.println("축하드립니다!! 맞추셨습니다!!");
            System.out.println("게임을 계속 진행하시려면 y키, 아니면 아무키나 입력해주세요.");
            proceed = scanner.next();
        }
        System.out.println("게임이 종료되었습니다. 고생하셨습니다!!");
    }

    public static void oneGame(Scanner scanner, Baseball baseball) {
        String input;
        baseball.setComputersNum();

        System.out.println("컴퓨터의 숫자가 설정되었습니다.");
        System.out.println("세 개의 숫자를 입력해주세요: ");

        input = scanner.next();
        baseball.setPlayersNum(input);
        while (!baseball.checkSame()) {
            baseball.calculateStrikesAndBalls();
            System.out.println(baseball.getHint());
            input = scanner.next();
            baseball.setPlayersNum(input);
        }
    }
}
