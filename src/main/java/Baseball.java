import java.util.Arrays;

public class Baseball {

  private static final int STRIKE = 0;
  private static final int BALL = 1;
  private static final int OUT = 2;

  private int[] answer = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
  private int[] score = {0, 0, 0};

  public void generateAnswer() {
    int first;
    int second;
    int third;

    first = (int) (Math.random() * 9) + 1;

    do {
      second = (int) (Math.random() * 9) + 1;
    } while (first == second);

    do {
      third = (int) (Math.random() * 9) + 1;
    } while (first == third || second == third);

    Arrays.fill(this.answer, 0);

    this.answer[first] = 1;
    this.answer[second] = 2;
    this.answer[third] = 3;

  }

  private void checkScore(int number, int index) {
    if (this.answer[number] != 0) {
      if (this.answer[number] == index) {
        this.score[STRIKE]++;
      } else {
        this.score[BALL]++;
      }
    } else {
      this.score[OUT]++;
    }
  }

  public int[] matchNumber(int inputNumber) {
    int[] inputArray = {0, 0, 0};

    inputArray[0] = inputNumber / 100;
    inputArray[1] = inputNumber % 100 / 10;
    inputArray[2] = inputNumber % 10;

    Arrays.fill(this.score, 0);

    for (int i = 0; i < inputArray.length; i++) {
      checkScore(inputArray[i], i + 1);
    }

    return this.score;
  }
}
