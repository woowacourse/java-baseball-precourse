/*
 * @(#)Gamable.java
 *
 * 1.8
 *
 * 2019/11/29
 *
 * Copyright (c) 2019 Janghee Lee
 * All rights reserved.
 * */

package com.jenny.baseball;

/*
 * 인터페이스 파일
 * 필요한 모든 기능을 선언함
 */

public interface Gamable {

    // 1. 세자리 수 생성
    int[] createNumber();

    // 2. 화면에 표시될 메시지 출력
    void showAskMsg();
    void showResult();
    void showSuccessMsg();
    void showRestartMsg();

    // 3. 사용자로부터 숫자 입력받기
    int[] getNumber();

    // 4. 입력받은 숫자의 유효성 검사
    boolean isValidNumber(int number);

    // 5. 스트라이크,볼,낫씽 여부 판단
    boolean judgeNumber(int[] userNum, int[] answer);

    // 6. 라이프사이클
    void run();

}
