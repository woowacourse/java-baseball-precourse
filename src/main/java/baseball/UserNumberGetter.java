package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserNumberGetter {
	private static final int NUM_LENGTH = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private int[] userNumber = {0,};

	UserNumberGetter() {}

	public int[] getNumber(){
		getUserNumber();
		return userNumber;
	}

	public void getUserNumber(){
		System.out.print("숫자를 입력해 주세요 : ");

		String userStringNumber = Console.readLine();

		System.out.println(userStringNumber);

		if(!validateLength(userStringNumber)){
			throw new IllegalArgumentException();
		}

		if(!validateChar(userStringNumber)){
			throw new IllegalArgumentException();
		}

		for(int checkingPosition = 0; checkingPosition < userStringNumber.length(); checkingPosition++) {
			if (!validateDuplicated(checkingPosition, userStringNumber)) {
				throw new IllegalArgumentException();
			}
		}

		toIntArray(userStringNumber);

	}

	public void toIntArray(String userStringNumber){
		for(int i = 0; i < userStringNumber.length(); i++){
			userNumber[i] = Character.getNumericValue(userStringNumber.charAt(i));
		}
	}

	public boolean validateDuplicated(int checkingPosition, String userStringNumber){
		char checkChar = userStringNumber.charAt(checkingPosition);

		for(int i = ++checkingPosition; i < userStringNumber.length(); i++){
			char eachChar = userStringNumber.charAt(i);

			if(eachChar == checkChar){
				return false;
			}
		}
		return true;
	}

	public boolean validateChar(String userStringNumber){
		for(int i = 0; i < userStringNumber.length(); i++){
			char checkChar = userStringNumber.charAt(i);

			if(checkChar<'1'||checkChar>'9'){
				return false;
			}
		}
		return true;
	}

	public boolean validateLength(String userStringNumber){
		return userStringNumber.length() == NUM_LENGTH;
	}

}
