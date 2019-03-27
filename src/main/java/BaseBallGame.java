import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaseBallGame {

  List<Integer> baseballNum;

  BaseBallGame() {
    baseballNum = getNum3();
  }

  private List<Integer> getNum3() {
    ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    Collections.shuffle(arr);
    return arr.subList(0, 3);
  }

  private List<Integer> get3() {
    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    return new ArrayList<Integer>(
        Arrays.asList(num / 100, num % 100 / 10, num % 10));
  }

  private int strikeNum(List<Integer> yN) {
    int strike = 0;
    if (baseballNum.get(0).equals(yN.get(0))) {
      strike++;
    }
    if (baseballNum.get(1).equals(yN.get(1))) {
      strike++;
    }
    if (baseballNum.get(2).equals(yN.get(2))) {
      strike++;
    }
    return strike;
  }

  private int ballNum(List<Integer> yN) {
    int ball = 0;
    if (baseballNum.get(0).equals(yN.get(1)) || baseballNum.get(0).equals(yN.get(2))) {
      ball++;
    }
    if (baseballNum.get(1).equals(yN.get(0)) || baseballNum.get(1).equals(yN.get(2))) {
      ball++;
    }
    if (baseballNum.get(2).equals(yN.get(0)) || baseballNum.get(2).equals(yN.get(1))) {
      ball++;
    }
    return ball;
  }

  private boolean tellAns(int s, int b) {
    if (s == 0 && b == 0) {
      System.out.println("낫싱");
    } else if (b == 0) {
      System.out.printf("%d 스트라이크\n", s);
    } else if (s == 0) {
      System.out.printf("%d 볼\n", b);
    } else {
      System.out.printf("%d 스트라이크 %d 볼\n", s, b);
    }
    boolean isEnd = false;
    if (s == 3) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      isEnd = true;
    }
    return isEnd;
  }

  public void play() {
    boolean end = false;
    while (!end) {
      List<Integer> yourNum = get3();
      int strike = strikeNum(yourNum);
      int ball = ballNum(yourNum);
      end = tellAns(strike, ball);
    }
  }
}
