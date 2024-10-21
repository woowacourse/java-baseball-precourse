package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.InputException.validatesNumber;

public class Player {
  private final List<Integer> inputNumberList;

  public Player() {
    this.inputNumberList = new ArrayList<>();
  }

  public void playerInputNumber() {    // 사용자 입력 메서드
    System.out.print("숫자를 입력해주세요 : ");
    String input = Console.readLine();
    validatesNumber(input);

    inputNumberList.clear(); // 이전 입력값을 비우기
    for (char ch : input.toCharArray()) { // 입력받은 숫자를 List에 저장
      inputNumberList.add(Character.getNumericValue(ch));
    }
  }

  public List<Integer> getInputNumberList(){
    return this.inputNumberList;
  }

  // 게임 재시작 여부를 결정하는 메서드
  public String inputReplay(){
    String inputReplay = Console.readLine();

    if (!inputReplay.equals("1") && !inputReplay.equals("2")) {
      throw new IllegalArgumentException("잘못된 입력입니다. 1 또는 2를 입력하세요.");
    }
    return inputReplay;
  }
}