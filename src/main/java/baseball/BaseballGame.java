package baseball;

public class BaseballGame {
  private final Computer computer;
  private final Player player;
  private final CompareNumbers compareNumbers;

  public BaseballGame() {
    computer = new Computer();
    player = new Player();
    compareNumbers = new CompareNumbers();
  }

  public void play() {
    boolean continuePlaying = true;

    while (continuePlaying) {
      compareNumbers.compareNumbers(player, computer);

      if (compareNumbers.isGameOver()) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String replayInput = player.inputReplay();

        if ("1".equals(replayInput)) {
          // 게임 재시작
          computer.resetRandomNumberList(); // 새로운 난수 생성
        } else if ("2".equals(replayInput)) {
          // 게임 종료
          continuePlaying = false;
        }
      }
    }
  }
}