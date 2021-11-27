package utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameUtils {
    public static List<Integer> generateAnswerNumberList() {
        List<Integer> newList = new ArrayList<>();
        boolean[] visited = new boolean[10];

        while (newList.size() < 3){
            Integer newNum = Randoms.pickNumberInRange(1, 9);

            if (visited[newNum]) continue;

            visited[newNum] = true;
            newList.add(newNum);
        }

        return newList;
    }

    public static int checkAnswerInput(List<Integer> input, List<Integer> answerNumbers) {
        int strikeCount = 0;
        int idx;
        for (idx = 0; idx < 3; idx++){
            if (!Objects.equals(input.get(idx), answerNumbers.get(idx))) break;
            strikeCount++;
        }
        return strikeCount;
    }

    public static boolean checkGameOver(int strikeCount) {
        if (strikeCount == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
