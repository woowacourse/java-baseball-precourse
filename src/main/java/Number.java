import java.util.ArrayList;
import java.util.Random;

/**
 * Number
 */
public class Number {
    private int[] digits;
    String num;

    public Number(int length) {
        digits = new int[length];
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int rand_int = rand.nextInt(10);
            digits[i] = rand_int; 
        }
        System.out.println("!");
    }

    public String getDigits() {
        for(int digit: digits){
            num.concat(String.valueOf(digit));
        }
        return num;
    }

    public void setDigits(int[] digits) {
        this.digits = digits;
    }


}