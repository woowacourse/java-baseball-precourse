package baseball.model;

public class NumberJudge {
    public Result judge(String target, String input) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            if (target.charAt(i) == input.charAt(i)) {
                strikeCount++;
            } else if (target.contains(String.valueOf(input.charAt(i)))) {
                ballCount++;
            }
        }

        return new Result(strikeCount, ballCount);
    }
}
