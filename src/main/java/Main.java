/*
* Class Name: main.java
* Version: ??
* Date: 2019.11.28
* Copyright(c) 2019 Sujin Cha(MIR013)
* All rights reserved.
*
* This software is made for precourse of woowacourse.
*/

//package

//import
import java.util.Scanner;

/**
 * 클래스 Main의 역할
 * 전체 게임의 흐름을 담당한다.
 * 객체들을 생성하고, 값을 입력받고, 게임시작흐름을 관리한다.
 * 어떻게보면, 사용자와 유사하다.
 */
public class Main {

    private static final int BASEBALL_SIZE = 3;         //야구게임 볼 수

    /** 전체 게임 진행 */
    public static void main(String[] agrs)
    {
        //System.out.println("hello! Wellcome to baseball game");
        //변수 생성
        Scanner scan = new Scanner(System.in);  // 입력용 스캐너
        int isGoing;                            // 게임 진행 여부

        //게임 진행
        do{
            playBaseballGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isGoing = scan.nextInt();
        }while(isGoing == 1);

    }

    /** 예외처리 throws */
    static void callBSSizeException() throws MyBaseballSizeException{
        throw  new MyBaseballSizeException(BASEBALL_SIZE);
    }

    static void callBSSameValueException() throws MyBaseballSameValueException{
        throw  new MyBaseballSameValueException();
    }

    /** 1번의 게임을 돌린다. */
    private static void playBaseballGame()
    {
        //변수 생성
        Computer computer = new Computer();      // 컴퓨터 객체 생성
        String value = new String();             // 입력값 저장용 변수
        Scanner scan = new Scanner(System.in);   // 입력용 스캐너

        //게임 시작
        do{
            do{
                value = generateValue();
            }while(value == null);
        }while(computer.checkBaseball(value));

        //게임 종료
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        return;
    }

    /** 값을 생성해온다. */
    private static String generateValue()
    {
        //변수 생성
        String value = new String();                 // 입력값 저장용 변수
        Scanner scan = new Scanner(System.in);       // 입력용 스캐너

        try{
            System.out.print("숫자를 입력해주세요: ");
            value = scan.nextLine();

            //예외사항1. 입력 사이즈가 안맞을 경우
            if (value.length() != BASEBALL_SIZE){
                callBSSizeException();
            }
            //예외사항2. 서로 다른 수를 입력하지 않았을 경우
            if (isSameValue(value)){
                callBSSameValueException();
            }
        }catch (MyBaseballSizeException e){
            System.out.println(e.getMessage());
            System.out.println("다시 입력해 주세요");
            value = null;
            //e.printStackTrace();
            //이 후에 에러로 종료시킬 수 없나?
        }catch (MyBaseballSameValueException e2){
            System.out.println(e2.getMessage());
            System.out.println("다시 입력해 주세요");
            value = null;
        }

        return value;
    }

    /** 같은 값을 입력으로 준 경우를 체크한다. */
    public static boolean isSameValue(String value)
    {
        boolean isDuplicate = false;                 // 중복 여부
        char firstChar = value.charAt(0);             // value의 첫번째 값
        char secondChar = value.charAt(1);            // value의 두번째 값
        char thirdChar = value.charAt(2);             // value의 세번째 값

        if (firstChar == secondChar){
            isDuplicate = true;
        }else if (firstChar == thirdChar){
            isDuplicate = true;
        }else if (secondChar == thirdChar){
            isDuplicate = true;
        }

        return isDuplicate;
    }

}

/** 숫자 야구 게임의 입력값을 위한 예외처리를 담당 */
class MyBaseballSizeException extends Exception{
    public MyBaseballSizeException(int baseballSize){
        super("[ERROR] 숫자 야구 게임의 입력 값은 "+baseballSize+"자리 입니다.");
    }
}

class MyBaseballSameValueException extends Exception{
    public MyBaseballSameValueException(){
        super("[ERROR] 숫자 야구 게임의 입력 값은 중복이 되면 안됩니다.");
    }
}