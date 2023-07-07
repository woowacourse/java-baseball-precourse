package baseball;

import java.util.Random;

public class QuestionMaker {
	Random rd = new Random();

	public void makeQuestion() {
		System.out.print(rd.nextInt(9) + 1);
		System.out.print(rd.nextInt(9) + 1);
		System.out.print(rd.nextInt(9) + 1);
	}
}
