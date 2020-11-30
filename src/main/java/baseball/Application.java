package baseball;
/*
 * Application
 *
 * version 1.0
 *
 * 2020.11.30
 *
 * Copyright (c) by Davinci.J
 */
import java.util.Scanner;

public class Application {
    private static final int GAME_CONTINUE = 0;
    private static final int GAME_RESTART = 1;
    private static final int GAME_END = 2;
    private static final String GAME_EXIT_CONDITIONS = "3스트라이크";
    private static final String GAME_START_STATEMENT = "숫자를 입력해주세요 : ";
    private static final String GAME_END_STATEMENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료" +
                                                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Competitor competitor = new Competitor();
        GamePlayer gamePlayer = new GamePlayer(scanner);

        while (true) {
            System.out.print(GAME_START_STATEMENT);
            int gameState = playGame(competitor, gamePlayer);

            if (gameState == GAME_RESTART) {
                competitor = new Competitor();
            }

            if (gameState == GAME_END) {
                break;
            }
        }
    }

    private static int playGame(Competitor competitor, GamePlayer gamePlayer) {
        try {
            String comparativeResult = Comparator.compareNumbersOfCompetitorAndPlayer(
                                            competitor.getGeneratedRandomNumbers(),
                                            gamePlayer.generateNumbersOfPlayerEntered());

            System.out.println(comparativeResult);
            if (!comparativeResult.equals(GAME_EXIT_CONDITIONS)) {
                return GAME_CONTINUE;
            }

            System.out.println(GAME_END_STATEMENT);
            int selectedMode = gamePlayer.selectRestartOrEnd();
            if (selectedMode == GAME_RESTART) {
                return GAME_RESTART;
            }

            return GAME_END;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return GAME_CONTINUE;
        }
    }

}
