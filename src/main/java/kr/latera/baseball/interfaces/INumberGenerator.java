package kr.latera.baseball.interfaces;

public interface IGenerator {

    int NUMS_LENGTH = 3;

    // 각 숫자의 최대/최솟값
    int MIN_FOR_EACH_NUM = 1;
    int MAX_FOR_EACH_NUM = 9;

    int[] generateNumber();
}
