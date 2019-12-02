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

}
