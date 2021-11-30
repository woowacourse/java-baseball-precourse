package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Target {
    public static final int BALL = 0;
    public static final int STRIKE = 1;

    private String targetNumber;

    private int rangeBegin = 1;
    private int rangeEnd = 9;
    private int length = 3;

    public void generateTargetNumber() {
        StringBuilder builder = new StringBuilder();
        boolean[] visited = new boolean[rangeEnd - rangeBegin + 1];
        for (int i = 0; i < length; i++) {
            int num;
            num = pickNumberInRange(rangeBegin, rangeEnd - i);
            while (visited[num - rangeBegin]) {
                num++;
            }
            visited[num - rangeBegin] = true;
            builder.append(num);
        }
        targetNumber = builder.toString();
    }

    public int[] compareWith(String userNumber) {
        int ball = 0;
        int strike = 0;

        for (int u = 0; u < length; u++) {
            int index = find(userNumber.charAt(u));

            if (index < 0) {
                //index가 -1인 경우는 숫자가 없는 경우이다.
            } else if (index == u) {
                strike++;
            } else if (index != u) {
                ball++;
            }
        }
        return new int[] {ball, strike};
    }

    public int find(char ch) {
        for (int i = 0; i < length; i++) {
            if (targetNumber.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }

    public int getRangeBegin() {
        return this.rangeBegin;
    }

    public void setRangeBegin(int rangeBegin) {
        if (this.rangeEnd - rangeBegin + 1 >= length) {
            this.rangeBegin = rangeBegin;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getRangeEnd() {
        return this.rangeEnd;
    }

    public void setRangeEnd(int rangeEnd) {
        if (rangeEnd - this.rangeBegin + 1 >= length) {
            this.rangeEnd = rangeEnd;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (this.rangeEnd - this.rangeBegin + 1 >= length) {
            this.length = length;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isEqual(Target compare) {
        return this.targetNumber.equals(compare.targetNumber);
    }
}
