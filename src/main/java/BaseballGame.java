import java.util.List;
import java.util.Scanner;

public class BaseballGame {

    private static final int STRIKE = 0;
    private static final int BALL = 1;
    private static final int SCORE_SIZE = 2;
    private static final int THREE_STRIKE = 3;

    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        User user = new User();
        playBaseballGame(user, baseball);
    }

    private static void playBaseballGame(User user, Baseball baseball) {
        List<Integer> baseballs = baseball.getBaseball();
        int gameState;
        while(true) {
            if(calculateScore(user.getUserBat(),baseballs)){
                System.out.println("3개 숫자를 모두 맞히셨습니다! 게임종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gameState = getGameState();
                break;
            }
        }
        if(gameState == 1){
            playBaseballGame(user,baseball);
        }
    }

    private static int getGameState() {
        int gameState;
        while(true) {
            try{
                gameState = checkGameState();
                break;
            } catch(NumberFormatException e){
                System.out.println("1 또는 2를 입력해주시기 바랍니다.");
            }
        }

        return gameState;
    }

    private static int checkGameState() {
        Scanner scanUserBat = new Scanner(System.in);
        String gamStateValue = scanUserBat.next();
        int gameState = Integer.parseInt(gamStateValue);
        if(gameState != 1 && gameState != 2) { throw new NumberFormatException();}
        return gameState;
    }


    private static boolean calculateScore(List<Integer> userBats, List<Integer> baseballs) {
        int[] gameScore = new int[SCORE_SIZE];
        for(int userBatLoc=0; userBatLoc<userBats.size(); userBatLoc++) {
            if(baseballs.contains(userBats.get(userBatLoc)) && baseballs.get(userBatLoc).equals(userBats.get(userBatLoc))) {
                gameScore[STRIKE]++;
                continue;
            }
            if(baseballs.contains(userBats.get(userBatLoc)) && !baseballs.get(userBatLoc).equals(userBats.get(userBatLoc))) {
                gameScore[BALL]++;
            }
        }
        displayGameScore(gameScore);
        return checkStrike(gameScore);

    }

    private static boolean checkStrike(int[] gameScore) {
        if(gameScore[STRIKE] == THREE_STRIKE) { return true; }
        return false;
    }

    private static void displayGameScore(int[] gameScore) {
        System.out.println(gameScore[STRIKE] + "스트라이크" + gameScore[BALL] + "볼");
    }


}
