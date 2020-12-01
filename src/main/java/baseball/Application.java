package baseball;

import java.util.Scanner;
import javax.security.sasl.SaslServer;
import utils.RandomUtils;

class GameEngine{
    private int guess;
    private int answer;
    private int NEW_START = 1;

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
                if(guessStr.charAt(i) == answerStr.charAt(j) && i != j){
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
            if(guessStr.charAt(i) == answerStr.charAt(i)){
              strikeNum += 1;
            }
        }

        return strikeNum;
    }

    String givingHint(int guess){
        String guessStr = Integer.toString(guess);
        String answerStr = Integer.toString(this.answer);
        String hint = "";

        int ballNum = this.getBallNum(guessStr);
        int strikeNum = this.getStrikeNum(guessStr);

        if(ballNum != 0){
            hint += Integer.toString(ballNum) + "볼 ";
        }

        if(strikeNum != 0){
            hint += Integer.toString(strikeNum) + "스트라이크";
        }

        if(ballNum == 0 && strikeNum == 0){
            hint = "낫싱";
        }
        return hint;
    }

    boolean isNewStart(int userChoice){
        if(userChoice == this.NEW_START){
            return true;
        }
        else{
            return false;
        }
    }
    void checkError(int guess){


      if(guess > 999 || guess < 100){
          throw new IllegalArgumentException("세자리수 정수가 아닙니다.");
      }

      for(int i = 0; i < 3; i++){
          if (Integer.toString(guess).charAt(i) == '0'){
            throw new IllegalArgumentException("0 을 포함하고 있습니다");
          }
      }
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

            try{
                guess = Integer.parseInt(scanner.next());

            } catch (NumberFormatException nfe){
                throw new IllegalArgumentException("정수로 바꿀 수 없어요");
            }


            GameEngine gameEngine = new GameEngine();
            answer = gameEngine.chooseAnswer();
            gameEngine.checkError(guess);

            while(answer != guess) {
                 String hint = gameEngine.givingHint(guess);
                 System.out.println(hint);

                  guess = scanner.nextInt();
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userChoice = scanner.nextInt();

            if(gameEngine.isNewStart(userChoice)){
                isEnd = false;
            }
            else{
                isEnd = true;
            }
        }

    }



}
