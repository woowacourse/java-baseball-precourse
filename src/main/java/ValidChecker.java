
public class ValidChecker {

	public static boolean isValidMyNum(int myNum) {
		if(myNum / 100 == 0 || myNum / 1000 > 1) {
			return false;
		}
		
		if(myNum % 10 == (myNum / 10) % 10 || myNum % 10 == myNum / 100 || myNum / 100 == (myNum / 10) % 10) {
			return false;
		}
		return true;
	}

	public static boolean isValidGameMode(int gameMode) {
		if(gameMode != 1 && gameMode != 2) {
			return false;
		}
		return true;
	}

}
