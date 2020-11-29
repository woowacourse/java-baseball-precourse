package baseball.model;

import java.util.List;

public class User {
    private List<Integer> userNumber;
    private int retryNumber;

    public User(List<Integer> userNumber, int retryNumber) {
        this.userNumber = userNumber;
        this.retryNumber = retryNumber;
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(List<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    public int getRetryNumber() {
        return retryNumber;
    }

    public void setRetryNumber(int retryNumber) {
        this.retryNumber = retryNumber;
    }
}
