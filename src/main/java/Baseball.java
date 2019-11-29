import java.util.Random;
import  java.util.Scanner;
public class Baseball {
    private String answer;
    Baseball(){
        Random rand = new Random();
        answer = new String();
        for(int i = 0, temp; i < 3;i++){
            while(true) {
                temp = rand.nextInt(8) + 1;
                String currentNumber = Integer.toString(temp);
                if (!answer.contains(currentNumber)) {
                    answer += currentNumber;
                    break;
                }
            }
        }
    }
    public boolean doBaseball(){
        String input = getInput();
        int strike = getStrike(input);
        if(strike == 3){
            System.out.println("3 strike");
            System.out.println("You got an answer! end game");
        }

        return true;
    }
    public String getInput(){
        String input;
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("Input the Number: ");
            input = scan.nextLine();
            int input_number;
            try {
                input_number = Integer.parseInt(input);
            }
            catch (Exception e){
                System.out.println("Input only Number");
                continue;
            }
            input = Integer.toString(input_number);
            if(input.length() != 3){
                System.out.println("Please input 3-length number");
                continue;
            }
            if(input.charAt(0) == input.charAt(1) ||input.charAt(0) == input.charAt(2) ||input.charAt(1) == input.charAt(2) ){
                System.out.println("Please do not input duplicated number");
                continue;
            }
            break;
        }
        return input;
    }
    public int getStrike(String input){
        int strike = 0;
        for(int i = 0; i < 3; i++){
            if(input.charAt(i) == answer.charAt(i)){
                strike++;
            }
        }
        return strike;
    }
}
