/*
 * Baseball class
 *
 * v0.1
 *
 * 2019.03.25
 *
 * Copyrights
 */

package woowatechcourse.woung717.baseball;

import java.util.Set;
import java.util.HashSet;

public class Baseball {
    private String answer;

    public Baseball(BaseballAnswer ans) {
        this.answer = ans.getAnswer();
    }

    private Set<String> getStrikes(String query) {
        Set<String> strikeNumbers = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            if (this.answer.charAt(i) == query.charAt(i)) {
                strikeNumbers.add(this.answer.substring(i, i + 1));
            }
        }

        return strikeNumbers;
    }

    private Set<String> getExclusives(String one, Set<String> other) {
        Set<String> exclusives = new HashSet<>();

        for (char ch: one.toCharArray()) {
            String s = Character.toString((ch));

            if (!other.contains(s)) {
                exclusives.add(s);
            }
        }

        return exclusives;
    }

    private Set<String> getBalls(String query, Set<String> strikes) {
        Set<String> answerBallCandidates = this.getExclusives(this.answer, strikes);
        Set<String> queryBallCandidates = this.getExclusives(query, strikes);

        Set<String> ballNumbers = new HashSet<>();

        for (String answerElement: answerBallCandidates) {
            if (queryBallCandidates.contains(answerElement)) {
                ballNumbers.add(answerElement);
            }
        }

        return ballNumbers;
    }

    public Result getResponse(String query) {
        StringBuilder resultMessage = new StringBuilder();
        Set<String> strikes = getStrikes(query);
        Set<String> balls = getBalls(query, strikes);

        if (strikes.size() == 0 && balls.size() == 0) {
            resultMessage.append("포볼");
        } else {
            if (strikes.size() > 0) {
                resultMessage.append(Integer.toString(strikes.size()) + " 스트라이크 ");
            }

            if (balls.size() > 0) {
                resultMessage.append(Integer.toString(balls.size()) + " 볼");
            }
        }

        return new Result(resultMessage.toString(), strikes.size(), balls.size());
    }

    public static class Result {
        private String message;
        private int nStrikes;
        private int nBalls;

        public Result(String message, int nStrikes, int nBalls) {
            this.message = message;
            this.nStrikes = nStrikes;
            this.nBalls = nBalls;
        }

        public String getMessage() {
            return message;
        }

        public int getnStrikes() {
            return nStrikes;
        }

        public int getnBalls() {
            return nBalls;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof Result)) {
                return false;
            }

            Result result = (Result)obj;

            return (result.message.equals(this.message) &&
                    result.nStrikes == this.nStrikes &&
                    result.nBalls == this.nBalls);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;

            result = prime * result + ((this.message == null) ? 0 : this.message.hashCode());
            result = prime * result + this.nStrikes;
            result = prime * result + this.nBalls;

            return result;
        }
    }

}
