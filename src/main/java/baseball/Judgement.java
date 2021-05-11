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

    public boolean hasPlace(List<Integer> computer, int placeIndex, int number) { // placeIndex 해주는 이유 : 컴퓨터는 0으로 시작함
        return computer.get(placeIndex) == number;
        // 같은 코드
//        if(computer.get(placeIndex) == number){
//            return true;
//        }
//
//        return false;
    }
}
