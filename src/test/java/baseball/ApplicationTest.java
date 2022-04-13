package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.model.Computer;
import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {

	@Test 
	void 컴퓨터_객체_랜덤번호_사이값_테스트() {
		Computer computer = new Computer();
		int computerNumber = computer.getNumber();
		assertThat(computerNumber).isBetween(0, 999);
	}
	
	@Test 
	void 컴퓨터_객체_랜덤번호_자릿수_테스트() {
		Computer computer = new Computer();
		int computerNumberLength = getNumberLength(computer.getNumber());
		assertEquals(3, computerNumberLength);
	}
	
	@Test
	void 문자열_인트타입_변환테스트() {
		String strNumber = "";
		Assertions.assertThatIllegalArgumentException()
		.isThrownBy(() -> validation1(strNumber));
	}
	
	@Test 
	void 자릿수_예외_테스트() {
		int userNumber = 0;
		Assertions.assertThatIllegalArgumentException()
			.isThrownBy(() -> validation2(userNumber));
	}
	
	@Test
	void 양수값체크_테스트() {
		int userNumber = -111;
		Assertions.assertThatIllegalArgumentException()
		.isThrownBy(() -> validation3(userNumber));
	}
	
	private void allValidation(String inputNumber) {
		validation1(inputNumber);
		validation2(stringToInt(inputNumber));
		validation3(stringToInt(inputNumber));
	}
	
	private void validation1(String strNumber) {
		try {
			Integer.parseInt(strNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
	private void validation2(int number) {
		if (getNumberLength(number) != 3) {
			throw new IllegalArgumentException();	
		}
	}
	private void validation3(int number) {
		if (number < 1) {
			throw new IllegalArgumentException();
		}
	}

	private int stringToInt(String strNumber) {
		return Integer.parseInt(strNumber);
	}
	private int getNumberLength(int number) {
		return String.valueOf(number).length();
	}
	
	
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
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
