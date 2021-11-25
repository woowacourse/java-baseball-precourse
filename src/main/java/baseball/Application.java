package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Controller controller = new Controller();
        try {
            controller.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
