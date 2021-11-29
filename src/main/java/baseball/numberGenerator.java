package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class numberGenerator {
    public String threeDigits = "123";
    public boolean[] isJudged = new boolean[3];

    public String getThreeDigits() {
        return threeDigits;
    }

    public void genThreeRandomDigits() {
        boolean[] isChecked = new boolean[10];

        StringBuilder threeRandomDigits = new StringBuilder();
        int count = 0;
        while (count != 3) {
            int rand = Randoms.pickNumberInRange(1, 9);  // generate 1 ~ 9
            if (!isChecked[rand]) {
                count++;
                isChecked[rand] = true;
                threeRandomDigits.append(String.valueOf(rand));
            }
        }

        this.threeDigits = threeRandomDigits.toString();
    }

    public int checkStrike(int numberInt) {
        String numberStr = String.valueOf(numberInt);
        int strikeCount = 0;
        for (int i = 0; i < this.threeDigits.length(); i++) {
            if (numberStr.charAt(i) == this.threeDigits.charAt(i)) {
                strikeCount++;
                this.isJudged[i] = true;
            }
        }
        return strikeCount;
    }

    public int checkBall(int numberInt) {
        String numberStr = String.valueOf(numberInt);
        int ballCount = 0;
        for (int i = 0; i < this.threeDigits.length(); i++) {
            if (this.isJudged[i]) { // 스트라이크로 판정 이미 끝난 자리는 skip
                continue;
            }

            char character = numberStr.charAt(i);
            if (this.threeDigits.indexOf(character) != -1) {
                ballCount++;
            }
        }
        this.initIsJudged();

        return ballCount;
    }

    public void initIsJudged() {
        for (int i = 0; i < 3; i++) {
            this.isJudged[i] = false;
        }
    }
}
