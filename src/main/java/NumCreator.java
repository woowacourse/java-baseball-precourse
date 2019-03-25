import java.util.Random;

public class NumCreator {
    public static String getNum(){
        Random rand = new Random();
        while(true){
            int num1 = rand.nextInt(9)+1;
            int num2 = rand.nextInt(9)+1;
            int num3 = rand.nextInt(9)+1;
            if((num1 == num2) || (num2 == num3) || (num3 == num1)){
                continue;
            }
            String input = String.valueOf(num1*100+num2*10+num3);
            return input;
        }
    }
}