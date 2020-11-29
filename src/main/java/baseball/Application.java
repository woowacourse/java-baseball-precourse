package baseball;



import java.util.Scanner;
import utils.RandomUtils;
import static baseball.MakeThreeRandomNumber.makeRandomThreeNumber;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int [] computerNumber = makeRandomThreeNumber();
        for(int i:computerNumber){
            System.out.println(i);
        }
    }
}