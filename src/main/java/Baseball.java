import java.util.Random;
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
        System.out.println(answer);
        return true;
    }
}
