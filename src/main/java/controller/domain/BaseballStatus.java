package controller.domain;

public interface BaseballStatus {

    int getBall();
    void setBall(int ball);

    boolean isCorrect();

    void setStrike(int strike);
    int getStrike();

}
