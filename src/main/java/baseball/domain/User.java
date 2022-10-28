package baseball.domain;

import java.util.ArrayList;

public class User {
    private ArrayList<Integer> userNumber;

    public void setUserNumber(ArrayList<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    public ArrayList<Integer> getUserNumber() {
        return userNumber;
    }

}
