package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        int coin = 0;
        Defender defender = Defender.getInstance();
        Judge judge = null;
        for(int test=0; test<3; test++){
            judge = judge.passNumberToJudge(defender.getNumber() + "");
            System.out.print("숫자를 입력해주세요 : ");
            System.out.println(judge.judging(readLine()));
        }

        //TODO(Attacker): 게임 시작 혹은 종료하기 (1/2)


    }
}
