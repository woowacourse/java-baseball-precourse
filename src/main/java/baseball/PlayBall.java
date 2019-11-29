/**
 * 게임 실행, 게임 진행을 모두 담당하는 클래스
 * 공격, 검사, 반복 기능이 모두 이루어진다.
 *
 * @version           2.0 2019년 11월 29일 14시
 * @author            황성찬
 */
package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayBall {

    static boolean attackResult(int strike, int ball) {
        final int NOT_MATCHED = 0;
        final int OUT = 3;

        if (strike == OUT) {
            System.out.println(">> 3 스트라이크!! 아웃!!");
            return true;
        }

        if ((strike != NOT_MATCHED) && (ball != NOT_MATCHED)) {
            System.out.println(">> " + strike + " 스트라이크 " + ball + " 볼\n");
            return false;
        } else if ((strike != NOT_MATCHED) && (ball == NOT_MATCHED)) {
            System.out.println(">> " + strike + " 스트라이크\n");
            return false;
        } else if ((strike == NOT_MATCHED) && (ball != NOT_MATCHED)) {
            System.out.println(">> " + ball + " 볼\n");
            return false;
        } else {
            System.out.println(">> 낫싱\n");
            return false;
        }
    }

    static boolean attackEnemy(CreateList user, ArrayList<Integer> attack){
        user.initScore();

        ArrayList<Integer> createdList = user.nums;

        for (int i=0; i<createdList.size(); i++) {
            if (createdList.get(i) == attack.get(i)) {
                user.setStrike(user.getStrike() + 1);
            } else if (createdList.contains(attack.get(i))) {
                user.setBall(user.getBall() + 1);
            }
        }

        return attackResult(user.getStrike(), user.getBall());
    }

    static ArrayList<Integer> createAttackList(){
        final int ATTACK_NUMBER = 3;

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> attack = new ArrayList<>();

        for(int i=0; i<ATTACK_NUMBER; i++){
            attack.add(sc.nextInt());
        }

        return attack;
    }

    static void run(CreateList userYou, CreateList userComputer){
        System.out.println("--숫자 야구 게임 시작--");
        System.out.println("당신의 숫자 : "+userYou.nums);

        while(true){
            System.out.print("당신의 공격입니다. 서로 다른 세 자리 숫자를 입력하세요. : ");
            if (PlayBall.attackEnemy(
                    userComputer, PlayBall.createAttackList())) {

                System.out.println("승리!!!");
                break;
            }


            ArrayList<Integer> attackList = new CreateList().nums;
            System.out.println("컴퓨터의 공격입니다. 컴퓨터가 공격한 숫자는 : " + attackList);
            if (PlayBall.attackEnemy(
                    userYou, attackList)) {

                System.out.println("패배!!!");
                break;
            }
        }
    }
}
