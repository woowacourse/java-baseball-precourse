/*
 * BaseballDriver class
 *
 * v0.1
 *
 * 2019.03.25
 *
 * Copyrights
 */

package woowatechcourse.woung717.baseball;

public class BaseballDriver {
    static boolean isValid(String s) {
        StringBuilder newString = new StringBuilder();

        s.chars().distinct().forEach(c -> newString.append((char) c));

        return s.equals(newString.toString()) && s.matches("^[1-9]{3}$");
    }

    public static void main(String[] args) {
    }
}
