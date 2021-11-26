package input;

import org.junit.jupiter.api.Test;


//TDD
class UserTest {

    @Test
    void 사용자_입력_테스트(){
        // given
        User user=new User();
        // when
        String userInput="111",userInput2="1",userInput3="1a0";
        // then
        user.checkException(userInput);
    }
//    @Test
//    void 사용자_입력_테스트_크기(){
//        // given
//        User user=new User();
//        // when
//        String userInput="1";
//        // then
//        user.checkException(userInput);
//    }
//    @Test
//    void 사용자_입력_테스트_범위(){
//        // given
//        User user=new User();
//        // when
//        String userInput="1a0";
//        // then
//        user.checkException(userInput);
//    }
}