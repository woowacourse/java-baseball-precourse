package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {

    private static final int generate_num(){
        int answer_arr[] = new int[3];
        String number = "";
        for(int i = 0; i < 3; i++){
            int num = Randoms.pickNumberInRange(1,9);
            answer_arr[i] = num;
            number += Integer.toString(num);
        }
        return Integer.parseInt(number);
    }


   
    
    public static void main(String[] args) {
        int num = generate_num();
        System.out.println(num);
        
    }
}
