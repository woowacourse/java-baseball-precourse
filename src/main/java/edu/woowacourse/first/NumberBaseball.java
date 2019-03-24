package edu.woowacourse.first;

import java.util.HashSet;
import java.util.Random;

public class NumberBaseball {
  /*
   *
   */
  private int [] nums;

  public NumberBaseball() {
    nums = new int[3];
  }

  public void start(){
    setRandomNumbers();
  }

  private void setRandomNumbers(){
    Random rand = new Random();
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < 3; i++){
      int randNum = rand.nextInt(9) + 1;
      if (!set.contains(randNum)) {
        this.nums[i] = randNum;
        set.add(randNum);
      } else {
        i--;
      }
    }
  }
}
