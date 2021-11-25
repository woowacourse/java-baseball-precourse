package baseball.util;

public class Converter {
	public static int[] convertToIntArr(String target) {
		int[] result = new int[target.length()];
		char[] targetChars = target.toCharArray();

		for (int i = 0; i < target.length(); i++) {
			result[i] = Character.getNumericValue(targetChars[i]);
		}

		return result;
	}
}
