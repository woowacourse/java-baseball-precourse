import java.util.Random;

public class BaseballGame {
    public static String generateRandomNumber() {
        Random rand = new Random();
        int n1 = rand.nextInt(9) + 1;
        int n2 = rand.nextInt(9) + 1;
        int n3 = rand.nextInt(9) + 1;

        String n1s = String.valueOf(n1);
        String n2s = String.valueOf(n2);
        String n3s = String.valueOf(n3);

        String result = n1s + n2s + n3s;

        return result;
    }
    public static void main(String[] args) {
        String number = generateRandomNumber();
        System.out.println(number);
    }
}
