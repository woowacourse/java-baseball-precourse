
/**
 * 유효성 검사하는 클래스
 * 
 * @version			1.00 2019년 3월 24일
 * @author 			Wonseok Choi
 */
public class ValidChecker {

	
	/**
	 * myNum 유효성 검사
	 * 
	 * @param myNum
	 * @return	isValid
	 */
	public static boolean isValidMyNum(int myNum) {
		if(myNum / 100 == 0 || myNum / 1000 > 1) {
			return false;
		}
		
		if(myNum % 10 == (myNum / 10) % 10 || myNum % 10 == myNum / 100 || myNum / 100 == (myNum / 10) % 10) {
			return false;
		}
		return true;
	}

	/**
	 * gameMode 유효성 검사
	 * 
	 * @param gameMode
	 * @return	isValid
	 */
	public static boolean isValidGameMode(int gameMode) {
		if(gameMode != 1 && gameMode != 2) {
			return false;
		}
		return true;
	}

}
