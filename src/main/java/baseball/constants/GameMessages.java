package baseball.constants;

public interface GameMessages {

    String PROMPT_USER_EXPECTATION = "숫자를 입력해주세요 : ";
    String PROMPT_GAME_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    String OUT_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    String ERR_MESSAGE_NON_NUMBER = "숫자만 입력해주세요.";
    String ERR_MESSAGE_OUT_OF_RANGE = "1 ~ 9 까지 숫자만 입력해주세요.";
    String ERR_MESSAGE_WRONG_SIZE = "3 개의 숫자만 입력해주세요";
    String ERR_MESSAGE_DUPLICATE = "중복된 숫자가 있습니다.";
    String RESTART_FLAG_ERR_MESSAGE= "1 또는 2 만 입력해주세요";
}
