package baseball.baseballsystem.judgement;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.dto.response.JudgementResultDto;

public interface JudgementService {

    final int FIX_NUMBER_LENGTH = 3;
    final int FULL_STRIKE = 3;
    final int ALL_NOT_HIT = 0;

    public JudgementResultDto matchTheNumbers(Player player, Computer computer);

    public String showJudgementResult(int strike, int ball);
}
