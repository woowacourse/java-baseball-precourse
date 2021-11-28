package baseball;

import org.junit.jupiter.api.Test;

class BaseBallGameTest {

    //사용자 입력 예외 처리 확인
    @Test
    public void 사용자_입력(){
        BaseBallGame baseBallGame = new BaseBallGame();

        try{
            String input = "123";
            baseBallGame.validate(input);
        }
        catch (IllegalArgumentException e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}