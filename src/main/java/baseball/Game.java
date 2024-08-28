package baseball;

public class Game {
    private final Computer computer;
    private final Player player;
    private final CompareNumber compareNumber;

    public Game() {
        computer = new Computer();
        player = new Player();
        compareNumber = new CompareNumber();
    }

    public void play() {
        boolean continuePlaying = true;

        while (continuePlaying) {
            compareNumber.compareNumber(player, computer);

            if (compareNumber.isGameOver()) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String replayInput = player.inputReplay();

                if ("1".equals(replayInput)) {
                    // 게임 재시작
                    computer.resetRandomNumber(); // 새로운 난수 생성
                } else if ("2".equals(replayInput)) {
                    // 게임 종료
                    continuePlaying = false;
                } else {
                    // 잘못된 입력 처리
                    System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
                    continuePlaying = false;
                }
            }
        }
    }
}
