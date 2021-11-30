package baseball;

class OutputManager {

    public void printResultOutput(Result result) {
        System.out.println(result.toString());
    }

    public void printEndGameOutput() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRestartGameOutput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
