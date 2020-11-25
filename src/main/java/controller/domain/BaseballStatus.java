package controller.domain;

public interface BaseballStatus {

    int getBall();
    void setBall(int ball);

    boolean getCorrect();

    void setStrike(int strike);
    int getStrike();

}
