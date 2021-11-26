package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        ArrayList<Integer> computerNumbers = new ArrayList<Integer>();
        ArrayList<Integer> userNumbers = new ArrayList<Integer>();
        int strikeCount = 0;
        int retryOrExitFlag = 3;

        computerNumbers = ComputerNumbers.ComputerNumbers();

        while (true) {
            if (retryOrExitFlag == 2)
                return;
            if (retryOrExitFlag == 1) {
                computerNumbers = ComputerNumbers.ComputerNumbers();
                retryOrExitFlag = 3;
            }

            userNumbers = UserNumbers.UserNumbers();
            strikeCount = Judgement.Judgement(computerNumbers, userNumbers);
            if (strikeCount == 3){
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                retryOrExitFlag = Integer.parseInt(Console.readLine());
            }
        }
    }
}
