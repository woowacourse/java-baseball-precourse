/**
 * NumberComparator.java
 * NumberGenerator에서 생성된 임의의 수와
 * UserInput에서 받아온 사용자 입력의 수를 비교하는 클래스
 *
 * @version 0.1
 * @author 안운장 (woonjangahn)
 */

import java.util.HashMap;

public class NumberComparator {
  private static final int DIGITS = 3;
  private HashMap<Integer, Integer> generatedNumber;
  private HashMap<String, Integer> scoreboard;
  private String inputNumber;

  public NumberComparator(HashMap<Integer, Integer> generatedNumber) {
    this.generatedNumber = generatedNumber;
    this.scoreboard = new HashMap<>();
    this.inputNumber = null;
  }

  public void setInputNumber(String inputNumber) {
    this.inputNumber = inputNumber;
  }

  public void compareNumbers() {
    for (int i = 0; i < this.inputNumber.length(); i++) {
      compareDigit(this.inputNumber.charAt(i), i);
    }
  }

  public boolean isThreeStrikes() {
    return this.scoreboard.get("strike") == DIGITS;
  }

  public void resetScoreboard() {
    this.scoreboard.put("strike", 0);
    this.scoreboard.put("ball", 0);
    this.scoreboard.put("nothing", 0);
  }

  public void printScoreboard() {
    if (this.scoreboard.get("strike") > 0) {
      System.out.print(this.scoreboard.get("strike") + " 스트라이크 ");
    }
    if (this.scoreboard.get("ball") > 0) {
      System.out.print(this.scoreboard.get("ball") + " 볼");
    }
    if (this.scoreboard.get("nothing") == DIGITS) {
      System.out.print("낫싱");
    }
    System.out.println();
  }

  private void increaseScore(String key) {
    this.scoreboard.put(key, this.scoreboard.get(key) + 1);
  }

  private void compareDigit(char digit, int index) {
    int parsedDigit = Character.getNumericValue(digit);
    if (this.generatedNumber.get(parsedDigit) == null) {
      increaseScore("nothing");
    } else if (this.generatedNumber.get(parsedDigit) == index) {
      increaseScore("strike");
    } else {
      increaseScore("ball");
    }
  }
}
