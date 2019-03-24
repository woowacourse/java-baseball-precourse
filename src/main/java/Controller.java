import java.util.*;

/*
 * 숫자야구 게임을 시작하고, 전반적인 동작을 관리하는 클래스
 *
 * @author          김강민
 */
public class Controller {

    private HandlingData handlingData;
    private Model model;
    private View view;
    private int temp;
    private static Controller controller;
    private HashSet<Integer> computerNumberSet = new HashSet<>();
    private HashSet<Integer> userNumberSet = new HashSet<>();
    int[] computerNumberArray = new int[3];

    /*
     * Controller에 대한 생성자는 handlingData, model, view의 변수 초기화로 합니다.
     */
    Controller(){
        this.handlingData = HandlingData.getHandlingData();
        this.model = Model.getModel();
        this.view = View.getView();

    }
    /*
     * Controller는 프로그램 내에서 하나만 존재해야 합니다.
     */
    public static Controller getController() {
        if(controller ==null){
            controller = new Controller();
        }
        return controller;
    }

    /*
     * 게임을 시작하고 진행하는 메소드 입니다.
     * ReadMe의 기능 의 순서대로 진행합니다.
     */
    private void StartBaseBallGame(){

        this.SaveComuputerNumber();
        while(true) {
            view.InputNumber();
            handlingData.JudgeStrike();
            view.PrintResult();
            if (this.IsGameOver()) {
                System.out.println("게임종료");
                break;
            }
        }
        view.InputReGame();
    }


    /*
     * SelectRandomNumber 메소드를 호출하여 배열에 난수를 저장하고 Model에 있는 data를 Update 해주었습니다.
     */
    public void SaveComuputerNumber(){

        this.computerNumberSet.clear();
        for(int i=0; i<3; i++){
            computerNumberArray[i] = SelectRandomNumber();
        }
        this.model.setComputerNumber(computerNumberArray);
        this.model.setHashSet(this.computerNumberSet);

    }

    /*
     * 난수를 생성해 1~9까지의 범위의 숫자만 리턴하도록 하는 메소드 입니다.
     */
    public int SelectRandomNumber(){

        while(true){
            temp = (int)(Math.random()*9)+1;
            if(!this.computerNumberSet.contains(temp)){
                this.computerNumberSet.add(temp);
                return temp;
            }
        }

    }

    /*
     * 입력을받은 숫자를 올바른 숫자인지 판단하는 메소드 입니다.
     * @return 올바른숫자이면 true, 아니면 false를 리턴합니다.
     */
    public boolean JudgeValidNumber(int[] userNumber){

        this.userNumberSet.clear();
        for(int i=0; i<3; i++){
            if(userNumber[i]<1 || userNumber[i]>9){
                break;
                }
            this.userNumberSet.add(userNumber[i]);
            }
        if(this.userNumberSet.size() == 3){
            return true;
        }else{
            return false;
            }
    }

    /*
     * @return 3스트라이크이면 true리턴, 아니면 false 리턴턴
    */
    public boolean IsGameOver(){
        if(model.getStrikeCount() == 3){
            return true;
        }else{
            return false;
        }
    }

    /*
     * StartBaseBallGame을 다시 시작합니다!
     */
    public void ReStart(){
        this.StartBaseBallGame();
    }

    /*
     * 프로그램을 종료합니다.
     */
    public void ExitGame(){
        System.exit(0);
    }

    public static void main(String[] args) {

        Controller controller = Controller.getController();
        controller.StartBaseBallGame();

    }
}
