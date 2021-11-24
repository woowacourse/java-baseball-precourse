package baseball;

public class Application {
    public static void main(String[] args) {
        int coin = 0;
        Defender defender =null;
        Judge judge = null;
        for(int test=0; test<3; test++){
            if (defender == null) {
                defender = Defender.getInstance();
            } else {
                defender.changeNumber();
            }

            judge = judge.passNumberToJudge(defender.getNumber() + "");
        }

        //TODO(Attacker): 3자리 숫자 입력하기
        //TODO(Attacker): 게임 시작 혹은 종료하기 (1/2)
        // TODO(Judge): Attacker(Player)의 숫자와 Defender 숫자 비교하기


    }
}
