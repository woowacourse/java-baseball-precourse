package com.github.callmewaggs.javabaseballprecourse;

public class Computer {
    private int[] numbers;

    public Computer() {
        this.numbers = new int[3];
    }

    public void generateRandomBall() {
        int[] candidates = new int[9];

        // 1 ~ 9 까지 숫자 할당. 인덱스 범위는 0 ~ 8 까지
        for(int i = 0 ; i < candidates.length; ++i) {
            candidates[i] = i + 1;
        }

        // Shuffle - 1000번 정도 섞으면 잘 섞이겠지
        for(int i = 0 ; i < 1000; ++i) {
            // 임의의 인덱스. 범위는 0 ~ 8 사이여야 함.
            int index1 = (int) (Math.random() * 1000) % 9;
            int index2 = (int) (Math.random() * 100) % 9;

            candidates[index1] = candidates[index1] ^ candidates[index2] ^ (candidates[index2] = candidates[index1]);
        }

        // 앞에서부터 세자리 숫자 사용
        for(int i = 0 ; i < 3; ++i) {
            numbers[i] = candidates[i];
        }
    }
}
