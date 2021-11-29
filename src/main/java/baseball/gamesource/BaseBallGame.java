package baseball.gamesource;

import java.util.ArrayList;
import java.util.List;

import baseball.util.InputCheck;
import baseball.constants.MessageConstants;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private Opponent opponent = new Opponent();

    public void gameStart(){
        List<Integer> userNumbers =new ArrayList<>();

        //디버깅용 정답 출력 코드
        //System.out.println(opponent.getNumbers().toString());

        do{
            //연관배열 초기화
            userNumbers.clear();

            System.out.print(MessageConstants.NUMBER_INPUT_REQUEST_MESSAGE);
            String userInput = Console.readLine();

            //예외처리하기
            InputCheck.checkGameNumber(userInput);

            for(int i=0; i<userInput.length() ; ++i){
                userNumbers.add((int)(userInput.charAt(i)) - '0');
            }

        }while(!numberCheck(opponent.getNumbers(), userNumbers));

        System.out.println(MessageConstants.GAME_END_MESSAGE);
    }

    //두 수를 비교해 두 수가 같을 때만 true 반환
    boolean numberCheck(List<Integer> oppo, List<Integer> user){
        int strikeCnt=0;
        int ballCnt=0;

        for(int i=0; i<oppo.size() ; ++i){

            //스트라이크 개수 구하기
            if(oppo.get(i) == user.get(i))
                strikeCnt++;

            ballCnt += ballCheck(oppo, user.get(i), i);
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
            System.out.println(strikeCnt + MessageConstants.STRIKE_MESSAGE);

        if(strikeCnt == 3){
            System.out.print(MessageConstants.CORRECT_NUMBER_MESSAGE);
        }else if(strikeCnt ==0 && ballCnt ==0){
            System.out.println(MessageConstants.MISS_ALL_NUMBER_MESSAGE);
        }

    }

    int ballCheck(List<Integer> oppo, int num, int idx){
        int ballCnt =0;

        for(int i=0; i<oppo.size() ; ++i){

            if(i == idx)
                continue;

            if(oppo.get(i) == num)
                ballCnt++;
        }

        return ballCnt;
    }
}
