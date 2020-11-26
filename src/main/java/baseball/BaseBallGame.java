package baseball;

import java.util.Scanner;

public class BaseBallGame{
    boolean isGameContinue = true;

    public void gameStart(Scanner scanner){
        while(isGameContinue){
            GameSetting gameObject = gameSetting();
            gameRun(scanner, gameObject);
        }
    }

    public GameSetting gameSetting(){
        GameSetting gameSetting = new GameSetting();
        gameSetting.makeRandomNumber();
        return gameSetting;
    }

    public void gameRun(Scanner scanner, GameSetting gameSetting){
        GameProgress gameProgress = new GameProgress();

        while(true){
            gameProgress.getPlayerNumber(scanner, gameSetting);

            getHint(gameProgress);
            if(gameProgress.getStrikeCount() == Constants.NUMBER_COUNT) {
                isGameContinue = isGameFinish(scanner);
                break;
            }
        }
    }

    public boolean isGameFinish(Scanner scanner){
        System.out.println(Constants.GAME_FINISH_MESSAGE);
        int gameRestartFlag = scanner.nextInt();
        if(gameRestartFlag == Constants.GAME_RESTART) return true;
        else if(gameRestartFlag == Constants.GAME_STOP) return false;

        return false;
    }

    public void getHint(GameProgress gameProgress){
        if(gameProgress.getStrikeCount() == 0 && gameProgress.getBallCount() == 0) {
            System.out.print("낫싱");
        }

        int ballCount = gameProgress.getBallCount();
        int strikeCount = gameProgress.getStrikeCount();

        if(ballCount != 0) System.out.print(ballCount + Constants.BALL_MESSAGE + " ");
        if(strikeCount != 0) System.out.print(strikeCount + Constants.STRIKE_MESSAGE);

        System.out.println();
    }

}
