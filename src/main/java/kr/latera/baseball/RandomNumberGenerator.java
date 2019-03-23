package kr.latera.baseball;

import kr.latera.baseball.interfaces.INumberGenerator;

import java.util.Random;

public class RandomNumberGenerator implements INumberGenerator {

  private Random rand = new Random();

  @Override
  public int[] generateNumber() {
    int[] nums = new int[NUMS_LENGTH];

    for (int i = 0; i < NUMS_LENGTH; i++) {
      nums[i] = getRandomNumber();
      while (isDuplicate(nums, i - 1, nums[i])) {
        nums[i] = getRandomNumber();
      }
    }

    return nums;
  }

  /**
   * 숫자 배열의 일부에 특정 숫자의 존재 여부를 확인
   *
   * @param nums   숫자 배열
   * @param offset 배열의 범위를 특정하는 오프셋. nums[:offset+1]
   * @param comp   존재 여부를 왁인할 숫자
   * @return nums[0] ~ nums[offset] 범위에 comp가 존재하면 true, 아닌 경우 false
   */
  private boolean isDuplicate(int[] nums, int offset, int comp) {
    for (int i = 0; i <= offset; i++) {
      if (nums[i] == comp) {
        return true;
      }
    }
    return false;
  }

  private int getRandomNumber() {
    return rand.nextInt(MAX_FOR_EACH_NUM - 1) + MIN_FOR_EACH_NUM;
  }
}
