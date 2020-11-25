package view;

import controller.domain.BaseballStatus;

public class PrinterImpl implements Printer {

    private static final int NONE = 0;

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_MENTION = "숫자를 입력해주세요 : ";
    private static final String NOTHING = "낫싱";

    @Override
    public String printInputDescription() {
        return INPUT_MENTION;
    }

    @Override
    public String printStatus(BaseballStatus dto) {

        String message = null;

        if(dto.getBall() == NONE && dto.getStrike() == NONE) {
            message = NOTHING;
        } else if (dto.getBall() != NONE && dto.getStrike() == NONE) {
            message = ballToString(dto.getBall());
        } else if (dto.getStrike() != NONE && dto.getBall() == NONE) {
            message = strikeToString(dto.getStrike());
        } else if (dto.getBall() != NONE && dto.getStrike() != NONE) {
            message = ballToString(dto.getBall()) + " " + strikeToString(dto.getStrike());
        }

        return message;
    }

    @Override
    public String printCorrect() {
        return CORRECT;
    }

    private String ballToString(int ball) {
        return ball + BALL;
    }

    private String strikeToString(int strike) {
        return strike + STRIKE;
    }

}
