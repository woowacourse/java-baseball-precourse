package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {

    private static final int generate_num(){
        int answer_arr[] = new int[3];
        boolean false_list[] = {false,false,false,false,false,false,false,false,false};
        String number = "";
        for(int i=0; i<3;i++){
            int num;
            while(true){
                num = Randoms.pickNumberInRange(1,9);
                if(false_list[num-1]){continue;}
                false_list[num-1] = true;
                break;
            }
            answer_arr[i] = num;
            number += Integer.toString(num);
        }
        return Integer.parseInt(number);
    }


    // public static void start_game(int answer){
    //     boolean flag = true;

    //     while(flag){
    //         int strike = 0;
    //         int ball = 0;   
    //         System.out.print("숫자를 입력해주세요 : ");
    //         int input = Integer.parseInt(Console.readLine());
    //         for(int i = 0; i < 3; i++){
                
    //         }
    //     }
        
    // }
    
    public static void main(String[] args) {
        int num = generate_num();
        System.out.println(num);
        
    }
}
