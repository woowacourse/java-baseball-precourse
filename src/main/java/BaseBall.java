/**
 * @class BaseBall
 * @vesrion 1.0.0
 * @date 2019-03-25
 * @author YUN,SUNG HO (itlockit@gmail.com)
 * @brief Game information is stored
 */
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BaseBall{
    private int numbers[] = new int[3];
    private Computer computer;
    private Scanner scanner;
    private boolean isGamePlay = true;
    private Pattern p = Pattern.compile("[1-9]{3}");
    BaseBall(){
        scanner = new Scanner(System.in);
        init();
        play();
    }
    public void init(){
        computer = new Computer();
    }
    public void play(){
        while(isGamePlay) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = scanner.nextLine();
            Matcher m = p.matcher(userInput);
            if(m.matches()){
                // correct input
            }
        }
    }
}