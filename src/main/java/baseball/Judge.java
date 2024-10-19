package baseball;

import java.util.List;

public class Judge {
	public String calculateResult(String input, List<Integer> computerNumbers) {
		int strikes = 0;
		int balls = 0;

		for(int i=0; i<input.length(); i++) {
			int num = Character.getNumericValue(input.charAt(i));
			if(computerNumbers.contains(num)) {
				if(computerNumbers.get(i) == num) {
					strikes++;
				} else {
					balls++;
				}
			}
		}

		if(strikes ==0 && balls == 0) {
			return "낫싱";
		}

		return formatResults(strikes, balls);
	}

	private String formatResults(int strikes, int balls) {
		StringBuffer result = new StringBuffer();
		if (balls > 0) {
			result.append(balls).append("볼 ");
		}

		if(strikes > 0) {
			result.append(strikes).append("스트라이크");
		}
		return result.toString().trim();
	}
}
