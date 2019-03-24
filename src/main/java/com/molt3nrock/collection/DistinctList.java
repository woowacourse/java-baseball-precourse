package com.molt3nrock.collection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 중복되지 않는 숫자를 원소로하는 리스트.
 *
 * 중복되지 않는 숫자를 나타내기위한 자료 구조입니다.
 *
 * @param <T> 리스트의 원소 타입 제네릭 파라미터. {@code isConsecutive}를 구현하기 위한
 *            {@code DiscreteNumber}상속 제약이 있습니다.
 *
 * @see #isConsecutive
 */
public class DistinctList<T extends DiscreteNumber> {

  private List<T> list;

  public DistinctList(Stream<T> stream) {
    this.list = stream
        .distinct()
        .collect(Collectors.toList());
  }

  public int size() {

    return list.size();
  }

  public Stream<T> stream() {
    return list.stream();
  }

  public T get(int i) {
    return list.get(i);
  }

  /**
   * 구성 요소의 연속성 판단.
   *
   * 리스트 원소의 순서에는 상관없이 그것들이 연속된 숫자로 구성되어 있는지의 여부를 판단합니다.
   * 예를들어 {1,2,3}, {1,3,2}, {2,1,3}, {2,3,1}, {3,1,2}, {3,2,1} 모두 연속된것으로 판단합나다.
   *
   * @return boolean {@code true}이면 리스트의 원소가 연속된 {@code DiscreteNumber}으로 이루어져 있음을 나타내며,
   * {@code false}이면 모든 원소가 연속된 {@code DiscreteNumber}으로만 구성된것은 아님을 나타냅니다.
   *
   * @see DiscreteNumber
   */
  public boolean isConsecutive() {
    List<T> sortedList = list.stream().sorted().collect(Collectors.toList());
    int differenceSum = IntStream
        .range(0, sortedList.size() - 1)
        .map(i -> Math.abs(sortedList.get(i).intValue() - sortedList.get(i + 1).intValue()))
        .sum();
    return differenceSum == sortedList.size() - 1;
  }


  /**
   * 두 {@code DistinctList}를 결합한 {@code Stream}을 생성.
   *
   * @param other 결합할 {@code DistinctList}
   *
   * @return 자신과 {@code other} 가 결합된 {@code Stream}을 반환합니다.
   */
  public Stream<T> concat(DistinctList<T> other) {
    return Stream
        .concat(list.stream(), other.stream())
        .distinct();
  }

  public static <T extends DiscreteNumber> DistinctList<T> of(Stream<T> stream) {
    return new DistinctList<>(stream);
  }

  /**
   * 비어 있는 {@code DistinctList} 생성.
   *
   * @return 원소가 하나도 없는 {@code DistinctList}를 반환 합니다.
   */
  public static <T extends DiscreteNumber> DistinctList<T> empty() {
    return new DistinctList<>(Stream.empty());
  }
}

