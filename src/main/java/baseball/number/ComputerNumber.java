package baseball.number;

public class ComputerNumber implements BaseballNumber{

    private int[] computerNumber;

    @Override
    public void setNumber(int[] number) {
        this.computerNumber = number;
    }

    @Override
    public int[] getNumber() {
        return computerNumber;
    }
}
