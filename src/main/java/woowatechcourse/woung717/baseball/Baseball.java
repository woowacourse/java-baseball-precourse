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

}
