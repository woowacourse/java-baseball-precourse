/*
 * 클래스 이름 : GamePlay
 *
 * 버전 정보 : v 0.0.4
 *
 * 날짜 : 2019-03-27
 *
 * Copyright 2019 KwonMC
 */
package com.kwonmc.baseball;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Baseball 게임을 진행하는데 있어서 필요한 데이터와 메서드가 있는 클래스
 *
 * @version 0.0.4
 * @author KwonMC
 */
public class GamePlay {
    private int[] com = new int[3];         // 컴퓨터가 생성하는 숫자를 저장할 배열
    private int[] user = new int[3];        // 유저가 입력하는 숫자를 저장할 배열

    private boolean isFirstTime = true;     // 게임을 시작하는 처음을 알리는 boolean
    private boolean continueGame = true;    // 게임을 계속할지 여부를 결정하는 boolean

    private GameResult gameResult = new GameResult();

    /**
     * continueGame getter
     * @return this.continueGame
     */
    public boolean isContinueGame() {
        return continueGame;
    }

    /**
     * continueGame setter
     * @param continueGame 가 this.continueGame 에 배정됨
     */
    public void setContinueGame(boolean continueGame) {
        this.continueGame = continueGame;
    }

    /**
     * firstTime setter
     * @param firstTime 가 this.isFirstTime 에 배정됨
     */
    public void setFirstTime(boolean firstTime) {
        this.isFirstTime = firstTime;
    }

    /**
     * gameResult getter
     * @return gameResult
     */
    public GameResult getGameResult() {
        return gameResult;
    }

    /**
     * 길이가 3이고 중복되지 않는 1부터 9까지의 임의의 수를 만드는 메서드
     * init 을 위한 helper method
     * @return result 3개의 임의의 수를 가지고 있는 ArrayList
     */
    private ArrayList<Integer> makeRandomArrayList() {
        ArrayList<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            // 원소가 세개 모일 때까지 반복문을 실행
            int tmp = (int) (Math.random() * 9 + 1);
            if (!result.contains(tmp)) {
                // result 에 있는 원소와 중복되지 않으면 추가
                result.add(tmp);
            }
        }
        return result;
    }

    /**
     * ArrayList 를 primitive int 형 배열로 바꿔주는 메서드
     * @param arrayList 바꿀 ArrayList
     * @return primitive int 형 배열로 바뀐 ArrayList
     */
    private int[] arrayListToArray(ArrayList<Integer> arrayList) {
        int[] result = new int[3];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }

    /**
     * 게임을 초기화 하는 메서드
     */
    public void init() {
        if (this.isFirstTime) {
            ArrayList<Integer> tmpArr = makeRandomArrayList();
            this.com = arrayListToArray(tmpArr);
            this.isFirstTime = false;
        }
    }

    /**
     * 숫자를 입력해주세요 메시지를 출력하는 메서드
     */
    public void requestInputMessage() {
        System.out.print("숫자를 입력해주세요: ");
    }

    /**
     * 사용자의 입력을 받는 메서드
     * @param sc 사용자의 입력을 받을 Scanner
     */
    public void getUserInput(Scanner sc) {
        String[] userInput = sc.next().split("");
        for (int i = 0; i < this.user.length; i++) {
            this.user[i] = Integer.parseInt(userInput[i]);
        }
    }

    /**
     * countStrike 메서드와 countBall 메서드를 실행하는 메서드
     */
    public void countResult() {
        countStrike();
        countBall();
    }

    /**
     * com 배열과 user 배열의 같은 인덱스에 있는 원소가 같으면
     * gameResult 인스턴스의 strike 증가시킴.
     */
    private void countStrike() {
        for (int i = 0; i < this.user.length; i++) {
            strikeCounter(i);
        }
    }

    /**
     * 특정 인덱스에서 strike 를 카운트하는 메서드
     * @param i 인덱스
     */
    private void strikeCounter(int i) {
        if (this.com[i] == this.user[i]) {
            gameResult.oneMoreStrike();
        }
    }

    /**
     * com 배열과 user 배열의 원소 중에 인덱스가 다르고 겹치는 원소가 있으면
     * gameResult 인스턴스의 ball 증가시킴.
     */
    private void countBall() {
        for (int i = 0; i < this.com.length; i++) {
            eachBall(i);
        }
    }

    /**
     * 배열의 한 원소를 기준으로 ball 을 카운트하는 메서드
     * @param i 기준이 되는 원소의 인덱스
     */
    private void eachBall(int i) {
        for (int j = 0; j < this.user.length; j++) {
            ballCounter(i, j);
        }
    }

    /**
     * 두 배열의 각각의 위치에 있는 원소가 ball 일때 ball 을 증가시키는 메서드
     * @param i this.com 배열의 인덱스
     * @param j this.user 배열의 인덱스
     */
    private void ballCounter(int i, int j) {
        if (i != j && this.com[i] == this.user[j]) {
            gameResult.oneMoreBall();
        }
    }

    /**
     * 게임이 끝났을 때 다음 게임을 계속할 지 종료할 지 정하는 메서드
     * @param sc 유저의 입력을 받기 위한 scanner
     */
    public void getUserEndOrContinue(Scanner sc) {
        if (this.getGameResult().isEnd()) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int input = sc.nextInt();
            gameEndOrContinue(input);
        }
    }

    /**
     * 사용자의 input 에 따라 게임을 종료할지 계속할지 결정할 수 있는
     * boolean 값을 조정하는 메서드
     * @param input 유저의 인풋
     */
    private void gameEndOrContinue(int input) {
        if (input == 2) {
            this.setContinueGame(false);
        } else {
            this.setFirstTime(true);
        }
    }
}
