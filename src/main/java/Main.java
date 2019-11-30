/**
 * Main class - 메인 함수 정의
 *
 * @version         1.00 2019-11-30
 * @author          김범준(ddaaac)
 */
public class Main {
    public static void main(String[] args) {
        Boolean doMoreGame = true;                          // 게임 진행 여부
        Computer computer = new Computer();
        Player player = new Player();

        while (doMoreGame) {
            Boolean playerGotAnswer = false;            // 플레이어 정답 여부
            int playerGuessNumber;                      // 플레이어가 추측한 숫자

            computer.makeAnswerNumber();                                                // 1. 숫자 제시
            while (!playerGotAnswer) {
                playerGuessNumber = player.guess();                                     // 2. 숫자 추측
                playerGotAnswer = computer.checkAnswerNumber(playerGuessNumber);        // 3. 결과 출력
            }                                                                           // 4. 게임 종료
            doMoreGame = player.doMoreGame();                                           // 5. 추가 게임 여부 결정
        }                                                                               // 6. 게임 종료
    }
}
