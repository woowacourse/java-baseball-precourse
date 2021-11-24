package baseball;
import java.util.*;


public class Application {

    public static final String START_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String MESSAGE_ABOUT_WRONG_INPUT = "3자리 숫자를 입력해야 합니다.";
    public static final String HINT_MESSAGE = "볼 , 스트라이크";

    static int[] answerNumber = new int[3];

    public static void main(String[] args) {

        setAnswerNumber();

        while (true) {
            String number;
            Scanner sc = new Scanner(System.in);
            System.out.print(START_MESSAGE);
            number = sc.next();
            if (checkWrongInput(number)){
                System.out.println(MESSAGE_ABOUT_WRONG_INPUT);
                continue;
            }
            compareNumber(number);
        }
    }

    public static void setAnswerNumber(){
        List<Integer> possibleNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for(int i=0; i<3; i++){
            int randomValue = (int)(Math.random()*(9 - i));
            answerNumber[i] = possibleNumber.get(randomValue);
            possibleNumber.remove(randomValue);
        }
    }

    public static boolean checkWrongInput(String number){
        int numberLength = number.length();
        return numberLength == 3;
    }

    public static String compareNumber(String number){
        int strikeNumber = 0;
        int ballNumber = 0;
        return "1";
    }
}
