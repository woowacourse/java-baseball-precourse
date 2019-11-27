/**
 * NumberGenerator.java
 * 숫자야구를 위해 임의의 수를 생성하는 클래스
 *
 * @version 0.1
 * @author 안운장 (woonjangahn)
 */

import java.util.HashMap;
import java.util.Random;

public class NumberGenerator {
  private static final int DIGITS = 3;
  private HashMap<Integer, Integer> numberMap;
  private Random random;

  public NumberGenerator() {
    this.numberMap = new HashMap<>();
    this.random = new Random();
  }

  public HashMap<Integer, Integer> generateNumbers() {
    int randomNumber;
    for (int i = 0; i < DIGITS; i++) {
      randomNumber = pickRandomNumber();
      this.numberMap.put(randomNumber, i);
    }
    return this.numberMap;
  }

  private int pickRandomNumber() {
    int randomNumber;
    while (true) {
      randomNumber = this.random.nextInt(9) + 1;
      if (isNotPickedYet(randomNumber)) {
        return randomNumber;
      }
    }
  }

  private boolean isNotPickedYet(int pickedNumber) {
    return !this.numberMap.keySet().contains(pickedNumber);
  }


}
