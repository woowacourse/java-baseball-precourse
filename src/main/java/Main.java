import java.util.*;

class Game{

    private static class InputLengthException extends RuntimeException {};
    private static class InputNaNException extends RuntimeException {};
    private static final String[] DIGITS = {"0","1","2","3","4","5","6","7","8","9"};
    private static final int LENGTH = 3;
    private static Scanner scanner;
    private static Random random;
    private static String target;


    public Game(){
        scanner = new Scanner(System.in);
        random = new Random();
        init();
    }


    public void start(){
        while(true){
            proceedTurn();
        }
    }

    private void proceedTurn(){
        try{
            String guess = getUserGuess();
            HashMap<String,Integer> result = evaluateGuess(guess);
//            printResult(result);
        }
        catch( RuntimeException e ){
            hanndleError(e);
        }
    }




    private HashMap<String,Integer> evaluateGuess(String guess){
        HashMap<String,Integer> result = new HashMap<String,Integer>();
        result.put("strike",countStrike(guess));
        result.put("ball",countBall(guess));
        return result;
    }


    private int countStrike(String guess){
        int strikes = 0;

        for(int i = 0; i < LENGTH; i++){
            if(guess.charAt(i) == target.charAt(i)){
                strikes++;
            }
        }

        return strikes;
    }

    private int countBall(String guess){
        int balls = 0;

        for(int i = 0; i < LENGTH; i++){
            if(guess.charAt(i) != target.charAt(i) && target.contains(String.valueOf(guess.charAt(i))) ){
                balls++;
            }
        }

        return balls;
    }


    private String getUserGuess() throws RuntimeException {
        System.out.print("숫자를 입력해주세요: ");
        String input = scanner.nextLine();
        validateGuess(input);
        return input;
    }

    private void validateGuess(String guess){
        if(notFit(guess)) throw new InputLengthException();
        else if(NaN(guess)) throw new InputNaNException();
    }

    private Boolean notFit(String string){
        if (string.length() != LENGTH) return true;
        return false;
    }

    private Boolean NaN(String string){
        try {
            Integer.parseInt(string);
            return false;
        } catch(NumberFormatException e){
            return true;
        }
    }

    private void hanndleError(RuntimeException e){
        if (e instanceof InputLengthException) System.err.println(String.format("입력의 길이가 %d이 아닙니다", LENGTH));
        else if (e instanceof InputNaNException) System.err.println("입력이 숫자가 아닙니다.");
        else System.err.println("예상치 못한 오류입니다.");
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
        game.start();
    }
}
