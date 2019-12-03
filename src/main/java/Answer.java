/**
 * 클래스 이름       Answer
 * 버전 정보        1.0
 * 날짜            2019.12.03
 * 저작권          joi0104
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Answer{
	int[] answerNum;
	
	Answer(){
		answerNum = new int[3];
	}
	
	/*랜덤한 정답값 생성*/
	public int[] createAnswer(){
		ArrayList<Integer> numberList = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Random random = new Random();
        for (int i = 0; i < 3; i++){ 
            int index = random.nextInt(numberList.size());
            answerNum[i] = numberList.get(index);                 //ArrayList에서 랜덤한 값 하나 꺼내기
            numberList.remove(index);                             //꺼낸 값 ArrayList에서 삭제하기
        }
        return answerNum;
	}
}
