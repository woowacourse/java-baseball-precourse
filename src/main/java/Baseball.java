/**
 * Baseball.java
 * 숫자야구 게임 실행/종료용 클래스
 *
 * @version 0.1
 * @author 안운장 (woonjangahn)
 */

import java.util.HashMap;
import java.util.Scanner;

public class Baseball {
  private static final int DIGITS = 3;
  private Scanner scanner;
  private UserInput userInput;

  public Baseball() {
    this.scanner = new Scanner(System.in);
    this.userInput = new UserInput(this.scanner);
  }

  public void start() {
    NumberGenerator numberGenerator =  new NumberGenerator();
    HashMap<Integer, Integer> numberMap = numberGenerator.generateNumbers();
    NumberComparator numberComparator = new NumberComparator(numberMap);

    System.out.println("정답: " + numberMap.toString()); // for test

    while (true) {
      String number = this.userInput.getUserNumber();
      numberComparator.setInputNumber(number);
      numberComparator.resetScoreboard();
      numberComparator.compareNumbers();
      if (numberComparator.isThreeStrikes()) {
        System.out.println(DIGITS + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        break;
      }
      numberComparator.printScoreboard();
    }
    askToRestart();
  }

  public void askToRestart() {
    if (this.userInput.isRestartingGame()) {
      start();
    }
  }
}
