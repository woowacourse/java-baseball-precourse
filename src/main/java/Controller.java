

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
    private static Controller controller;

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

        this.ChooseNumber();
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

    public void ChooseNumber(){
        System.out.println("ChooseNumber 실행!");
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
