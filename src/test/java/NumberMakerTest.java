import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberMakerTest {

	@Test
	void testTrue() {
		boolean testFlag = true;
		String randomNumber = NumberMaker.makeRandomNumber();

		if (randomNumber.length() != 3) {
			testFlag = false;
		} else if (randomNumber.contains("0")) {
			testFlag = false;
		}

		System.out.println(randomNumber);
		assertTrue(testFlag);
	}
}