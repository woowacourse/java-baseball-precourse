package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.hint.Hint;
import baseball.domain.pitch.Pitch;
import baseball.domain.player.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.finalstring.PrintValue.*;

public class Game {
    private Computer computer;
    private Player player;
    private Hint hint;
    private boolean playing = true;

    public void play() {
        // 게임 한 판의 플레이이다.
        while(playing) {
            computer = new Computer();
            // 생성된 난수 리스트를 통해 컴퓨터의 Pitch 집합을 생성한다.
            computer.setPitchSet(getPitchSet(computer.getNumberList()));
            ask();
        }
    }

    private void ask() {
        player = new Player();
        boolean finished = false;

        // 게임 한 턴의 플레이이다.
        while(!finished) {
            // 질문 출력
            System.out.print(START.getContent());
            // 사용자로부터 입력
            player.input();
            // 사용자로부터 입력받은 문자(숫자)를 통해 Pitch 집합을 생성한다.
            player.setPitchSet(getPitchSet(player.getNumberList()));
            // Computer와 Player의 Pitch 집합들을 통해 Hint 객체를 생성한다.
            hint = new Hint(computer.getPitchSet(), player.getPitchSet());

            print(hint);

            finished = checkEnd(hint.isEnd());
        }
    }

    public Set<Pitch> getPitchSet(List<Integer> list) {
        // 각 자리수별 만들 Pitch를 담을 집합 자료구조이다.
        Set<Pitch> pitchSet = new HashSet<>();

        // 각 자리 index를 돌면서 Pitch를 생성하고, 집합 자료구조에 넣어준다.
        for(int i=0; i<3; i++) {
            pitchSet.add(new Pitch(i + 1, list.get(i)));
        }

        return pitchSet;
    }

    private void print(Hint hint) {
        // 볼이 있으면 우선 출력해준다. ex) 1볼
        if(hint.hasBall()) {
            System.out.print(hint.getBall() + BALL.getContent() + " ");

            // 스트라이크가 있으면 출력해준다. ex) 1볼 1스트라이크
            if (hint.hasStrike()) {
                System.out.print(hint.getStrike() + STRIKE.getContent());
            }

            System.out.println();
            return ;
        }

        // 스트라이크가 있으면 출력해준다. ex) 1스트라이크
        if (hint.hasStrike()) {
            System.out.println(hint.getStrike() + STRIKE.getContent());
            return ;
        }

        System.out.println(NOTHING.getContent());
    }


    private boolean checkEnd(boolean result) {
        if(result) {
            System.out.print(FINISH.getContent());
            return askEnd();
        }
        return false;
    }

    private boolean askEnd() {
        System.out.println(ASK_END.getContent());

        if(player.endRead() == 2) {
            playing = false;
        }
        return true;
    }

}
