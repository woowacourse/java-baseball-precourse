package baseball.player;

import java.util.List;

public class Player {

    protected List<Integer> digits;

    protected Player(){}
    protected Player(List<Integer> digits) {
        this.digits = digits;
    }

    public boolean hasDigit(Integer digit) {
        return digits.contains(digit);
    }

    public boolean isSameDigit(Integer digit, int index) {
        return digits.get(index).equals(digit);
    }

    public Integer getDigit(int index) {
        return digits.get(index);
    }
}
