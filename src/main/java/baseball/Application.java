package baseball;

import static baseball.Judge.passNumberToJudge;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        int coin = 0;
        Defender defender = Defender.getInstance();
        Judge judge = passNumberToJudge(defender.getNumber() + "");
        while(coin==0 || coin == 1){
            if(coin == 1) {
                defender.changeNumber();
                judge.passNumberToJudge(defender.getNumber() + "");
            }

            while(!judge.flag) {
                System.out.print("숫자를 입력해주세요 : ");
                System.out.println(judge.judging(readLine()));

            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n"+
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            coin = Integer.parseInt(readLine());
        }
    }
}
