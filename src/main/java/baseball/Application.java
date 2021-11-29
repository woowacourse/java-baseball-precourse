package baseball;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        do {
            controller.startGame(); // 정답 숫자들을 뽑는다.
            while (!controller.processGame()); // 3스트라이크일 때까지 값을 입력받는 과정을 반복한다.
        } while (!controller.finishOrNot()); // 3스트라이크이면 게임 재시작 여부를 묻는다.
    }
}
