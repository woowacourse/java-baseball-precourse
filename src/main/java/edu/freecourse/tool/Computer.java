package edu.freecourse.tool;

import java.util.Random;

public class Computer {

    private int[] numbers = new int[3];

    /**
     * 1 부터 9까지 서로 다른 3개의 수 선택
     */
    public void newGame() {
        Random random = new Random();
        int BOUND = 9;
        boolean flag = true;
        int temp = 0;

        for (int i = 0; i < numbers.length; i++) {

            while (flag) {
                temp = random.nextInt(BOUND) + 1;       /* 1 ~ 9 */
                flag = checkNumber(temp, i);         /* 중복이면 true */
            }

            numbers[i] = temp;
            flag = true;
        }

    }

    /**
     * 유저가 입력한 숫자를 입력해서 결과를 반환
     * @param userNum 유저가 입력한 숫자, 3자리수만 들어와야함
     * @return result[0]: 스트라이크 수, result[1]: 볼 수
     */
    public int[] answerResult (int userNum) throws Exception {
        int[] result = new int[2];
        int strike = 0;
        int ball = 0;
        String num = String.valueOf(userNum);

        if (num.length() != 3 ) {
            throw new Exception("3자리 숫자를 입력해주세요.");
        }

        /* 유저가 입력한 숫자 하나씩 판별하기 */
        for (int i = 0; i < num.length(); i++) {

            int c = Integer.parseInt(num.substring(i, i+1));

            if (isStrike(c, i)) {
                strike++;
            }

            if (isBall(c)) {
                ball++;
            }
        }

        result[0] = strike;
        result[1] = ball-strike;

        return  result;
    }

    /**
     * 스트라이크인지 판별하는 함수
     * @param num 판별할 숫자
     * @param index 판별할 위치
     * @return true: 스트라이크, false: 스트라이크 아님
     */
    private boolean isStrike (int num, int index) {
        boolean result = false;

        if (numbers[index] == num) {
            result = true;
        }

        return result;
    }

    /**
     * 볼인지 판별하는 함수
     * @param num 판별할 숫자
     * @return true: 볼 , false: 볼 아님
     */
    private boolean isBall (int num) {
        boolean result = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num) {
                result = true;
            }
        }

        return result;
    }

    /**
     * 중복된 숫자가 있는지 확인
     * @param num 중복을 확인할 숫자
     * @param index 이 위치 전까지 중복된 숫자 체크
     * @return 중복이 없으면 false, 중복이 있으면 true
     */
    private boolean checkNumber(int num, int index) {
        boolean result = false;

        for(int i = 0; i < index; i++){
            if(num == numbers[i]){
                result = true;
            }
        }

        return result;
    }

    public int[] getNumbers() {

        return numbers;
    }

}
