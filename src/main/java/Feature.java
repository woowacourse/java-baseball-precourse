import java.util.HashMap;

public class Feature {

    // 클래스 안에 클래스 holder를 두는 Singleton
    private Feature(){ }
    private static class Featureholder{ public static final Feature INSTANCE = new Feature();}
    public static Feature getInstance(){ return Feature.Featureholder.INSTANCE; }

//    public String checkNum(){
//
//    }

}
