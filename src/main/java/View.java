
/*
 * 숫자야구 게임에서 사용자의 입력을 받고, 사용자에게 출력을 해주는 클래스
 *
 * @verison         1.00 2019년 3월 23일
 * @author          김강민
 */
public class View {

    private Model model;
    private static View view;

    View(){
        this.model = Model.getModel();
    }

    public static View getView() {
        if(view==null){
            view = new View();
        }
        return view;
    }

    public void InputNumber(){
        System.out.println("IntputNumber 실행!");
    }

    public void PrintResult(){
        System.out.println("PrintResult 실행!");
    }

    public int InputReGame(){
        System.out.println("InputReGame 실행!");
        return 2;
    }




}
