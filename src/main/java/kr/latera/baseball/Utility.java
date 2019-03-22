package kr.latera.baseball;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Utility {

  /**
   * 정수 배열을 문자열로 반환
   *
   * @param arr 변환할 배열
   * @return ex. "[1, 2, 3] "
   */
  public static String intArrayToString(int[] arr) {
    return "[ " + Arrays.stream(arr)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(", ")) + " ]";
  }
}
