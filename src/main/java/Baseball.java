import java.util.Random;


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
}

