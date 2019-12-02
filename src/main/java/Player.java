import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player {


    private boolean wantToContinue;
    private Scanner input;

    Player() {
        this.wantToContinue = true;
        this.input = new Scanner(System.in);
    }

    public List<Integer> getPlayerInputNumbers() {
        List<Integer> inputNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = input.next();

        for (int i = 0; i < BaseballGame.ANSWER_NUMBERS_COUNT; ++i) {
            inputNumbers.add(inputString.charAt(i) - '0');
        }

        return inputNumbers;
    }

    public int getPlayerWillingToContinue() {
        printContinueMessage();
        return input.nextInt();
    }

    private void printContinueMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public boolean toBeContinued() {
        return this.wantToContinue;
    }

    public void playerQuitGame() {
        this.wantToContinue = false;
    }
}
