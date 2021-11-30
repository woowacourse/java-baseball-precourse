package baseball.game;

import baseball.PrintValue;
import baseball.computer.Computer;
import baseball.hint.Hint;
import baseball.pitch.Pitch;
import baseball.player.Player;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private Computer computer;
    private Player player;
    private Hint hint;
    private boolean playing = true;

    public void play() {
        while(playing) {
            computer = new Computer();
            computer.setPitchSet(getPitchSet(computer.getNumber()));
            ask();
        }
    }

    private void ask() {
        player = new Player();
        boolean finished = false;

        while(!finished) {
            // try catch 해야할지?
            System.out.print(PrintValue.START.getContent());
            int target = player.playRead();
            player.setPitchSet(getPitchSet(target));
            hint = new Hint(computer.getPitchSet(), player.getPitchSet());

            print(hint);
            finished = checkEnd(hint.isEnd());
        }
    }

    public Set<Pitch> getPitchSet(int num) {
        // 각 자리수별 만들 Pitch를 담을 집합 자료구조이다.
        Set<Pitch> pitchSet = new HashSet<>();
        // 각 자리수에 index로 접근하기 위해 String 으로 변환시켜준다.
        String numStr = String.valueOf(num);

        // 각 자리 index를 돌면서 Pitch를 생성하고, 집합 자료구조에 넣어준다.
        for(int i=0; i<3; i++) {
            pitchSet.add(new Pitch(i + 1, numStr.charAt(i) -'0'));
        }

        return pitchSet;
    }

    private void print(Hint hint) {
        // 볼이 있으면 우선 출력해준다. ex) 1볼
        if(hint.hasBall()) {
            System.out.print(hint.getBall() + PrintValue.BALL.getContent() + " ");

            // 스트라이크가 있으면 출력해준다. ex) 1볼 1스트라이크
            if (hint.hasStrike())
                System.out.print(hint.getStrike() + PrintValue.STRIKE.getContent());

            System.out.println();
            return ;
        }

        // 스트라이크가 있으면 출력해준다. ex) 1스트라이크
        if (hint.hasStrike()) {
            System.out.println(hint.getStrike() + PrintValue.STRIKE.getContent());
            return ;
        }

        System.out.println(PrintValue.NOTHING.getContent());
    }


    private boolean checkEnd(boolean result) {
        if(result) {
            System.out.print(PrintValue.FINISH.getContent());
            return askEnd();
        }
        return false;
    }

    private boolean askEnd() {
        System.out.println(PrintValue.ASK_END.getContent());
        int i = player.endRead();
        if(i == 2) {
            playing = false;
        }
        return true;

    }

}
