package baseball;

import java.util.ArrayList;

public class Judgement {
    public static int Judgement(ArrayList<Integer> computerNumbers, ArrayList<Integer> userNumbers){
        int strikeCount = 0;
        int ballCount = 0;

        for(int i = 0; i < 3; i++){
            if (computerNumbers.get(i) == userNumbers.get(i))
                strikeCount++;
        }

        if (strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 3;
        }

        for(int i = 0; i < 3; i++){
            if (userNumbers.contains(computerNumbers.get(i)))
                ballCount++;
        }

        ballCount = ballCount - strikeCount;

        if (ballCount == 0 && strikeCount ==0)
            System.out.print("낫싱");
        if (ballCount > 0)
            System.out.printf("%d볼 ", ballCount);
        if (strikeCount > 0)
            System.out.printf("%d스트라이크", strikeCount);
        System.out.println();

        return strikeCount;
    }
}