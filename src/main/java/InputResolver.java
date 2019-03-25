import java.util.Scanner;

public class InputResolver {
    public static String getInput(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String input = sc.nextLine();
            if(input.length() != 3){
                System.out.println("3자리 숫자를 입력해주세요");
                continue;
            }
            if((input.charAt(0) == input.charAt(1))
                    || (input.charAt(1) == input.charAt(2))
                    || (input.charAt(2) == input.charAt(0))){
                System.out.println("3자리 수는 서로 다른 수로 이루어져야 합니다.");
                continue;
            }
            return input;
        }
    }
}
