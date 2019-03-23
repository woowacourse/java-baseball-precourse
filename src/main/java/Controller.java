import java.util.HashSet;
import java.util.Random;

/*
 * 숫자야구 게임을 시작하고, 전반적인 동작을 관리하는 클래스
 *
 * @verison         1.00 2019년 3월 23일
 * @author          김강민
 */
public class Controller {

    private HandlingData handlingData;
    private Model model;
    private View view;
    private int isReGame;
    private int temp;
    private static Controller controller;
    private HashSet<Integer> hashSet;

    /*
     * Controller에 대한 생성자는 handlingData, model, view의 변수 초기화로 합니다.
     */
    Controller(){
        this.handlingData = HandlingData.getHandlingData();
        this.model = Model.getModel();
        this.view = View.getView();
        this.hashSet = new HashSet<>();
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
        view.InputNumber();
        handlingData.JudgeStrike();
        view.PrintResult();
        if(this.IsGameOver()){
            this.isReGame = view.InputReGame();
        }
        switch (this.isReGame){
            case 1:
                this.ReStart();
                break;
            case 2:
                this.ExitGame();
                break;
        }

    }
    /*
     * SelectRandomNumber 메소드를 호출하여 배열에 난수를 저장하고 Model에 있는 data를 Update 해주었습니다.
     */
    public void SaveComuputerNumber(){
        int[] computerNumberArray = this.model.getComputerNumber();

        for(int i=0; i<3; i++){
            computerNumberArray[i] = SelectRandomNumber();
        }

        this.model.setComputerNumber(computerNumberArray);

    }
    /*
     * 난수를 생성해 1~9까지의 범위의 숫자만 리턴하도록 하는 메소드 입니다.
     */
    public int SelectRandomNumber(){

        while(true){
            temp = (int)(Math.random()*9)+1;
            if(!this.hashSet.contains(temp)){
                this.hashSet.add(temp);
                return temp;
            }
        }

    }

    public boolean IsGameOver(){
        System.out.println("IsGameOver 실행!");
        return true;
    }

    public void ReStart(){
        System.out.println("ReStart 실행!");
    }

    public void ExitGame(){
        System.out.println("ExitGame 실행!");
    }


    public static void main(String[] args) {

        Controller controller = Controller.getController();
        controller.StartBaseBallGame();

    }
}
