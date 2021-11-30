package baseball.vo;

import java.util.List;

public class UserBall {

    private final List<Integer> userInputList;

    public UserBall(List<Integer> userInputList) {
        this.userInputList = userInputList;
    }

    public List<Integer> getUserInputList() {
        return userInputList;
    }

}
