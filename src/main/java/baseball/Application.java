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
