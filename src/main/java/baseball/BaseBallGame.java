package baseball;

import java.util.Scanner;

public class BaseBallGame{
    private boolean isNewGameContinue = true;

    public void gameStart(Scanner scanner){
        while(isNewGameContinue){
            RandomNumberGenerator answerNumber = getAnswerNumber();
            Player player = new Player();
            gameProgress(scanner, answerNumber, player);
        }
    }

    private RandomNumberGenerator getAnswerNumber(){
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        randomNumberGenerator.makeRandomNumber();
        return randomNumberGenerator;
    }

    private void gameProgress(Scanner scanner, RandomNumberGenerator randomNumber, Player player){

        while(true){
            player.playerGamePlay(scanner, randomNumber);
            getHint(player);
            if(isAnswer(player)) {
                System.out.println(Constants.GAME_FINISH_MESSAGE);
                isNewGameContinue = isGameKeepGoing(scanner);
                break;
            }
        }
    }
    private boolean isAnswer(Player player){
        return player.getStrikeCount() == Constants.ANSWER_COUNT;
    }

    private boolean isGameKeepGoing(Scanner scanner){

        try{
            IllegalArgumentException e = new IllegalArgumentException(Constants.INPUT_ERROR_MESSAGE);

            int gameRestartFlag = scanner.nextInt();
            if(gameRestartFlag == Constants.GAME_RESTART) {
                return true;
            } else if(gameRestartFlag == Constants.GAME_STOP) {
                return false;
            } else {
                throw e;
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage() + Constants.RESTART_REQ_MESSAGE);
            return isGameKeepGoing(scanner);
        }
    }

    private void getHint(Player player){

        int playerBallCount = player.getBallCount();
        int playerStrikeCount = player.getStrikeCount();

        if(playerBallCount == 0 && playerStrikeCount == 0) {
            System.out.println(Constants.ALL_MISS_MESSAGE);
            return;
        }

        if(playerBallCount != 0) {
            System.out.print(playerBallCount + Constants.BALL_MESSAGE + " ");
        }
        if(playerStrikeCount != 0) {
            System.out.print(playerStrikeCount + Constants.STRIKE_MESSAGE);
        }
        System.out.println();
    }
}
