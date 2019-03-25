import java.util.Random;

public class NumCreator {
    // TODO
    public static String getNum(){
        Random rand = new Random();
        while(true){
            int num = rand.nextInt(900)+100;
            String input = String.valueOf(num);
            if((input.charAt(0) == input.charAt(1))
                    || (input.charAt(1) == input.charAt(2))
                    || (input.charAt(2) == input.charAt(0))){
                continue;
            }
            return input;
        }
    }
}