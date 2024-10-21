package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Computer {
  private List<Integer> randomNumberList;

  public Computer() {
    this.randomNumberList = generateRandomNumberList();
  }

  private List<Integer> generateRandomNumberList() {
    Set<Integer> notDuplicatedNumbers = new HashSet<>();

    while (notDuplicatedNumbers.size() < 3) {
      int num = Randoms.pickNumberInRange(1, 9); // 1 ~ 9 난수 생성

      notDuplicatedNumbers.add(num);
    }

    return new ArrayList<>(notDuplicatedNumbers);
  }


  public List<Integer> getRandomNumberList() {
    return this.randomNumberList;
  }

  public void resetRandomNumberList() {
    this.randomNumberList = generateRandomNumberList();
  }
}