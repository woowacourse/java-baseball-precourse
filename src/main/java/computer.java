import java.util.Arrays;
import java.util.Random;

public class computer {

    public int[] pickNumber(int digitNumber) {
        Random random = new Random();
        int[] dictionary = new int[10];
        int[] generatedNumber = new int[digitNumber];
        int temp, i = 0;
        while(i < digitNumber) {
            temp = random.nextInt(9) + 1;
            generatedNumber[i] = temp;
            if(dictionary[temp] == 1) {
                continue;
            }
            dictionary[temp] = 1;
            i++;
        }
        System.out.println( Arrays.toString(generatedNumber) );
        return generatedNumber;
    }
}
