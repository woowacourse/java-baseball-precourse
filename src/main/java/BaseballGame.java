import java.util.List;

public class BaseballGame {
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
        int[] gameScore = new int[2];
        for(int userBatLoc=0; userBatLoc<userBats.size(); userBatLoc++) {
            if(baseballs.contains(userBats.get(userBatLoc)) && baseballs.get(userBatLoc).equals(userBats.get(userBatLoc))) {
                gameScore[0]++;
                continue;
            }
            if(baseballs.contains(userBats.get(userBatLoc)) && !baseballs.get(userBatLoc).equals(userBats.get(userBatLoc))) {
                gameScore[1]++;
            }
        }
    }

}
