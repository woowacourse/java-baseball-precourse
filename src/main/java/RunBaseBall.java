import java.util.*;

/*
 * 숫자야구 게임을 시작하고, 전반적인 동작을 관리하는 클래스
 *
 * @author          김강민
 */
public class RunBaseBall {

    private HandlingData handlingData;
    private BaseballData baseballData;
    private UserInterface userInterface;
    private int temp;
    private static RunBaseBall runBaseBall;
    private HashSet<Integer> computerNumberSet = new HashSet<>();
    private HashSet<Integer> userNumberSet = new HashSet<>();
    int[] computerNumberArray = new int[3];

    /*
     * RunBaseBall에 대한 생성자는 handlingData, BaseballData, UserInterface의 변수 초기화로 합니다.
     */
    RunBaseBall(){
        this.handlingData = HandlingData.getHandlingData();
        this.baseballData = BaseballData.getBaseballData();
        this.userInterface = userInterface.getUserInterface();
    }
    /*
     * RunBaseBall는 프로그램 내에서 하나만 존재해야 합니다.
     */
    public static RunBaseBall getRunBaseBall() {
        if(runBaseBall ==null){
            runBaseBall = new RunBaseBall();
        }
        return runBaseBall;
    }

    /*
     * 게임을 시작하고 진행하는 메소드 입니다.
     * ReadMe의 기능 의 순서대로 진행합니다.
     */
    private void StartBaseBallGame(){

        this.SaveComuputerNumber();
        while(true) {
            userInterface.InputNumber();
            handlingData.JudgeStrike();
            userInterface.PrintResult();
            if (this.IsGameOver()) {
                System.out.println("게임종료");
                break;
            }
        }
        userInterface.InputReGame();
    }

    public void SaveComuputerNumber(){

        this.computerNumberSet.clear();
        for(int i=0; i<3; i++){
            computerNumberArray[i] = SelectRandomNumber();
        }
        this.baseballData.setComputerNumber(computerNumberArray);
        this.baseballData.setHashSet(this.computerNumberSet);

    }

    public int SelectRandomNumber(){

        while(true){
            temp = (int)(Math.random()*9)+1;
            if(!this.computerNumberSet.contains(temp)){
                this.computerNumberSet.add(temp);
                return temp;
            }
        }

    }

    public boolean JudgeValidNumber(int[] userNumber){

        this.userNumberSet.clear();
        for(int i=0; i<3; i++){
            if(userNumber[i]<1 || userNumber[i]>9){
                break;
                }
            this.userNumberSet.add(userNumber[i]);
            }

        return (this.userNumberSet.size() == 3) ? true:false;
    }

    public boolean IsGameOver(){
        if(baseballData.getStrikeCount() == 3){
            return true;
        }else{
            return false;
        }
    }

    public void ReStart(){
        this.StartBaseBallGame();
    }

    public void ExitGame(){
        System.exit(0);
    }

    public static void main(String[] args) {

        RunBaseBall RunBaseBall = runBaseBall.getRunBaseBall();
        RunBaseBall.StartBaseBallGame();

    }
}
