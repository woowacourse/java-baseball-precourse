package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    String answer = "";

    public void makeAnswer() {
        this.answer = "";
        int[] answerArray = new int[9];
        int temp;
        int randomNumber;
        for (int i=0; i<9; i++) {
            answerArray[i] = i+1;
        }
        for (int i=0; i<3; i++) {
            randomNumber = Randoms.pickNumberInRange(0,8);
            temp = answerArray[i];
            answerArray[i] = answerArray[randomNumber];
            answerArray[randomNumber] = temp;
        }
        for (int i=0; i<3; i++) {
            this.answer += answerArray[i];
        }
    }

    public static void main(String[] args) {
        /*
        System.out.println("test");
        Application test = new Application();
        for (int i=0; i<10; i++) {
            test.makeAnswer();
            System.out.println(test.answer);
        }
         */
    }
}
