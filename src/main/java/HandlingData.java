import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/*
 * 입력된 Data를 바탕으로 해당 Data를 숫자야구게임에 맞게 처리하는 클래스
 *
 * @verison         1.00 2019년 3월 23일
 * @author          김강민
 */
public class HandlingData {

    private Model model;
    private static HandlingData handlingData;
    private int[] computerNumber;
    private int[] userNumber;
    private int strikeCount;
    private int ballCount;
    private HashSet<Integer> hashSet = new HashSet<>();

    HandlingData(){
        this.model = Model.getModel();
    }

    public static HandlingData getHandlingData() {
        if(handlingData ==null){
            handlingData = new HandlingData();
        }
        return handlingData;
    }


    /*
     * Model의 데이터를 가져와서 데이터를 비교하고 스트라이크, 볼을 판단합니다.
     */
    public void JudgeStrike(){

        this.strikeCount = 0;
        this.ballCount = 0;

        this.computerNumber = model.getComputerNumber();
        this.userNumber = model.getUserNumber();
        this.hashSet = model.getHashSet();

        for(int i=0; i<3; i++){
            System.out.println(this.computerNumber[i]+" " +this.userNumber[i]);
        }

        for(int i=0; i<3; i++){
            if(this.computerNumber[i] == this.userNumber[i]){
                strikeCount++;
            }else if(this.hashSet.contains(this.userNumber[i])){
                ballCount++;
            }
        }
        model.setStrikeCount(strikeCount);
        model.setBallCount(ballCount);
    }
}
