import java.util.Random;
import java.util.Scanner;


public class Baseball {

    public static int[] randomNumber(int[] computer) {
        // 컴퓨터 숫자를 랜덤으로 부여
        Random rand = new Random();
        boolean[] sure = new boolean[10];
        int count = 0;
        int trial;

        sure[0] = true; // 0제외

        while (count < computer.length) {
            trial = rand.nextInt(10);
            if (!sure[trial]) {
                computer[count] = trial;
                sure[trial] = true; // 숫자 중복 방지
                count++;
            }
        }
        return computer;
    }

    public static boolean checkUser(char[] wrong) {

        if(wrong.length != 3) {
            return false;
        } else if(wrong[0] == wrong[1] || wrong[0] == wrong[2] || wrong[1] == wrong[2]){
            return false;
        } else if(!Character.isDigit(wrong[0]) && !Character.isDigit(wrong[1]) && !Character.isDigit(wrong[2])){
            return false;
        } else if(wrong[0] == '0' || wrong[1] == '0' || wrong[2] == '0'){
            return false;
        }
        return true;
    }

    public static int[] getUser(int[] user) {
        // 사용자 입력숫자 받기
        Scanner scan = new Scanner(System.in);
        boolean right;
        System.out.print("숫자를 입력해주세요 : ");
        String input = scan.nextLine();// 사용자 입력
        char[] charArray = input.toCharArray(); // 문자열을 char배열로 전환

        right = checkUser(charArray);// 입력값이 제대로 됐는지 체크
        if(!right){
            charArray[0] = '0';
        }
        for (int i = 0; i < charArray.length; i++) {
            user[i] = Character.getNumericValue(charArray[i]);
        }
        return user;
    }
}

