package baseball;

import java.util.List;

public class Judgement {
    public int correctCount(List<Integer> computer, List<Integer> player) {
        int result = 0;
        for (int i = 0; i < player.size(); i++) {
            int playerNumber = player.get(i);
            if (computer.contains(playerNumber)) { //가지고 있다면
                result++; //result = result + 1
            }

        }
        return result;
    }

    public boolean hasPlace(int place, int number) {
        return false;
    }
}
