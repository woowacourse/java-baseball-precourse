package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Game {
    public void play(){
        Computer computer = new Computer();
        Judgement judgement = new Judgement();
        User user = new User();
        ArrayList<Integer> computerNumbers = new ArrayList<Integer>();
        ArrayList<Integer> userNumbers = new ArrayList<Integer>();
        int strikeCount = 0;
        int retryOrExitFlag = 3;

        computerNumbers = computer.numberGenerator();

        while (true) {
            if (retryOrExitFlag == 2)
                return;
            if (retryOrExitFlag == 1) {
                computerNumbers = computer.numberGenerator();
                retryOrExitFlag = 3;
            }

            userNumbers = user.numberGenerator();
            strikeCount = judgement.Judgement(computerNumbers, userNumbers);
            if (strikeCount == 3){
                System.out.println(Message.CHOICE_QUIT_RESTART);
                retryOrExitFlag = Integer.parseInt(Console.readLine());
                Validation.isRightChoose(retryOrExitFlag);
            }
        }
    }
}