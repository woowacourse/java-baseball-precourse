package utils;

import java.util.Scanner;

public class InputUtils {
    static Scanner scanner=new Scanner(System.in);
    public static Integer inputInteger(String prompt){
        Integer input;
        while(true) {
            System.out.print(prompt);
            try{
                input=scanner.nextInt();
                break;
            }catch (Exception e){
                System.out.println("유효하지 않은 입력입니다.");
                flush(scanner);
            }
        }
        flush(scanner);
        return input;
    }
    public static void flush(Scanner scanner) {
        scanner.nextLine();
    }
    public static void closeInput() {
        scanner.close();
    }
}
