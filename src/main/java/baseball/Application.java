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

    public String check(String inputNumber) {
        int strike=0;
        int ball=0;
        for (int i=0; i<3; i++) {
            if (inputNumber.charAt(i) == this.answer.charAt(i)) {
                strike++;
            } else if (this.answer.contains(inputNumber.charAt(i)+"")) {
                ball++;
            }

        }
        StringBuffer toSay = new StringBuffer("");

        if (ball!=0) {
            toSay.append(ball+"볼 ");
        }

        if (strike!=0) {
            toSay.append(strike+"스트라이크");
        }

        if (strike==0 & ball==0) {
            toSay.append("낫싱");
        }

        return toSay.toString();

    }

    public static void main(String[] args) {
        Application application = new Application();
        application.makeAnswer();
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        String result = application.check(inputNumber);
        System.out.println(result);



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
