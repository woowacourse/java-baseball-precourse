package Number;

import java.util.List;

public class Number {

    private int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        return new Number(number);
    }
}
