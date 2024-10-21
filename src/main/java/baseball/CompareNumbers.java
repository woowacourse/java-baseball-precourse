package baseball;

import java.util.List;

public class CompareNumbers {
  private boolean gameOver;

  public void compareNumbers(Player player, Computer computer) {
    List<Integer> randomNumberList = computer.getRandomNumberList();
    player.playerInputNumber(); // 플레이어가 숫자를 입력
    List<Integer> playerNumberList = player.getInputNumberList();

    int strikes = calculateStrikes(randomNumberList, playerNumberList);
    int balls = calculateBalls(randomNumberList, playerNumberList);

    // 결과 출력
    if (strikes == 0 && balls == 0) {
      System.out.println("낫싱");
    } else if (strikes > 0 && balls > 0) {
      System.out.println(balls + "볼 " + strikes + "스트라이크");
    } else if (strikes > 0) {
      System.out.println(strikes + "스트라이크");
    } else {
      System.out.println(balls + "볼");
    }

    // 3 스트라이크인 경우 게임 종료
    if (strikes == 3) {
      printGameOverMessage();
      gameOver = true;
    } else {
      gameOver = false;
    }
  }

  private int calculateStrikes(List<Integer> randomNumberList, List<Integer> playerNumberList) {
    int strikes = 0;

    for (int i = 0; i < randomNumberList.size(); i++) {
      if (randomNumberList.get(i).equals(playerNumberList.get(i))) {
        strikes++;
      }
    }

    return strikes;
  }

  private int calculateBalls(List<Integer> randomNumberList, List<Integer> playerNumberList) {
    int balls = 0;

    for (int i = 0; i < randomNumberList.size(); i++) {
      if (randomNumberList.contains(playerNumberList.get(i)) && !randomNumberList.get(i).equals(playerNumberList.get(i))) {
        balls++;
      }
    }

    return balls;
  }

  public boolean isGameOver() { // 게임 오버 여부
    return gameOver;
  }

  private void printGameOverMessage() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
  }
}
