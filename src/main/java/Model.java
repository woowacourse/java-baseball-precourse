import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/*
 * 숫자야구 게임에 필요한 데이터들을 보관하는 클래스
 *
 * @author          김강민
 */
public class Model {

    private static Model model;
    private int[] computerNumber;
    private int[] userNumber;
    private int strikeCount;
    private int ballCount;
    private HashSet<Integer> computerNumberSet;

    Model(){
        computerNumber = new int[3];
        userNumber = new int[3];
        computerNumberSet = new HashSet<>();
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public HashSet<Integer> getHashSet() {
        return computerNumberSet;
    }

    public void setHashSet(HashSet<Integer> hashSet) {
        this.computerNumberSet = hashSet;
    }

    public static Model getModel() {
        if(model ==null){
            model = new Model();
        }
        return model;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int[] getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int[] userNumber) {
        this.userNumber = userNumber;
    }

    public int[] getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(int[] computerNumber) {
        this.computerNumber = computerNumber;
    }
}
