package baseball;

import java.util.Scanner;
import javax.security.sasl.SaslServer;
import utils.RandomUtils;

class Game{
    private int guess;
    private int answer;


    Game(){

    }

  int chooseAnswer(){
      int start = 100;
      int end = 999;

      int answer = utils.RandomUtils.nextInt(start, end);

      this.answer = answer;
      return answer;
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

            Game g = new Game();
            answer = g.chooseAnswer();


        }


    }
}
