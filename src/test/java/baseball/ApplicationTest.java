package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.model.Computer;
import baseball.model.User;
import baseball.play.Validation;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {

	@Test 
	void 컴퓨터_객체_랜덤번호_사이값_테스트() {
		int computerNumber = Randoms.pickNumberInRange(0, 999);
		assertThat(computerNumber).isBetween(0, 999);
	}
	
	@Test 
	void 컴퓨터_객체_랜덤번호_자릿수_테스트() {
		int computerNumberLength = getNumberLength(Randoms.pickNumberInRange(0, 999));
		assertEquals(3, computerNumberLength);
	}
	
	@Test
	void 문자열_인트타입_변환테스트() {
		String strNumber = "";
		Assertions.assertThatIllegalArgumentException()
		.isThrownBy(() -> typeNoMatch(strNumber));
	}
	
	@Test 
	void 자릿수_예외_테스트() {
		int inputNumber = 0;
		Assertions.assertThatIllegalArgumentException()
			.isThrownBy(() -> digitNoMatch(inputNumber));
	}
	
	@Test
	void 양수값체크_테스트() {
		int inputNumber = -111;
		Assertions.assertThatIllegalArgumentException()
		.isThrownBy(() -> minimumNumberCheck(inputNumber));
	}
	
	@Test
	void 중복된_숫자입력() {
		String inputNumber = "113";
		Assertions.assertThatIllegalArgumentException()
		.isThrownBy(() -> duplicateNumber(inputNumber));
	}
	
	@Test
	void 숫자0은_안되도록() {
		String inputNumber = "123";
		Assertions.assertThatIllegalArgumentException()
		.isThrownBy(() -> prohibitZero(inputNumber));
	}
	
	private void allValidation(String inputNumber) {
		new Validation(inputNumber);
	}
	
	private void typeNoMatch(String strNumber) {
		try {
			Integer.parseInt(strNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
	private void digitNoMatch(int number) {
		if (getNumberLength(number) != 3) {
			throw new IllegalArgumentException();	
		}
	}
	private void minimumNumberCheck(int number) {
		if (number < 1) {
			throw new IllegalArgumentException();
		}
	}
	private void duplicateNumber(String inputNumber) {
		String[] numbers = inputNumber.split("");

		for (String number : numbers) {
			if (inputNumber.indexOf(number) !=
					inputNumber.lastIndexOf(number)) {
				//예외
				throw new IllegalArgumentException();
			}
		}
	}
	
	private void prohibitZero(String inputNumber) {
		if (inputNumber.contains("0")) {
			throw new IllegalArgumentException();
		}
	}

	private int getNumberLength(int number) {
		return String.valueOf(number).length();
	}
	
	
	@Test 
	void 컴퓨터숫자와_던진볼_스크라이크_체크() {
		String inputNumber = "123";
		User user = new User(inputNumber);
		Computer computer = new Computer();
		pitchCheck(computer, user);
	}
	
	public void pitchCheck(Computer computer, User user) {
		String computerNumber = computer.getNumber();
		for(int i = 0; i < user.getNumbers().length; i++) {
			String value = user.getNumbers()[i];
			if (computerNumber.indexOf(value) == -1) {
				System.out.println("N");
				continue;
				// NOT
			}
			if (computerNumber.indexOf(value) == i) {
				System.out.println("ST");
				continue;
				// ST
			}
			if (computerNumber.indexOf(value) != i) {
				System.out.println("B");
				continue;
				// BALL
			}
		}
	}

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> allValidation("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    } 
    
}
