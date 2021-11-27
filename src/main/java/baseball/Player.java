package baseball;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * <h1>숫자 야구게임 플레이어에 대한 인터페이스이다</h1>
 * 플레이어를 만들떄 이 인터페이스를 사용해 만든다
 *
 * @author yunki kim
 * @version 2.0
 * @since 2021-11-25
 */

public interface Player {

	/**
	 * 플레이어들이 고른 숫자야구게임에서 사용할 수를 가져온다
	 *
	 * @return String 플레이어 들이 고른 3자리 수
	 */
	String getSelectedNumber();

	/**
	 * 플레이어가 입력한 수를 검증한다
	 * 입력한 수의 각 자리수의 숫자가 서로 다르고 3자리 자연수 형태의 스트링이면 통과
	 *
	 * @param selectedNumber 유저가 입력한 수
	 * @return Boolean 플레이어가 입력한 수가 조건에 만족하면 true, 아니면 false
	 */
	static Boolean validateSelectedNumber(final String selectedNumber) {
		final String numberPattern = "^[1-9]*$";
		Boolean[] usedNumber = new Boolean[11];
		Arrays.fill(usedNumber, false);
		if(selectedNumber.length() != 3) {
			return false;
		}
		if(!Pattern.matches(numberPattern, selectedNumber)) {
			return false;
		}
		for(int idx = 0; idx < selectedNumber.length(); idx++) {
			int number = Character.getNumericValue(
				selectedNumber.charAt(idx));
			if(usedNumber[number]) {
				return false;
			}
			usedNumber[number] = true;
		}
		return true;
	}

	/**
	 * 플레이어가 입력한 숫자를 입력한다
	 * 만약 입력한 숫자가 3자리 자연수 형태의 스트링이 아니라면 IllegalArgumentException을 발생시키고
	 * 애플리케이션을 종료한다.
	 *
	 * @param selectedNumber 플레이어가 입력 숫자
	 * @throws IllegalArgumentException selectedNumber 파라미터가 3자리 자연수 형태의 스트링이 아닐 경우
	 */
	default void setSelectedNumber(final String selectedNumber) throws IllegalArgumentException {}
}
