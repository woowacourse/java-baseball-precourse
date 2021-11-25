package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        setAnswer();
        input();

    }

    public static int[] setAnswer(){
        Computer computer = new Computer();
        int[] answer = computer.generateAnswer();
        return answer;
    }


    public static int[] input(){
        Player player = new Player();
        int[] getInput = player.getInput();
        return getInput;
    }



}
