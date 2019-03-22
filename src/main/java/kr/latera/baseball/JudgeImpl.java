package kr.latera.baseball;

import kr.latera.baseball.interfaces.IJudge;
import kr.latera.baseball.interfaces.INumberGenerator;

public class JudgeImpl implements IJudge {

  private INumberGenerator numberGenerator;
  private int[] nums;

  public JudgeImpl(INumberGenerator generator) {
    numberGenerator = generator;
  }

  @Override
  public void init() {
    nums = numberGenerator.generateNumber();
  }

  @Override
  public boolean isValidInput(int[] input) {
    // 길이 검사
    if (input.length != INumberGenerator.NUMS_LENGTH) {
      return false;
    }

    // 중복 검사
    for (int i = 0; i < input.length; i++) {
      if (isExistsExcept(input, input[i], i)) {
        return false;
      }
    }

    // 벙위 검사
    for (int i : input) {
      if (i < INumberGenerator.MIN_FOR_EACH_NUM || i > INumberGenerator.MAX_FOR_EACH_NUM) {
        return false;
      }
    }

    return true;
  }

  @Override
  public int checkStrike(int[] input) throws IllegalArgumentException {
    if (!isValidInput(input)) {
      throw new IllegalArgumentException("Invalid input: " + Utility.intArrayToString(input));
    }

    int cntStrike = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == input[i]) {
        cntStrike++;
      }
    }

    return cntStrike;
  }

  @Override
  public int checkBall(int[] input) throws IllegalArgumentException {
    if (!isValidInput(input)) {
      throw new IllegalArgumentException("Invalid input: " + Utility.intArrayToString(input));
    }

    int cntBall = 0;

    for (int i = 0; i < nums.length; i++) {
      if (isExistsExcept(nums, input[i], i)) {
        cntBall++;
      }
    }

    return cntBall;
  }

  /**
   * 배열에서 특정 숫자가 인자로 명시된 인덱스 이외의 다른 위치에 나타는지 확인
   * @param nums 탐색할 숫자 배열
   * @param target 배열의 각 원소와 비교할 숫자
   * @param exceptIdx 탐색에서 제외할 인덱스
   * @return nums[exceptIdx] 이외에 nums[exceptIdx]가 나타나는 경우 true, 아니면 false
   */
  private boolean isExistsExcept(int[] nums, int target, int exceptIdx) {
    for (int i = 0; i < nums.length; i++) {
      if (i == exceptIdx) { continue; }
      if (nums[i] == target) { return true; }
    }
    return false;
  }
}
