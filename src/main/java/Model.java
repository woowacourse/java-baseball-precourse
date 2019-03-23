
/*
 * 숫자야구 게임에 필요한 데이터들을 보관하는 클래스
 *
 * @verison         1.00 2019년 3월 23일
 * @author          김강민
 */
public class Model {

    private static Model model;

    Model(){

    }

    public static Model getModel() {
        if(model ==null){
            model = new Model();
        }
        return model;
    }
}
