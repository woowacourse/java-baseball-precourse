package baseball.gamesource;

import java.util.ArrayList;
import java.util.List;

import baseball.util.InputCheck;
import baseball.constants.MessageConstants;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private final Opponent opponent = new Opponent();

    public void gameStart(){
        List<Integer> userNumbers =new ArrayList<>();
        //디버깅용 정답 출력 코드
        //System.out.println(opponent.getNumbers().toString());

        do{
            //배열리스트 초기화
            userNumbers.clear();

            System.out.print(MessageConstants.NUMBER_INPUT_REQUEST_MESSAGE);
            String userInput = Console.readLine();

            //예외처리하기
            InputCheck.checkGameNumber(userInput);

            for(int i=0; i<userInput.length() ; ++i){
                userNumbers.add((int)(userInput.charAt(i)) - '0');
            }

        }while(!numberCheck(opponent.getNumbers(), userNumbers));

    }

    //두 수를 비교해 두 수가 같을 때만 true 반환
    boolean numberCheck(List<Integer> opponentNumbers, List<Integer> userNumbers){
        int strikeCnt=0;
        int ballCnt=0;

        for(int i=0; i<opponentNumbers.size() ; ++i){

            //스트라이크 개수 구하기
            if(opponentNumbers.get(i).equals(userNumbers.get(i)))
                strikeCnt++;

            ballCnt += ballCheck(opponentNumbers, userNumbers.get(i), i);
        }

        //비교한 정보 출력
        printScore(strikeCnt, ballCnt);

        if(strikeCnt == 3)
            return true;

        return false;
    }


    void printScore(int strikeCnt, int ballCnt){

        if(ballCnt != 0)
            System.out.print(ballCnt + MessageConstants.BALL_MESSAGE);
        if(strikeCnt != 0)
            System.out.print(strikeCnt + MessageConstants.STRIKE_MESSAGE);

        if(strikeCnt == 3){
            System.out.print(MessageConstants.CORRECT_NUMBER_MESSAGE + MessageConstants.GAME_END_MESSAGE);
        }else if(strikeCnt ==0 && ballCnt ==0){
            System.out.print(MessageConstants.MISS_ALL_NUMBER_MESSAGE);
        }

        //줄바꿈
        System.out.print('\n');
    }

    int ballCheck(List<Integer> opponentNumbers, int num, int idx){
        int ballCnt =0;

        for(int i=0; i<opponentNumbers.size() ; ++i){

            if(i == idx)
                continue;

            if(opponentNumbers.get(i) == num)
                ballCnt++;
        }

        return ballCnt;
    }
}
