package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    String answer = "";
    String playGame = "1";

    public void makeAnswer() {
        this.answer = "";
        int[] answerArray = new int[9];
        int temp;
        int randomNumber;
        for (int i=0; i<9; i++) {
            answerArray[i] = i+1;
        }
        for (int i=0; i<3; i++) {
            randomNumber = Randoms.pickNumberInRange(1,9);
            temp = answerArray[i];
            answerArray[i] = answerArray[randomNumber-1];
            answerArray[randomNumber-1] = temp;
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

    public void validation(String inputNumber) {
        String range = "123456789";
        String include = "";
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i=0; i<3; i++) {
            if (!range.contains(inputNumber.substring(i,i+1))) {
                throw new IllegalArgumentException();
            } else if (include.contains(inputNumber.substring(i,i+1))) {
                throw new IllegalArgumentException();
            } else {
                include += inputNumber.substring(i,i+1);
            }

        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.makeAnswer();

        while (application.playGame.equals("1")) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();
            application.validation(inputNumber);
            String result = application.check(inputNumber);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                application.playGame = Console.readLine();
                application.makeAnswer();
            }

        }
        System.out.println("게임 종료");

    }
}
