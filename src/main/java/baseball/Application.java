package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {

    public static int[] countBall(int[] numbers, String inputNumbers){
        int ball = 0;
        int strike = 0;

        return new int[] {ball, strike};
    }

    public static void playBall(int[] numbers){

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumbers = Console.readLine();

            if (inputNumbers.length() != 3)
                throw new IllegalArgumentException("the number of input numbers is not 3");

            String patternNumberOnly = "^[0-9]*$";
            boolean regex = Pattern.matches(patternNumberOnly, inputNumbers);

            if (!regex) throw new IllegalArgumentException("only numbers are allowed to the input value");

            int result[] = countBall(numbers, inputNumbers);
            int ball = result[0];
            int strike = result[1];

//                System.out.println("ball is");
//                System.out.println(ball);
//                System.out.println("strike is");
//                System.out.println(strike);

            StringBuilder sb = new StringBuilder();

            if (strike == 3) {
                sb.append("3스트라이크\n").append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println(sb);
                break;
            } else if (strike == 0 && ball == 0) {
                sb.append("낫싱");
            } else if (strike != 0 && ball == 0) {
                sb.append(String.valueOf(strike)).append("스트라이크");
            } else if (strike == 0 && ball != 0) {
                sb.append(String.valueOf(ball)).append("볼");
            } else {
                sb.append(String.valueOf(ball)).append("볼 ").append(String.valueOf(strike)).append("스트라이크");
            }

            System.out.println(sb);
        }
    }

    public static void playGame(){

        while (true) {

            int[] numbers = new int[3];

            for (int i = 0; i < 3; i++) {
                numbers[i] = Randoms.pickNumberInRange(1, 9);
            }

//            System.out.println(Arrays.toString(numbers));

            playBall(numbers);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

            String start = Console.readLine();

            if (start.equals("2")) break;
            else if (!start.equals("1")){
                throw new IllegalArgumentException("the input number is neither 1 nor 2");
            }

        }

    }

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        playGame();
    }
}
