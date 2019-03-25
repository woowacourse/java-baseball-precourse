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
