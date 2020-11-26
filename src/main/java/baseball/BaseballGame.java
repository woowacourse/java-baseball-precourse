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

    public void game(){
        List<String> ballNumberList = ballNumbers();
    }

    public List<String> ballNumbers() {
        Set<String> set = new HashSet<>();
        while(set.size() < 3) {
            set.add(String.valueOf(RandomUtils.nextInt(1, 9)));
        }
        return new ArrayList<>(set);
    }
}
