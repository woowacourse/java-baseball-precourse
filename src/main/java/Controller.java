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

    public void SaveComuputerNumber(){

        this.computerNumberSet.clear();
        for(int i=0; i<3; i++){
            computerNumberArray[i] = SelectRandomNumber();
        }
        this.model.setComputerNumber(computerNumberArray);
        this.model.setHashSet(this.computerNumberSet);

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
        if(model.getStrikeCount() == 3){
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

        Controller controller = Controller.getController();
        controller.StartBaseBallGame();

    }
}
