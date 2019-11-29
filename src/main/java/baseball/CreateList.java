/**
 * 1~9 중 서로 다른 숫자로 이루어진
 * 세 자리 숫자를 생성해주는 클래스
 * @version           2.0 2019년 11월 29일 14시
 * @author            황성찬
 */
package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CreateList {
    ArrayList<Integer> nums = new ArrayList<>();

    final int ITER_NUMS = 3;

    CreateList(){
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>(
                Arrays.asList(1,2,3,4,5,6,7,8,9));

        int LIST_SIZE = list.size();
        int random_num = 0;
        for(int i = LIST_SIZE; i > LIST_SIZE - ITER_NUMS; i--){
            random_num = rand.nextInt(i);
            this.nums.add(list.get(random_num));
            list.remove(random_num);
        }
    }
}
