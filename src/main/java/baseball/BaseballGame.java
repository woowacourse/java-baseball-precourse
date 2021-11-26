package baseball;

public class BaseballGame {
    // 게임 진행 : Round(Computer 랜덤 값 지정 -> Game(사용자 입력 -> 결과 출력))

    public static void Round() {
        Computer BaseballComputerTarget = new Computer();
        BaseballComputerTarget.makeTarget();

        Game(BaseballComputerTarget.target);
    }

    public static void Game(int[] target) {
        boolean result = false;

        do{
            // 사용자에게 입력 받기
            System.out.print("숫자를 입력해주세요: ");
            int[] userNumber = User.inputNumber();

            // 결과 출력
            result = PrintResult.printResult(target, userNumber);
        }while(result == false);
    }

    public static int NextRound() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int nextRound = User.choiceNextRound();

        return nextRound;
    }
}
