/**
 * 숫자야구 클래스
 *
 * @version           1.2 2019년 11월 29일 시작
 * @author            황성찬
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class baseball {
    public static ArrayList<Integer> nums = new ArrayList<>();

    public static ArrayList<Integer> userYou = new ArrayList<>();
    public static ArrayList<Integer> userComputer = new ArrayList<>();

    static void init(){
        final int MIN_NUM = 1;
        final int MAX_NUM = 10;

        for(int i = MIN_NUM; i < MAX_NUM; i++) {
            nums.add(i);
        }
    }

    static ArrayList<Integer> createRandomList(ArrayList<Integer> nums, int arrayLength){
        final int ITER_NUM = 3;

        Random rand = new Random();
        ArrayList<Integer> user = new ArrayList<>();

        for(int i = arrayLength; i > arrayLength - ITER_NUM; i--){
            int random_num = rand.nextInt(i);
            user.add(nums.get(random_num));
            nums.remove(random_num);
        }
        return user;
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

    static boolean attackResult(int strike, int ball){
        final int NOT_MATCHED = 0;
        final int OUT = 3;

        if (strike == OUT) {
            System.out.println(">> 3 스트라이크!! 아웃!!");
            return true;
        }

        if (strike != NOT_MATCHED && ball != NOT_MATCHED) {
            System.out.println(">> "+strike+" 스트라이크 "+ball+" 볼\n");
            return false;
        } else if (strike != NOT_MATCHED && ball == NOT_MATCHED){
            System.out.println(">> " +strike+" 스트라이크\n");
            return false;
        } else if (strike == NOT_MATCHED && ball != NOT_MATCHED) {
            System.out.println(">> " +ball+" 볼\n");
            return false;
        } else {
            System.out.println(">> 낫싱\n");
            return false;
        }

    }

    static boolean attackEnemy(ArrayList<Integer> user, ArrayList<Integer> attack){
        int strike = 0;
        int ball = 0;

        for (int i=0; i<user.size(); i++) {
            if (user.get(i) == attack.get(i)) {
                strike++;
            } else if (user.contains(attack.get(i))) {
                ball++;
            }
        }

        return attackResult(strike, ball);
    }

    public static void main(String[] args){

        init();

        userYou = createRandomList((ArrayList<Integer>) nums.clone(), nums.size());
        userComputer = createRandomList((ArrayList<Integer>) nums.clone(), nums.size());

        System.out.println("숫자 야구를 시작합니다. 당신의 숫자를 확인하세요.");
        System.out.println("당신의 숫자 : " + userYou);

        while (true) {
            System.out.print("공격합니다. 서로 다른 숫자 셋을 입력하세요. : ");
            if (attackEnemy(userComputer, createAttackList())) {
                System.out.println("승리!!!");
                System.exit(1);
            }

            ArrayList<Integer> attackList = createRandomList(
                    (ArrayList<Integer>) nums.clone(), userYou.size() );

            System.out.println("컴퓨터가 공격합니다. 컴퓨터가 공격한 숫자는 : " + attackList);
            if (attackEnemy(userYou, attackList)) {
                System.out.println("패배!!!");
                System.exit(1);
            }
        }

    }

}
