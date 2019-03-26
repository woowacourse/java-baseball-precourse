import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {

	@Test
	void isValidNumbers() {
		boolean flag = true;
		String[] strArr = {"012", "12", "34", "abc", "3a", ""};

		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
			flag = NumberValidator.isValidNumbers(strArr[i]);
		}

		assertFalse(flag);
	}
}
