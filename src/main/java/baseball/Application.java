package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Number number = new Number();
        String input = scanner.next();

        number.setTarget();
        try{
            number.setGuess(input);
        } catch(IllegalArgumentException e){
            System.out.println("Wrong Number");
        }

        
        scanner.close();
    }
}
