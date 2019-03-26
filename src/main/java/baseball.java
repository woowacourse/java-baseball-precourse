import java.util.*;

/**
 * @version 1.00 2019년 3월 28일까지
 * @author hoonha
 */

public class baseball {

    /* 숫자 자릿수 선언 */
    private static final int DIGIT = 3;

    /* 중복 숫자를 줄이는 방법 LinkedHashSet 사용 입력 순서로 추가 */
    private static Set<String> com = new LinkedHashSet<>();

    /* 컴퓨터 Set 숫자를 저장할 배열 */
    private static String[] com_Array = new String[DIGIT];


    /* 컴퓨터 임의의 3자리의 수를 선택하는 메소드 */
    private static void com_Create_Number(){
        Random rand = new Random();

        /* 숫자가 중복되어도 3자리 숫자를 생성 */
        for (int i = 0; com.size() < DIGIT; i++){
            com.add(String.valueOf(rand.nextInt(9)+1));
        }
    }

    /* 임의의 숫자 3자리를 배열에 저장 메소드 */
    private static void getCom_Array(){
        com_Create_Number();
        Iterator<String> iterator = com.iterator();
        /* 컴퓨터 임의의 수를 배열에 넣기 위한 변수 */
        int k= 0;

        while(iterator.hasNext()){
            com_Array[k++] = iterator.next();
        }
    }

    public static void main(String[] args){

    }
}

