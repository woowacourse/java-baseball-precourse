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
        // Enter first digit
        numbers[0] = random.nextInt(9) + 1;
        // Second number random until it doesn't overlap with the first number
        while((numbers[1]  = random.nextInt(9) + 1) == numbers[0]);
        // Third number random until it doesn't overlap with the first and second number
        while((numbers[2]  = random.nextInt(9) + 1) == numbers[1] ||
                (numbers[2]  = random.nextInt(9) + 1) == numbers[0]);
    }
    int[] getNumbers(){
        return this.numbers ;
    }
}
