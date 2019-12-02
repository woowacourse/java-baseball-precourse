import java.util.Arrays;

public class Baseball {

  private int[] answer = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

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

  public int[] matchNumber(int inputNumber) {
    int first = inputNumber / 100;
    int second = inputNumber % 100 / 10;
    int third = inputNumber % 10;

    int[] score = {0, 0, 0};

    if (this.answer[first] != 0) {
      if (this.answer[first] == 1) {
        score[0]++;
      } else {
        score[1]++;
      }
    } else {
      score[2]++;
    }

    if (this.answer[second] != 0) {
      if (this.answer[second] == 2) {
        score[0]++;
      } else {
        score[1]++;
      }
    } else {
      score[2]++;
    }

    if (this.answer[third] != 0) {
      if (this.answer[third] == 3) {
        score[0]++;
      } else {
        score[1]++;
      }
    } else {
      score[2]++;
    }

    return score;
  }
}
