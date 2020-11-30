package baseball.domain;

import java.util.stream.IntStream;

public class Number {
    public static int NUM_LENGTH = 3;
    private int[] number;

    public Number(int[] number){
        this.number = number;
    }

    public boolean contains(int number) {
        return IntStream.of(this.number).anyMatch(i->i==number);
    }

    public void insert(int index, int value) {
        this.number[index] = value;
    }

    public boolean isEquals(int index, int number) {
        if (this.number[index]==number) {
            return true;
        }

        return false;
    }

    public boolean containNotEquals(int index, int number) {
        for (int i = 0; i < Number.NUM_LENGTH; i++) {
            if (index != i && this.number[i] == number) {
                return true;
            }
        }

        return false;
    }
}
