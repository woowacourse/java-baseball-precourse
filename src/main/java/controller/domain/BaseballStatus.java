package controller.domain;

public interface BaseballStatus {

    int getBall();
    void setBall(int ball);

    boolean isCorrect();

    void initialization();

    void setStrike(int strike);
    int getStrike();

}
