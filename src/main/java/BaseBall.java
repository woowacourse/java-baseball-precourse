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
    int compNumbers[];
    private Scanner scanner;
    private boolean isGamePlay = true;
    private boolean isGameFinish = false;
    private Pattern p = Pattern.compile("[1-9]{3}");
    BaseBall(){
        scanner = new Scanner(System.in);
        init();
        play();
    }
    public void init(){
        computer = new Computer();
        compNumbers = computer.getNumbers();
    }
    public void play(){
        while(isGamePlay) {
            int strike = 0;
            int ball = 0;
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = scanner.nextLine();
            Matcher m = p.matcher(userInput);
            if(!m.matches()){
                // if wrong input restart game
                continue;
            }
            int userNumbers[] = new int[3];
            userNumbers[0] = Integer.parseInt(userInput.substring(0,1));
            userNumbers[1] = Integer.parseInt(userInput.substring(1,2));
            userNumbers[2] = Integer.parseInt(userInput.substring(2,3));
            strike = checkStrike(userNumbers, compNumbers);
            ball = checkBall(userNumbers,compNumbers);
            if(strike != 0 && strike != 3 && ball == 0){
                System.out.println(strike + "스트라이크 ");
            } else if(ball != 0){
                System.out.print(strike + "스트라이크 ");
                System.out.println(ball + "볼");
            } else if(strike == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            }
        }
    }
    public int checkStrike(int[] userNumbers, int[]compNumbers){
        int count = 0;
        for(int i = 0 ; i < 3 ; i++){
            if(userNumbers[i] == compNumbers[i]){
                count++;
            }
        }
        return count;
    }
    public int checkBall(int[] userNumbers, int[]compNumbers){
        int count = 0;
        for(int i = 0 ; i < 3 ; i++){
            if(userNumbers[i] == compNumbers[(i+1)%3]){
                count++;
            }
            if(userNumbers[i] == compNumbers[(i+2)%3]){
                count++;
            }
        }
        return count;
    }
}