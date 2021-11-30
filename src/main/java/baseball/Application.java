package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        int playingStatus = 1;
        while(true){
            List<Integer> numberList = GameHelper.generateNumbers();
            playingStatus++;
            if(playingStatus==2){
                break;
            }
        }
    }
}
