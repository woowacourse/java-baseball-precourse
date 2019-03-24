import java.util.HashSet;

/*
 * 숫자야구 게임에 필요한 데이터들을 보관하는 클래스
 *
 * @verison         1.00 2019년 3월 23일
 * @author          김강민
 */
public class Model {

    private static Model model;
    private int[] computerNumber;
    private int[] userNumber;

    Model(){
        computerNumber = new int[3];
        userNumber = new int[3];
    }

    public static Model getModel() {
        if(model ==null){
            model = new Model();
        }
        return model;
    }

    public int[] getUserNumber() {
        return userNumber;
    }

    public static void setModel(Model model) {
        Model.model = model;
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
