import java.util.Scanner;

public class User {
    static int[] userNumber = new int[3];
    public User(){
        Scanner sc = new Scanner(System.in);
        String input = "";
        while(true) {
            System.out.println("세자리 임의의 다른 숫자를 입력해주세요.");
            input = sc.nextLine();
            if(input.length() != 3 || input.contains("0")) {                                                                                // 3자리 외 다른 자리 수 또는 0이 들어오면 입력 다시 받기
                System.out.println("세자리 임의의 다른 숫자를 입력해주세요.");
                continue;
            } else if(input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)){      // 중복되는 수가 있으면 입력 다시 받기
                System.out.println("세자리 임의의 다른 숫자를 입력해주세요.");
                continue;
            }
            try{                                                                                                                            // 숫자말고 다른 수가 들어오면 다시 입력 받기
                Integer.parseInt(input);
                break;
            }catch (NumberFormatException e) {
                System.out.println("세자리 임의의 다른 숫자를 입력해주세요.");
                continue;
            }
        }
        for (int i = 0; i < userNumber.length; i++){
            userNumber[i] = (int)input.charAt(i) - 48;
        }
    }
}
