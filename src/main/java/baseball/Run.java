/*
 * @(#)Run.java
 *
 */

package baseball;

public class Run {
    static Answer answer;
    static Player player;
    static Hint hint = new Hint();

    public Run(){

    }

    /**
     * 실질적인 숫자 야구 게임의 로직을 담고 있는 메소드입니다.
     */
    public void Run(){
        answer = new Answer();
        player = new Player();

        while (true) {
            player.inputThreeNumbers();

            hint.setHint(0,0);// strike와 ball을 모두 0으로 초기화한 Hint 객체 생성
            hint.compareAnswerAndPlayerNumber(answer.getAnswers(), player.getNumbers());
            hint.printHint();
            if(hint.getStrike() == Constants.MAX_LEN){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임을 종료합니다 :)\n");
                break;
            }
        }
    }
}
