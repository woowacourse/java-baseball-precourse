package baseball.game.service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import baseball.game.message.GuideMessage;

public class NumberCalculation {

	private static AtomicInteger strike;
	private static AtomicInteger ball;

	public static String checkInputNumber(int[] answerArr, int inputNumber) {

		strike = new AtomicInteger(0);
		ball = new AtomicInteger(0);

		int[] inputNumberArr = new int[3];
		splitNumbers(inputNumber, inputNumberArr);

		Set<Integer> numSet = new HashSet<>();
		countStrikeAndBall(answerArr, inputNumberArr, numSet);

		if (strike.get() == 3) {
			return GuideMessage.correctNumberMessage(ball.get(), strike.get());
		}
		return GuideMessage.wrongNumberMessage(ball.get(), strike.get());
	}

	private static void splitNumbers(int inputNumber, int[] inputNumberArr) {
		for (int i = 2; i >= 0; i--) {
			inputNumberArr[i] = inputNumber % 10;
			inputNumber /= 10;
		}
	}

	private static void countStrikeAndBall(int[] answerArr, int[] inputNumberArr, Set<Integer> numSet) {
		for (int i = 0; i < answerArr.length; i++) {
			countStrike(answerArr, inputNumberArr, i);
			addNumSet(answerArr[i], inputNumberArr[i], numSet);
		}

		ball.set(answerArr.length + inputNumberArr.length - numSet.size() - strike.get());
	}

	private static void countStrike(int[] answerArr, int[] inputNumberArr, int index) {
		if (answerArr[index] == inputNumberArr[index]) {
			strike.incrementAndGet();
		}
	}

	private static void addNumSet(int answerNum, int inputNum, Set<Integer> numSet) {
		numSet.add(answerNum);
		numSet.add(inputNum);
	}
}
