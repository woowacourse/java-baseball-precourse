package playBaseBall;
import java.util.HashSet;


/**
 * 생성된 난수에 중복된 숫자가 있는지 검사하는 클래스
 */
public class CheckDuplicate {
	
	/**
	 * 중복된 숫자가 없으면 생성된 난수를 반환한다
	 * @return int
	 */
	public static int makeRandomNumber() {
		int randomNumber = RandomUtils.nextInt(100, 999);
		if(isDuplicate(randomNumber)) {
			return makeRandomNumber();
		}
		return randomNumber;
	}

	/**
	 * 중복된 숫자가 없으면 true를 반환한다
	 * @param randomNum
	 * @return boolean
	 */
	private static boolean isDuplicate(int randomNum) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<3; i++) {
			set.add(randomNum % 10);
			randomNum /= 10;
		}
		
		if(set.size()==3) {
			return false;
		}
		return true;
	}
}
