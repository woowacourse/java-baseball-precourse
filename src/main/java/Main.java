import java.util.Random;


public class Main {

  public static void main(String args[]) {
    boolean gameContinue = true;

    while (gameContinue) {
      gameContinue = playBaseball();
    }
  }

  public static boolean isDuplicate(int[] computerNumber, int i) {
    for (int j = 0; j < i; j++) {
      if (computerNumber[i] == computerNumber[j]) {
        return true;
      }
    }
    return false;
  }

  public static int[] createRandomNumber() {
    Random rand = new Random();
    int[] computerNumber = new int[3];
    for (int i = 0; i < 3; i++) {
      computerNumber[i] = rand.nextInt(9) + 1; // [1-9]
      if (isDuplicate(computerNumber, i)) {
        i--;
      }
    }
    return computerNumber;
  }

  public static int[] Input() {

    return null;
  }

  public static boolean playBaseball() {

    return true;
  }

  public static int countBall(int[] computerNum, int[] userNum) {

    return 0;
  }

  public static int countStrike(int[] computerNum, int[] userNum) {

    return 0;
  }

  public static void output(int strike, int ball) {

  }

  public static void output() {

  }

  public static boolean isRegame() {

    return true;
  }

  public static boolean isValid(int[] inputNum) {

    return true;
  }
}
