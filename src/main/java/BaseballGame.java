import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {

    public static ArrayList<String> generateRandomNumber() {
        Random rand = new Random();

        Set<String> set = new LinkedHashSet<String>();
        while (set.size() < 3) {
            set.add(Integer.toString(rand.nextInt(9) + 1));
        }

        ArrayList<String> resultArray = new ArrayList<String>(3);

        for (String x : set) {
            resultArray.add(x);
        }

        System.out.println(resultArray);

        return resultArray;
    }

    public static void main(String[] args) {

        ArrayList<String> computerNumber = generateRandomNumber();

    }
}
