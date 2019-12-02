/**
 * Referee.java
 * 아직 리팩토링 중...
 * 우아한테크코스 프리코스 1주차.
 * Original code https://github.com/hotheadfactory/java-baseball-precourse
 * Version: v0.0.1, 2019.11.29 (c) 정회형
 */

public class Referee {
    public int[] countStrikeBall(int[] userNum, int[] computerNum) {
        int[] strikeBall = new int[]{0, 0};
        int[] userIndex = new int[10];
        int[] computerIndex = new int[10];
        for (int i = 0; i < userNum.length; i++) {
            userIndex[userNum[i]] = 1;
            computerIndex[computerNum[i]] = 1;
            if (userNum[i] == computerNum[i]) {
                strikeBall[0]++;
                continue;
            }
            if (userIndex[computerNum[i]] == 1) {
                strikeBall[1]++;
            }
            if (computerIndex[userNum[i]] == 1) {
                strikeBall[1]++;
            }

        }
        return strikeBall;
    }
}
