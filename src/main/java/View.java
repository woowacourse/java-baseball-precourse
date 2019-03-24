import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

/*
 * 숫자야구 게임에서 사용자의 입력을 받고, 사용자에게 출력을 해주는 클래스
 *
 * @verison         1.00 2019년 3월 23일
 * @author          김강민
 */
public class View {

    private Model model;
    private static View view;
    private Scanner scan = new Scanner(System.in);
    private int userNumber;
    private Controller controller;

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
     * 사용자의 첫번째 입력을 받는 곳입니다.
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
        System.out.println("PrintResult 실행!");
    }

    public int InputReGame(){
        System.out.println("InputReGame 실행!");
        return 2;
    }




}
