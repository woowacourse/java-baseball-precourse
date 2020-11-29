package baseball;

import java.util.Scanner;

public class Baseball {
    private static ThreeNumGenerator threeNumGenerator = new ThreeNumGenerator();
    private static UserInput userInput = new UserInput();
    private static NumberCompare numberCompare = new NumberCompare();

    private static int[] comNum;
    private static int[] userNum;

    /* 게임 실행 및 종료 함수 */
    public static void gameRun() {
        comNum = threeNumGenerator.generate();

        while (true) {
            userNum = userInput.getUserNum();
            numberCompare.compare(comNum, userNum);
            if(numberCompare.gameClear()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            numberCompare.printScore();
            numberCompare.resetScore();
        }
        Baseball.asktoRestart();
    }

    /* 게임 종료 후 재시작할 지 묻는 메소드 */
    public static void asktoRestart() {
        Scanner input = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String useranswer = input.nextLine();

        switch (useranswer) {
            case "1": { // 입력 값 1인 경우
                numberCompare.resetScore();
                Baseball.gameRun();
            }
            case "2": { // 입력 값 2인 경우
                break;
            }
            default: { // 입력 값이 1이나 2가 아닌 경우
                throw new IllegalArgumentException();
            }
        }
    }
}
