package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static List<Integer> balls = new ArrayList<>();

    public static void makeBalls(String userInput) {
        balls.clear();

        String[] stringArray = userInput.split("");
        for (int i = 0; i < stringArray.length; i++) {
            balls.add(Integer.parseInt(stringArray[i]));
        }
    }
}
