package kr.latera.baseball;

import kr.latera.baseball.interfaces.INumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 테스트를 위한 숫자 생성기
 * 생성자에서 받은 배열을 {@link INumberGenerator#generateNumber }의 반환값으로 사용
 */
public class TestGeneartor implements INumberGenerator {

  private List<int[]> listNums = new ArrayList<>();
  private int currentIdx = 0;

  public TestGeneartor(int[] nums) {
    if (nums.length != NUMS_LENGTH) {
      throw new IllegalArgumentException("Argument's length(" + nums.length + ") doesn't equal " +
          INumberGenerator.NUMS_LENGTH);
    }
    listNums.add(nums);
  }

  public TestGeneartor(int[][] multipleNums) {
    for (int[] nums: multipleNums) {
      listNums.add(nums);
    }
  }

  @Override
  public int[] generateNumber() {
    if (currentIdx == listNums.size()) {
      throw new IllegalStateException("There are no numbers to generate");
    }
    return listNums.get(currentIdx++);
  }

  private Integer[] convertArray(int[] nums) {
    return Arrays.stream(nums).boxed().toArray(Integer[]::new);
  }
}
