import java.util.*;

class Game{

    private static final String[] DIGITS = {"0","1","2","3","4","5","6","7","8","9"};
    private static Scanner scanner;
    private static Random random;
    private static String target;


    public Game(){
        scanner = new Scanner(System.in);
        random = new Random();
        init();
    }

    private void init(){
        target = createAnswerString();
    }

    private String createAnswerString(){
        String first = pickDigitExcept();
        String second = pickDigitExcept(first);
        String third = pickDigitExcept(first, second);
        return first + second + third;
    }


    private String pickDigitExcept(String ... except){

        String[] pool = DIGITS;

        if(except != null) pool = newDigitPoolExcept(except);

        String pick = pool[random.nextInt(pool.length)];

        return pick;
    }


    private String[] newDigitPoolExcept(String[] except){

        List<String> newPool = new ArrayList<String>();

        for(String digit: DIGITS){
            if(!Arrays.asList(except).contains(digit)) newPool.add(digit);
        }

        return newPool.toArray(new String[newPool.size()]);
    }

}

public class Main {
    public static void main(String[] args){
        Game game = new Game();
    }
}
