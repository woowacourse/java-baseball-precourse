/**
 * UserInput.java
 * 숫자야구에서 유저의 입력과 관련된 클래스
 *
 * @version 0.1
 * @author 안운장 (woonjangahn)
 */

import java.util.Scanner;

public class UserInput {
  private static final int DIGITS = 3;
  private static final int MAX_NUM = 999;
  private static final int MIN_NUM = 111;
  private Scanner scanner;

  public UserInput(Scanner scanner) {
    this.scanner = scanner;
  }

  public String getUserNumber() {
    while (true) {
      System.out.print("숫자를 입력해주세요: ");
      String number = this.scanner.nextLine();
      if (isCorrectlyFormatted(number)) {
        return number;
      }
    }
  }

  public boolean isRestartingGame() {
    while (true) {
      System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
      String choice = this.scanner.nextLine();
      if (choice.equals("1")) {
        return true;
      } else if (choice.equals("2")) {
        return false;
      }
    }
  }

  private boolean isCorrectlyFormatted(String number) {
    if ((number == null) || (number.length() != DIGITS)) {
      return false;
    }
    try {
      int parsedNum = Integer.parseInt(number);
      if ((parsedNum > MAX_NUM) || (parsedNum < MIN_NUM)) {
        return false;
      }
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
