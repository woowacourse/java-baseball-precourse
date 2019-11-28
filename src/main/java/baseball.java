/**
 * 숫자야구 클래스
 *
 * @version           1.1 2019년 11월 28일 시작
 * @author            황성찬
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class baseball {
    /** user를 생성하기 위한 원본 ArrayList
     *  1~9의 원소를 가지고 있다.
     */
    public static ArrayList<Integer> nums = new ArrayList<>();

    /** 1~9까지 중복되지 않는 세 자리 숫자를 담는 ArrayList*/
    public static ArrayList<Integer> userYou = new ArrayList<>();
    public static ArrayList<Integer> userComputer = new ArrayList<>();

    /**
     *  ... user와 AttackList를 생성하기 위한 원본 ArrayList를 만드는 함수 ...
     *  ... 1~9까지의 숫자를 0~8까지의 index에 할당한다                   ...
     */
    static void init(){
        final int MIN_NUM = 1;
        final int MAX_NUM = 10;

        for(int i = MIN_NUM; i < MAX_NUM; i++) {
            nums.add(i);
        }
    }


    /**
     *  ... 중복되지 않은 세 숫자를 요소로 갖는 ArrayList를 생성하는 함수 ...
     *  ... 매개변수로 넘겨받은 ArrayList의 요소에 Random으로 접근한다   ...
     *  ... 해당 요소를 return할 ArrayList에 add하고 remove한다       ...
     *
     * @param   nums 1~9를 요소로 갖는 ArrayList
     * @param   arrayLength 리턴받고 싶은 List의 size
     * @return  user 중복되지 않은 세 숫자를 요소로 갖는 ArrayList
     */
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

    /**
     *
     * @return
     */
    static ArrayList<Integer> createAttackList(){
        final int ATTACK_NUMBER = 3;

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> attack = new ArrayList<>();

        for(int i=0; i<ATTACK_NUMBER; i++){
            attack.add(sc.nextInt());
        }

        return attack;
    }

    /**
     *  ... attackEnemy에서 호출되는 함수이다 ...
     *  ... strike와 ball에 따라 알맞는 힌트를 제공한다 ...
     *
     * @param strike attackEnemy에서 받은 strike에 따라 힌트를 제공한다
     * @param ball   attackEnemy에서 받은 ball에 따라 힌트를 제공한다
     */
    static void attackResult(int strike, int ball){
        final int NOT_MATCHED = 0;
        final int OUT = 3;

        if (strike == OUT) {
            System.out.println("3 스트라이크!! 아웃!!");
            System.exit(0);
        }

        if (strike != NOT_MATCHED && ball != NOT_MATCHED) {
            System.out.println(strike+" 스트라이크 "+ball+" 볼");
        } else if (strike != NOT_MATCHED && ball == NOT_MATCHED){
            System.out.println(strike+" 스트라이크");
        } else if (strike == NOT_MATCHED && ball != NOT_MATCHED) {
            System.out.println(ball+" 볼");
        } else if (strike == NOT_MATCHED && ball == NOT_MATCHED) {
            System.out.println("낫싱");
        }
    }

    /**
     * ... user와 attack에 같은 숫자가 있는지 검사한다 ...
     * ... 같은 인덱스에 같은 숫자가 있다면 strike를 1 증가시킨다 ...
     * ... 다른 인덱스에 같은 숫자가 있다면 ball을 1 증가시킨다 ...
     * ... strike와 ball을 attackResult에 넘겨줘서 알맞는 힌트를 제공한다 ...
     *
     * @param user 공격 당하는 세 자리 숫자 1~9까지 서로 다른 숫자로 이루어졌다.
     * @param attack 공격 당하는 세 자리 숫자 1~9까지 서로 다른 숫자로 이루어졌다.
     */
    static void attackEnemy(ArrayList<Integer> user, ArrayList<Integer> attack){
        int strike = 0;
        int ball = 0;

        for (int i=0; i<user.size(); i++) {
            if (user.get(i) == attack.get(i)) {
                strike++;
            } else if (user.contains(attack.get(i))) {
                ball++;
            }
        }

        attackResult(strike, ball);
    }

    public static void main(String[] args){
        init();

        userYou = createRandomList((ArrayList<Integer>) nums.clone(), nums.size());
        userComputer = createRandomList((ArrayList<Integer>) nums.clone(), nums.size());

        // 위에는 첫번째 커밋

        System.out.println("숫자 야구를 시작합니다. 당신의 숫자를 확인하세요.");
        System.out.println("당신의 숫자 : " + userYou);
        System.out.println("콤퓨타 숫자 : " + userComputer);
        System.out.print("공격합니다. 서로 다른 숫자 셋을 입력하세요. : ");



        attackEnemy(userComputer, createAttackList());
        ArrayList<Integer> attackList = createRandomList(
                                        (ArrayList<Integer>) nums.clone(), userYou.size() );

        System.out.println("컴퓨터가 공격합니다. 컴퓨터가 공격한 숫자는 : " + attackList);
        attackEnemy(userYou, attackList);


    }

}
