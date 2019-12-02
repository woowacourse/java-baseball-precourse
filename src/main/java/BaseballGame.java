import java.util.List;
import java.util.Scanner;

public class BaseballGame {

    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;
    private static final int SCORE_SIZE = 2;
    private static final int THREE_STRIKE = 3;
    private static final int NEW_GAME = 1;
    private static final int GAME_OVER = 2;

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.startBaseballGame();
    }

    private void startBaseballGame() {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        User user = new User();
        while(playingBaseballGame(user, baseballNumberGenerator));
    }

    private boolean playingBaseballGame(User user, BaseballNumberGenerator baseballNumberGenerator) {
        List<Integer> baseballs = baseballNumberGenerator.getBaseball();
        List<Integer> userInputNumbers;
        while(true) {
            userInputNumbers = user.getUserBat();
            if(isStrike(userInputNumbers,baseballs)) {
                displayChooseGameState();
                break;
            }
        }
        return getGameState();
    }

    private boolean getGameState() {
        int gameState;
        while(true) {
            try{
                gameState = checkGameState();
                break;
            } catch(NumberFormatException e){
                System.out.println("1 또는 2를 입력해주시기 바랍니다.");
            }
        }
        if(gameState == NEW_GAME) {
            return true;
        }
        return false;
    }

    private int checkGameState() {
        Scanner scanUserBat = new Scanner(System.in);
        String gamStateValue = scanUserBat.next();
        int gameState = Integer.parseInt(gamStateValue);
        if(gameState != NEW_GAME && gameState != GAME_OVER) {
            throw new NumberFormatException();
        }
        return gameState;
    }

    private boolean isStrike(List<Integer> userBats, List<Integer> baseballs) {
        int[] gameScore = new int[SCORE_SIZE];
        for(int userBatLoc = 0; userBatLoc < userBats.size(); userBatLoc++) {
            if(checkStrike(userBats, baseballs, userBatLoc)) {
                gameScore[STRIKE_INDEX]++;
                continue;
            }
            if(checkBall(userBats, baseballs, userBatLoc)) {
                gameScore[BALL_INDEX]++;
            }
        }
        displayGameScore(gameScore);
        return checkStrike(gameScore);
    }

    private void displayChooseGameState() {
        System.out.println("3개 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void displayGameScore(int[] gameScore) {
        System.out.println(gameScore[STRIKE_INDEX] + "스트라이크" + gameScore[BALL_INDEX] + "볼");
    }

    private boolean checkStrike(int[] gameScore) {
        if(gameScore[STRIKE_INDEX] == THREE_STRIKE) { return true; }
        return false;
    }

    private boolean checkBall(List<Integer> userBats, List<Integer> baseballs, int userBatLoc) {
        return baseballs.contains(userBats.get(userBatLoc))
                    && !baseballs.get(userBatLoc).equals(userBats.get(userBatLoc));
    }

    private boolean checkStrike(List<Integer> userBats, List<Integer> baseballs, int userBatLoc) {
        return baseballs.contains(userBats.get(userBatLoc))
                    && baseballs.get(userBatLoc).equals(userBats.get(userBatLoc));
    }


}
