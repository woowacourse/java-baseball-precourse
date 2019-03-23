import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

  public static int[] Input() throws IOException {
    boolean valid = false;
    String num = "";
    while (!valid) {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("숫자를 입력해주세요 : ");
      num = bf.readLine();
      //valid = isValid(num); valid는 맨 뒤에서 구현 예정
      valid = true; //우선은 정해진 값만 들어온다.
    }
    int[] userNumber = new int[3];
    for (int i = 0; i < 3; i++) {
      userNumber[i] = num.charAt(i) - '0';
    }

    return userNumber;
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

  public static boolean isValid(String inputNum) {

    return true;
  }
}
