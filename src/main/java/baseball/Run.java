package baseball;

public class Run {
    static Answer answer;
    static Player player;

    public void Run(){
        answer = new Answer();
        player = new Player();

        while(true){
            player.inputThreeNumbers();
            Hint hint = new Hint(0,0);
            hint.compareAnswerAndPlayerNumber(answer.getAnswers(), player.getNumbers());
            hint.printHint();
            if(hint.getStrike() == Constants.MAX_LEN){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임을 종료합니다 :)\n");
                break;
            }
        }
    }
}
