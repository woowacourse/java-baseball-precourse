package baseball;

import utils.RandomUtils;

import java.util.*;

public class BaseballGame {
    private final Scanner scanner;

    public BaseballGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run(){
        while(true){
            game();
        }
    }

    public void game() {
        List<String> ballNumberList = ballNumbers();
        int ballCounter = 0;
        int strikeCounter = 0;
        System.out.print("숫자를 입력해주세요 : ");
        String playerBallNumber = scanner.nextLine();

        List<String> playerBallSplitNumberList = playerBallNumber(playerBallNumber);
    }

    public List<String> ballNumbers() {
        Set<String> set = new HashSet<>();
        while(set.size() < 3) {
            set.add(String.valueOf(RandomUtils.nextInt(1, 9)));
        }
        return new ArrayList<>(set);
    }

    public List<String> playerBallNumber(String playerBallNumber) {
        String[] playerBallSplitNumber = playerBallNumber.split("");
        List<String> playerBallSplitNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            playerBallSplitNumberList.add(playerBallSplitNumber[i]);
        }
        return playerBallSplitNumberList;
    }
}
