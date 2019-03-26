/**
 * baseballGame 클래스는 Display, Number, Match 클래스를 이용하여 baseballGame을 구현하는 클래스입니다.
 *
 * @version 1.0 2019년 3월 26일
 * @author          이중혁
 * */


public class baseballGame {

    /* baseballGame main 메소드 */
    public static void main(String[] args){

        Display baseballGameDisplay = new Display();                    // Display 클래스
        Match baseballGameMatch = new Match();                          // Match 클래스
        Number baseballGameNumber = new Number();                       // Number 클래스

        int[] gameResultArr = new int[2];                               // 게임 결과를 저장 하는 배열 선언
        int[] randomNum = new int[3];                                   // 난수 저장

        int gameState = 0;                                              // 게임 상태 결정
        int randomState = 0;                                            // 난수 상태
        int userNum = 0;                                                // 유저 입력 저장

        boolean gameChoice = false;                                     // 3스트라이크 판별

        /* 게임종료(gameState == 2) 일때 까지 반복 */
        while(gameState != 2){

            if(randomState == 0){

                /*randomNum가 0일때만 난수 생성 0이 아니면 이미 난수 생성이므로 제외*/
                randomNum = baseballGameNumber.createRandomNumber();    // 난수 생성후 배열 저장
                randomState +=1;                                        // 난수 만들어진 상태 (randomState 1 증가)
            }


            baseballGameDisplay.inputDisplay();                         // 사용자입력 문구 출력
            userNum = baseballGameNumber.inputUserNumber();             // 사용자입력 저장

            /* randomNum과 userNum 비교후 결과를 배열로 반환 */
            gameResultArr = baseballGameMatch.matchNumber(randomNum, userNum);

            baseballGameDisplay.matchDisplay(gameResultArr);            // 게임결과 출력

            /* 3스트라이크시 true, 3스트라이크 아니면 false 반환 */
            gameChoice = baseballGameMatch.getBaseballResult(gameResultArr);

            if(gameChoice == true){

                /* 게임 결과가 3스트라이크 일때 */
                baseballGameDisplay.getResultDisplay(gameResultArr);    // 게임 결과 출력
                gameState = baseballGameMatch.getGameState(gameChoice); // 새로시작 1 / 게임종료 2 gameState에 입력받음
            } else {

                /* 3스트라이크가 아닐경우 */
                continue;
            }

            if(gameState == 1){

                /* 게임을 새로 시작할 경우 */
                randomState = 0;          // randomState를 0으로 대입하여 반복문 시작에 새로운 난수를 받도록 한다.
            }
        }
    }
}
