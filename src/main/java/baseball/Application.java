package baseball;

import java.util.Scanner;
import javax.security.sasl.SaslServer;
import utils.RandomUtils;

class GameEngine{
    private int guess;
    private int answer;


    GameEngine(){

    }

    int chooseAnswer(){
        int start = 100;
        int end = 999;

        int answer = utils.RandomUtils.nextInt(start, end);

        this.answer = answer;
        return answer;
    }

  int getBallNum(String guessStr){
      String answerStr = Integer.toString(this.answer);
      int ballNum = 0;

      for(int i = 0; i < 3; i++){
          for(int j = 0; j < 3; j++){
              if(guessStr.indexOf(i) == answerStr.indexOf(j) && i != j){
                  ballNum += 1;
              }
          }
      }

      return ballNum;

  }

    int getStrikeNum(String guessStr){
        String answerStr = Integer.toString(this.answer);
        int strikeNum = 0;

        for(int i = 0; i < 3; i++){
            if(guessStr.indexOf(i) == answerStr.indexOf(i)){
              strikeNum += 1;
            }
        }

        return strikeNum;
    }

};

public class Application {

    public static void main(String[] args) {
        boolean isEnd = false;
        int guess;
        int userChoice;
        int answer;

        while(!isEnd){
            System.out.print("숫자를 입력해주세요 : ");
            final Scanner scanner = new Scanner(System.in);
            guess = scanner.nextInt();

            GameEngine gameEngine = new GameEngine();
            answer = gameEngine.chooseAnswer();
            while(answer != guess) {


            }

        }


    }
}
