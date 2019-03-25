/**
 * @class Computer
 * @vesrion 1.0.0
 * @date 2019-03-25
 * @author YUN,SUNG HO (itlockit@gmail.com)
 * @brief Computer information is stored
 */
import java.util.Random;

public class Computer {
    private int numbers[] = new int[3];
    Computer(){
        Random random = new Random();
        // Enter a 3-digit integer.
        for(int i = 0 ; i < 3 ; i++){
            numbers[i] = random.nextInt(9) + 1;
        }
    }
    int[] getNumbers(){
        return this.numbers ;
    }
}
