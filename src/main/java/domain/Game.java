package domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Game {

    private List<Integer> answerNumbers;

    public Game() {
        reset();
    }

    private void reset() {
        List<Integer> newList = new ArrayList<>();
        boolean[] visited = new boolean[10];

        while (newList.size() < 3){
            Integer newNum = Randoms.pickNumberInRange(1, 9);

            if (visited[newNum]) continue;

            visited[newNum] = true;
            newList.add(newNum);
        }

        this.answerNumbers = newList;
    }

    public void start() {
        //TODO: should be removed
        System.out.println("answer : " + this.answerNumbers);

        System.out.print("숫자를 입력해주세요 : ");
        List<String> input = Arrays.asList(Console.readLine().split(""));

        int strikeCount = 0;
        int idx;
        for (idx = 0; idx < 3; idx++){
            if (!Objects.equals(input.get(idx), this.answerNumbers.get(idx).toString())) break;
            strikeCount++;
        }
        if (strikeCount == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
