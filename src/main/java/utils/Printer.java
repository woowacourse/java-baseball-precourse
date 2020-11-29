package utils;

public class Printer {
    public static String getResultString(int[] ballsAndStrikes) {
        int balls = ballsAndStrikes[0];
        int strikes = ballsAndStrikes[1];

        if (balls == 0 && strikes == 0) {
            return "낫싱";
        }

        StringBuilder outputBuilder = new StringBuilder();

        if (balls > 0) {
            outputBuilder.append(balls).append("볼");
        }

        if (strikes > 0) {
            if (balls > 0) {
                outputBuilder.append(" ");
            }

            outputBuilder.append(strikes).append("스트라이크");
        }

        return outputBuilder.toString();
    }
}
