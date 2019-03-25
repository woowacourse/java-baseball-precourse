import java.util.HashSet;

/*
 * 입력된 Data를 바탕으로 해당 Data를 숫자야구게임에 맞게 처리하는 클래스
 *
 * @author          김강민
 */
public class HandlingData {

    private static HandlingData handlingData;
    private BaseballData baseballData;
    private int[] computerNumber;
    private int[] userNumber;
    private int strikeCount;
    private int ballCount;
    private HashSet<Integer> hashSet = new HashSet<>();

    HandlingData(){
        this.baseballData = BaseballData.getBaseballData();
    }

    public static HandlingData getHandlingData() {
        if(handlingData ==null){
            handlingData = new HandlingData();
        }
        return handlingData;
    }

    /*
     * BaseballData의 데이터를 가져와서 데이터를 비교하고 스트라이크, 볼을 판단합니다.
     */
    public void JudgeStrike(){

        this.strikeCount = 0;
        this.ballCount = 0;

        this.computerNumber = baseballData.getComputerNumber();
        this.userNumber = baseballData.getUserNumber();
        this.hashSet = baseballData.getHashSet();

        for(int i=0; i<3; i++){
            if(this.computerNumber[i] == this.userNumber[i]){
                strikeCount++;
            }else if(this.hashSet.contains(this.userNumber[i])){
                ballCount++;
            }
        }
        baseballData.setStrikeCount(strikeCount);
        baseballData.setBallCount(ballCount);
    }
}
