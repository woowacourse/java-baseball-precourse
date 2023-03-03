package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import static org.mockito.ArgumentMatchers.eq;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    static int answer_arr[] = new int[3];
    static boolean false_list[] = {false,false,false,false,false,false,false,false,false};

    private static final int generate_num(){
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


    public static void start_game(int answer){
        boolean flag = true;
        while(flag){
            int strike = 0;
            int ball = 0;   
            System.out.print("숫자를 입력해주세요 : ");
            int input = Integer.parseInt(Console.readLine());
            int input_arr[] = new int[3];
            for(int i = 0; i < 3; i++){
                double number_input = input % Math.pow(10,i+1) / Math.pow(10,i);
                input_arr[i] = (int)number_input;
                if(answer_arr[2-i] == (int)number_input){
                    strike ++;
                }
                else if(false_list[(int)number_input -1]){
                    ball ++;
                }
            }
            if(strike == 3){
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다 ! 게임 종료");
                break;
            }
            else if(strike == 0 && ball ==0){
                System.out.println("낫싱");
            }
            else{
                if(strike == 0){
                    System.out.println(ball+"볼");
                }
                else if(ball == 0){
                    System.out.println(strike+"스트라이크");
                }
                else{
                    String result = String.format("%d볼 %d스트라이크",ball,strike);
                    System.out.println(result);
                }
            }
        }
            
        }
        
    
    
    public static void main(String[] args) {
        int num = generate_num();
        System.out.println(num);
        start_game(num);
        
    }
}
