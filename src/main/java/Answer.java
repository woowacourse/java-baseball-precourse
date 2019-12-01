import java.util.*;

public class Answer {
    static ArrayList<Integer> answerCreate() { // 정답이 될 랜덤 숫자를 만듦.
        Random ran = new Random();
		ArrayList<Integer> numbers = new ArrayList<>();
		int ten = ran.nextInt(9) + 1;		// 1~9 사이의 숫자 중 임의로 선택하여 10의 자리 숫자가 됨
		int one = ran.nextInt(9) + 1;		// 1~9 사이의 숫자 중 임의로 선택하여 1의 자리 숫자가 됨

		numbers.add(ran.nextInt(9) + 1);	// // 1~9 사이의 숫자 중 임의로 선택하여 100의 자리 숫자가 됨

		while(Check.checkCreateOverlap(numbers, ten)) { // 100의 자리와 10의 자리의 중복성 확인.
			ten = ran.nextInt(9) + 1;
		}

		numbers.add(ten);
		
		while(Check.checkCreateOverlap(numbers, one)) { //1의 자리와 100의 자리, 10의 자리의 중복성 확인.
			one = ran.nextInt(9) + 1;
		}

		numbers.add(one);

		return numbers;
	}
}