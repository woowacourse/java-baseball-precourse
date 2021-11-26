package baseball;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        ArrayList<Integer> answer = BaseballUtil.generateAnswer(3);
        HashMap<String, Integer> score = new HashMap<>();
        // System.out.println(Arrays.toString(answer.toArray()));

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            BaseballUtil.countScore(answer, input, score);

            if(score.get("strike") == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
