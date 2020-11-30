package baseball;

import utils.RandomUtils;

public class Game {



    // 1~9사이의 3자리 랜덤 숫자 생성
    public static String makeGameNumber(){
        String gameNumber = "";
        int countLength = 0;

        while (countLength < 3) {
            int randomNumber = RandomUtils.nextInt(1, 9);

            if (!gameNumber.contains(String.valueOf(randomNumber))) {
                gameNumber += randomNumber;
                countLength++;
            }
        }
        return gameNumber;
    }
}
