import java.util.List;

public class BaseballGame {

    private static final int STRIKE = 0;
    private static final int BALL = 1;
    private static final int SCORE_SIZE = 2;

    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        User user = new User();
        playBaseballGame(user, baseball);
    }

    private static void playBaseballGame(User user, Baseball baseball) {
        List<Integer> baseballs = baseball.getBaseball();
        List<Integer> userBats = user.getUserBat();

        calculateScore(userBats, baseballs);
    }

    private static void calculateScore(List<Integer> userBats, List<Integer> baseballs) {
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
    }

    private static void displayGameScore(int[] gameScore) {
        System.out.println(gameScore[STRIKE] + "스트라이크" + gameScore[BALL] + "볼");
    }


}
