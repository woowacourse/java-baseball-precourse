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

}
