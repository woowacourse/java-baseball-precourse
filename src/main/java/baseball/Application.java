package baseball;

import controller.GameBoard;
import controller.RandomVendor;
import controller.domain.BaseballStatus;
import input.InputCheck;
import view.Printer;
import view.PrinterImpl;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        // 인풋을 체크하는 클래스 - 숫자 판별만
        InputCheck checker = new InputCheck();

        // 무작위 1~9를 포함하는 3자리의 숫자를 생성
        RandomVendor vendor = new RandomVendor();

        // 게임을 컨트롤하는 게임 보드
        GameBoard board = new GameBoard(checker, vendor);

        // 출력을 위한 프린터 클래스
        Printer printer = new PrinterImpl();

        boolean notEnd = true;

        // 게임 초기화
        board.initGameBoard();

        while (notEnd) {

            // 게임이 끝났을 경우
            if(board.isTerminal()) {

                System.out.println(printer.printCorrect());
                String command = scanner.nextLine();
                notEnd = board.restart(command);
                
            // 게임이 끝나지 않았을 경우
            } else if(!board.isTerminal()) {

                System.out.print(printer.printInputDescription());
                String line = scanner.nextLine();

                BaseballStatus status = board.predict(line);
                System.out.println(printer.printStatus(status));
            }


        }

    }
}
