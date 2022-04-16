package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.game.BaseBallGame;
import baseball.pitcher.PitchingResult;

public class BaseBallGamePlay {

    private BaseBallGame game;

    public void start() {
        do {
            play();
        } while (readRetry());
    }

    private boolean readRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하시려면 2를 입력하세요.");
        String input = readLine();
        if ("1".equals(input)) {
            return true;
        } else if ("2".equals(input)) {
            return false;
        }
        return readRetry();
    }

    private void play() {
        BaseBallGame newGame = getNewGame();

        while (!newGame.isGameEnd()) {
            printResult(newGame.mount(readNumber()));
        }

        printGameEnd();
    }

    private void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private String readNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    private void printResult(PitchingResult result) {
        StringBuilder sb = new StringBuilder();
        if (result.getBallCount() > 0) {
            sb.append(result.getBallCount()).append("볼 ");
        }
        if (result.getStrikeCount() > 0) {
            sb.append(result.getStrikeCount()).append("스트라이크");
        } else if (sb.length() == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb);
    }

    private BaseBallGame getNewGame() {
        if (game == null) {
            game = new BaseBallGame();
            return game;
        }
        game.restart();
        return game;
    }

}
