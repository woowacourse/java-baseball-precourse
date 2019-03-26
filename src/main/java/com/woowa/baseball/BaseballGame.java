package com.woowa.baseball;


import java.util.Scanner;

/**
 * 숫자 야구 게임의 진행을 담당하는 클래스
 *
 * @version 1.0
 * @since 03/26/2019
 * @author icarus8050
 */
public class BaseballGame implements Game {
    private UniqueNumberMaker uniqueNumberMaker;
    private ValidNumberConverter validNumberConverter;
    private Scanner input;

    public BaseballGame() {
        uniqueNumberMaker = new UniqueNumberMaker();
        validNumberConverter = new ValidNumberConverter();
        input = new Scanner(System.in);
    }

    /**
     * 게임 실행 메서드
     *
     * @return  게임 재실행 시, true; 게임 종료 시, false
     */
    @Override
    public boolean run(){
        UniqueNumber answer = uniqueNumberMaker.create();   //무작위 정답 생성

        /* 정답을 맞출 때까지 루프를 진행한다. */
        while (true) {
            int[] queryNumber = inputQueryNumber();

            /* hint[0]은 스트라이크 수, hint[1]은 볼 수 */
            int[] hint = answer.compareTo(queryNumber);

            if (hintCheck(hint)) {

                //정답인 경우 진행을 멈춤
                break;
            }
        }

        /* 재시작 시, true; 게임 종료 시, false */
        return (isContinue() ? true : false);
    }

    /**
     * 게임이 종료될 때 수행되어야 하는 로직
     */
    @Override
    public void exit() {
        input.close();
    }

    /**
     * 사용자로부터 3개의 숫자를 입력받는 메서드
     * 유효하지 않은 숫자에 대해서는 예외처리되어 다시 재입력받는다.
     *
     * @return  사용자가 입력한 유니크한 질의 숫자
     */
    private int[] inputQueryNumber() {

        /* 사용자가 입력한 유니크한 질의 숫자를 담을 변수 */
        int[] queryNumber;

        /* 유효한 숫자가 입력될 때까지 루프를 진행 */
        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");

                /* 유효한 입력 값의 질의 숫자 배열 생성 */
                queryNumber = validNumberConverter.convert(input.nextLine());
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        return queryNumber;
    }

    /**
     * 입력에 대한 힌트를 체크하는 메서드
     *
     * @param hint  사용자가 입력을 통해 얻은 힌트 [0] = strike, [1] = ball
     * @return      정답을 맞췄을 경우 true, 아닌경우 false
     */
    private boolean hintCheck(int[] hint) {

        /* 정답인 경우 */
        if (hint[0] == 3) {
            System.out.println(hint[0] + " " + "스트라이크 ");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        /* 정답이 아닌 경우의 출력 */
        if ((hint[0] == 0) && (hint[1] == 0)) {
            System.out.println("낫싱");
        } else {
            if (hint[0] != 0) {
                System.out.print(hint[0] + " " + "스트라이크 ");
            }

            if (hint[1] != 0) {
                System.out.print(hint[1] + "볼");
            }

            System.out.println();
        }

        return false;
    }

    /**
     * 게임 종료 후, 게임 재시작 여부를 묻는 메서드
     *
     * @return  재시작 시, true; 종료 시, false
     */
    private boolean isContinue() {

        /* 올바른 명령이 입력될 때까지 루프를 진행 */
        while (true) {
            System.out.println("게임을 새로 시작하시려면 1, 종료하시려면 2를 입력하세요.");
            String command = input.nextLine();

            /* 1이나 2 이외의 숫자를 입력했는지 검사 */
            if ((!command.equals("1")) && (!command.equals("2"))) {
                System.out.println("입력 값이 잘못되었습니다.");
            } else {
                return ((command.equals("1")) ? true : false);
            }
        }
    }
}
