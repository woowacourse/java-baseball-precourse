
import java.util.Random;

/**
 * Number
 */
public class Number {
    int[] digits = new int[10];
    int len;
    String num="";

    public Number(int _len) {
        len = _len;
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            int rand_int = rand.nextInt(10);
            digits[rand_int] = i+1; 
        }       
    }

    public String getDigits() {
        int[] temp = new int[len];
        for(int j=0; j<digits.length; j++){
          if(digits[j]!=0){
            temp[digits[j]-1]=j;
          }
        }
        for(int digit : temp){
            num = num + String.valueOf(digit);
        }
        return num;
    }

}