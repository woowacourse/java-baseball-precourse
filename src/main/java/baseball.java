/**
 * 숫자야구 클래스
 *
 * @version           1.0 2019년 11월 27일 시작
 * @author            황성찬
 */
import java.util.ArrayList;
import java.util.Random;

public class baseball {
    /** user를 생성하기 위한 원본 ArrayList
     *  1~9의 원소를 가지고 있다.
     */
    public static ArrayList<Integer> nums = new ArrayList<>();

    /** 1~9까지 중복되지 않는 세 자리 숫자를 담는 ArrayList*/
    public static ArrayList<Integer> userYou = new ArrayList<>();
    public static ArrayList<Integer> userComputer = new ArrayList<>();

    /**
     *  ... user를 생성하기 위한 원본 ArrayList를 만드는 함수 ...
     *  ... 1~9까지의 숫자를 0~8까지의 index에 할당한다       ...
     *
     * @param nums user를 생성할 원본 ArrayList
     */
    static void numsSetting(ArrayList<Integer> nums){
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
     * @param   ar 1~9를 요소로 갖는 ArrayList
     * @return  user 중복되지 않은 세 숫자를 요소로 갖는 ArrayList
     */
    static ArrayList<Integer> userSetting(ArrayList<Integer> ar){
        final int LIST_LENGTH = ar.size();
        final int ITER_NUM = 3;

        Random rand = new Random();
        ArrayList<Integer> user = new ArrayList<>();

        for(int i = LIST_LENGTH; i > LIST_LENGTH - ITER_NUM; i--){
            int random_num = rand.nextInt(i);
            user.add(ar.get(random_num));
            ar.remove(random_num);
        }
        return user;
    }

    public static void main(String[] args){
        numsSetting(nums);

        userYou = userSetting((ArrayList<Integer>) nums.clone());
        userComputer = userSetting((ArrayList<Integer>) nums.clone()); // 아래는 테스트 코드

//        System.out.println(userYou);
//        System.out.println(userComputer);
//        System.out.println(nums);



    }

}
