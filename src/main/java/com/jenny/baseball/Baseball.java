package com.jenny.baseball;

public class Baseball implements Gamable {

    @Override
    public int[] createNumber() {
        return new int[0];
    }

    @Override
    public void showAskMsg() {

    }

    @Override
    public void showResult() {

    }

    @Override
    public void showSuccessMsg() {

    }

    @Override
    public void showRestartMsg() {

    }

    @Override
    public int[] getNumber() {
        return new int[0];
    }

    @Override
    public boolean isValidNumber(int number) {
        return false;
    }

    @Override
    public boolean judgeNumber(int[] userNum, int[] answer) {
        return false;
    }

    @Override
    public int wantRestart() {
        return 0;
    }

    @Override
    public void run() {

    }
}
