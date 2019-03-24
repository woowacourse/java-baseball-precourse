package com;

/**
 * 숫자야구 게임이 시작되는 클래스
 */
public class AppMain {

    /**
     * NumberBaseball 객체를 생성하여 게임을 진행하는 메소드
     * @param args
     */
    public static void main(String[] args){
        NumberBaseball numberBaseball = new NumberBaseball();

        do{
            /* 컴퓨터 난수 발생 */
            numberBaseball.setComNumber();

            /* 컴퓨터 난수 맞히기 */
            numberBaseball.guessComNumber();

        }while(numberBaseball.checkEndOrNot());     // 종료 여부를 묻고 게임을 계속 진행할지 말지 결정
    }
}
