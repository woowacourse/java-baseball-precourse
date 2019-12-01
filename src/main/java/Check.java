import java.util.*;

public class Check {
    public static boolean checkCreateOverlap(ArrayList<Integer> one, int two) { //랜덤 숫자를 제작할 때의 중복성 체크. true 반환 시, 중복이 있음.
		for(int i = 0; i < one.size(); i++) {
			if(one.get(i) == two) {
				return true;
			} else {
				continue;
			}
		}
		return false;
	}

	public static boolean checkOverlap(ArrayList<Integer> one) { //입력값에서 중복성 체크. true 반환 시, 중복이 있음.
		if(one.get(0) != one.get(1)
			&& one.get(0) != one.get(2)
			&& one.get(1) != one.get(2)) {
				return false;
		} else {
			return true;
		}
	}
}