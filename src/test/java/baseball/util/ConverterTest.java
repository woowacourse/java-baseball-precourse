package baseball.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConverterTest {
	@Test
	public void convertToIntArr() throws Exception {
		//given
		String str = "1234567890";
		//when
		int[] result = Converter.convertToIntArr(str);
		//then
		assertArrayEquals(result, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
	}
}
