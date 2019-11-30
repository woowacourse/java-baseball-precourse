/**
 * 클래스 이름      PlayGame
 * 버전 정보        1.0
 * 날짜            2019.11.30
 * 저작권          YebinK
 */

public class PlayGame {

    RandomNumber rn = new RandomNumber();
    PlayerInput p = new PlayerInput();
    int [] answer = new int[3];
    int [] userInput = new int[3];

    int strikeCount = 0;
    int ballCount = 0;

    public void playCmd() {
        answer = rn.setNumber();
        //while (answer != userInput) {
            userInput = p.getInput();
            compare();

        //}
    }

    public void compare() {
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                count(i, j);
            }
        }
    }

    public void count(int i, int j) {
        if (answer[i] == userInput[j] && i == j) strikeCount++;
        if (answer[i] == userInput[j] && i != j) ballCount++;
    }
}
