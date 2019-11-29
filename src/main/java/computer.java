import java.util.Random;

public class computer {

    public int[] pickNumber(int digitNumber) {
        Random random = new Random();
        int[] dictionary = new int[10];
        int[] generatedNumber = new int[digitNumber];
        int temp;
        for(int i = 0; i < digitNumber; i++) {
            temp = random.nextInt(9) + 1;
            System.out.printf("%d임. ", temp);
        }
        return generatedNumber;
    }
}
