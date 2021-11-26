package baseball;

import java.util.Arrays;
import java.util.LinkedHashSet;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        LinkedHashSet<Integer> answer = BaseballUtil.generateAnswer(3);
        // System.out.println(Arrays.toString(answerSet.toArray()));

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        BaseballUtil.checkAnswer(answer, input);
    }
}
