package baseball.number;

public class UserNumber implements BaseballNumber {
    private int[] userNumber;

    @Override
    public void setNumber(int[] number) {
        this.userNumber = number;
    }

    @Override
    public int[] getNumber() {
        return userNumber;
    }
}
