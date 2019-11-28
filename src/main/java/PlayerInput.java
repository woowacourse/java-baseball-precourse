import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PlayerInput {
    private static Scanner scan = new Scanner(System.in);

    public static String inputNumbers(){
        return scan.next().trim();
    }

    public static boolean isValidNumbers(int digit, String numbers) {
        return numbers.length() == digit && isInteger(numbers) && isNotOverlap(numbers);
    }

    private static boolean isInteger(String numbers) {
        try {
            Integer.valueOf(numbers);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isNotOverlap(String numbers) {
        Set<Character> overlapCheckSet = new HashSet<>();
        for(int i=0; i<numbers.length(); i++) {
            if(overlapCheckSet.add(numbers.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }
}
