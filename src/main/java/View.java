import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

/*
 * 숫자야구 게임에서 사용자의 입력을 받고, 사용자에게 출력을 해주는 클래스
 *
 * @author          김강민
 */
public class View {

    private Model model;
    private static View view;
    private Scanner scan = new Scanner(System.in);
    private int userNumber;
    private int reGameNumber;
    private Controller controller;
    private int strikeCount;
    private int ballCount;

    View(){
        this.model = Model.getModel();
    }

    public static View getView() {
        if(view==null){
            view = new View();
        }
        return view;
    }

    /*
     * @exception JudgeValidNumber을 이용해 예외처리를 하였습니다.
     */
    public void InputNumber(){

        controller = Controller.getController();

        try {
            System.out.print("숫자를 입력해주세요 : ");
            userNumber = scan.nextInt();
            int[] userNumberArray = Stream.of(String.valueOf(userNumber).split("")).mapToInt(Integer::parseInt).toArray();
            if (!controller.JudgeValidNumber(userNumberArray)) {
                throw new Exception();
            }else{
                model.setUserNumber(userNumberArray);
            }
        } catch(Exception e){
            System.out.println("잘못된 입력입니다.");
            this.InputNumber();
        }


    }

    public void PrintResult(){
        this.strikeCount = model.getStrikeCount();
        this.ballCount = model.getBallCount();
        if((strikeCount == 0) && (ballCount == 0)){
            System.out.println("낫싱");
        }else if(strikeCount == 0){
            System.out.println(ballCount+" 볼");
        }else if(ballCount == 0){
            System.out.println(strikeCount+" 스트라이크 ");
        }else{
            System.out.println(strikeCount+" 스트라이크 "+ballCount+"볼");
        }
    }

    public void InputReGame(){
        System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");
        this.reGameNumber = scan.nextInt();
        switch (this.reGameNumber) {
            case 1:
                controller.ReStart();
                break;
            case 2:
                controller.ExitGame();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                this.InputReGame();
                break;
        }
    }
}
