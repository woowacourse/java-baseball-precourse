package baseball.BaseballSystem.judgement;

import java.util.HashSet;
import java.util.Set;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.dto.response.JudgementResultDto;

public class JudgementServiceImpl implements JudgementService {

    static private final JudgementServiceImpl judgementServiceImpl = new JudgementServiceImpl();

    private JudgementServiceImpl() {}

    public static JudgementServiceImpl getInstance() {
        return judgementServiceImpl;
    }

    @Override
    public JudgementResultDto matchTheNumbers(Player player, Computer computer) {
        String playerNumber = player.getInputNumber();
        String computerNumber = computer.getRandomNumbers();
        int strike = strikeCount(playerNumber, computerNumber);
        int ball = ballCount(playerNumber, computerNumber, strike);
        boolean isCorrect = isFullStrike(strike);
        String resultMessage = showJudgementResult(strike, ball);
        return new JudgementResultDto(isCorrect, resultMessage);
    }

    @Override
    public String showJudgementResult(int strike, int ball) {
        if (isFullStrike(strike)) {
            return JudgementMessage.fullStrikeMessage(strike);
        } else if (isNothing(strike, ball - strike)) {
            return JudgementMessage.notThingMessage();
        } else if (isOnlyBall(strike, ball)) {
            return JudgementMessage.ballMessage(ball);
        } else if (isOnlyStrike(strike, ball)) {
            return JudgementMessage.strikeMessage(strike);
        } else if (isBallAndStrike(strike, ball)) {
            return JudgementMessage.ballAndStrikeMessage(ball, strike);
        } else {
            throw new RuntimeException("dev Mistake");
        }
    }

    private int strikeCount(final String playerNumber, final String computerNumber) {
        int strike = 0;
        for (int index = 0; index < FIX_NUMBER_LENGTH; index++) {
            char playerCharacter = playerNumber.charAt(index);
            char computerCharacter = computerNumber.charAt(index);
            if (playerCharacter == computerCharacter) {
                strike++;
            }
        }
        return strike;
    }

    private int ballCount(final String playerNumber, final String computerNumber, final int strike) {
        int ball = 0;
        Set<Character> playerNumberBuckets = new HashSet<>();
        for (int index = 0; index < FIX_NUMBER_LENGTH; index++) {
            playerNumberBuckets.add(playerNumber.charAt(index));
        }
        for (int index = 0; index < FIX_NUMBER_LENGTH; index++) {
            if (playerNumberBuckets.contains(computerNumber.charAt(index))) {
                ball++;
            }
        }
        return ball - strike;
    }

    private boolean isFullStrike(int strike) {
        return strike == FULL_STRIKE;
    }

    private boolean isNothing(int strike, int ball) {
        return strike == ALL_NOT_HIT && ball == ALL_NOT_HIT;
    }

    private boolean isOnlyBall(int strike, int ball) {
        return strike == ALL_NOT_HIT && ball != ALL_NOT_HIT;
    }

    private boolean isOnlyStrike(int strike, int ball) {
        return strike != ALL_NOT_HIT && ball == ALL_NOT_HIT;
    }

    private boolean isBallAndStrike(int strike, int ball) {
        return strike != ALL_NOT_HIT && ball != ALL_NOT_HIT;
    }

}
