package baseball;

import java.util.Scanner;

public class Application {
    private static final int CONTINUE = 0;
    private static final int RESTART = 1;
    private static final int END = 2;
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
            int kindOfGame = getIndexOfGameProgress(competitor, gamePlayer);

            if (kindOfGame == RESTART) {
                competitor = new Competitor();
            }

            if (kindOfGame == END) {
                break;
            }
        }
    }

    private static int getIndexOfGameProgress(Competitor competitor, GamePlayer gamePlayer){
        try {
            String inputRandomNumbers = gamePlayer.generateNumbersOfPlayerEntered();
            String comparativeResult = Comparator.getComparativeResult(
                                            competitor.getGeneratedRandomNumbers(), inputRandomNumbers);

            System.out.println(comparativeResult);
            if(!comparativeResult.equals(GAME_EXIT_CONDITIONS)){
                return CONTINUE;
            }

            System.out.println(GAME_END_STATEMENT);
            int selectMenu = gamePlayer.selectRestartOrEnd();
            if(selectMenu == RESTART){
                return RESTART;
            }

            return END;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return CONTINUE;
        }
    }

}
