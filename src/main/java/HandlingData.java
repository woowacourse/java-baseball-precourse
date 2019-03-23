
/*
 * 입력된 Data를 바탕으로 해당 Data를 숫자야구게임에 맞게 처리하는 클래스
 *
 * @verison         1.00 2019년 3월 23일
 * @author          김강민
 */
public class HandlingData {

    private Model model;
    private static HandlingData handlingData;

    HandlingData(){
        this.model = Model.getModel();
    }

    public static HandlingData getHandlingData() {
        if(handlingData ==null){
            handlingData = new HandlingData();
        }
        return handlingData;
    }

    public void JudgeStrike(){
        System.out.println("JudgeStrike 실행!");
    }
}
