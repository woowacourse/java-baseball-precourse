package baseball.model;

public class Game {
    private final Player player;
    private final TargetNumber targetNumber;
    private final NumberJudge numberJudge;

    public Game() {
        this.player = new Player();
        this.targetNumber = new TargetNumber(new TargetNumberGenerator());
        this.numberJudge = new NumberJudge();
    }

    public void start() {
        targetNumber.generate();
        boolean isPlaying = true;

        while (isPlaying) {
            String playerInput = player.getNumberInput();
            Result result = numberJudge.judge(targetNumber.getNumber(), playerInput);
            result.printResult();

            if (result.isGameWon()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isPlaying = false;
                if (askForRestart()) {
                    start();
                }
            }
        }
    }

    private boolean askForRestart() {
        String input = player.getRestartInput();
        return input.equals("1");
    }
}