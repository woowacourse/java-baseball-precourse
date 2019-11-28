import java.util.Scanner;

public class Menu {
    public void menu() {
        Scanner inputNum = new Scanner(System.in);
        char selected = '0';
        while (!(selected == '2')) {
            System.out.println("!! Number Baseball Game !!");
            System.out.println();
            System.out.println("1. Solution Mode");
            System.out.println("2. Exit");
            selected = inputNum.next().charAt(0);

            if (selected == '1') {
                Play game = new Play();
                game.guessNum();
            }
            else if (selected == '2') {
                System.out.println("Quit game...");
            }
            else {
                System.out.println("Wrong input!!");
            }
            System.out.println();
        }
    }
}
