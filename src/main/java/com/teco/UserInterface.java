package com.teco;

/**
 * 사용자 인터페이스
 *
 * @author 김성훈
 * @version 1.0
 */
public interface UserInterface {
    String[] getUserRandomNumber() throws IllegalArgumentException;

    void printResult(String result);

    void printEndMessage();

    String checkEndOrNot() throws IllegalArgumentException;
}
