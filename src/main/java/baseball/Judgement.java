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
            System.out.println(Message.THREE_STRIKE);
            System.out.println(Message.GAME_QUIT);
            return 3;
        }

        for(int i = 0; i < 3; i++){
            if (userNumbers.contains(computerNumbers.get(i)))
                ballCount++;
        }

        ballCount = ballCount - strikeCount;

        if (ballCount == 0 && strikeCount ==0)
            System.out.print(Message.NOTHING);
        if (ballCount > 0)
            System.out.printf("%d" + Message.BALL, ballCount);
        if (strikeCount > 0)
            System.out.printf("%d" + Message.STRIKE, strikeCount);
        System.out.println();

        return strikeCount;
    }
}