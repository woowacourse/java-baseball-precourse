package baseball;

import java.util.ArrayList;

public class GameCycle {
    private ArrayList<Integer> value = new ArrayList<>(Application.LENGTH);

    //사용자의 임의의 수를 입력받는 함수.
    public void GameStart(int answer) {
        MakeNumber m = new MakeNumber(answer);
        for (Integer a : m.GetTarget()) {
            System.out.print(a);
        }

    }
}