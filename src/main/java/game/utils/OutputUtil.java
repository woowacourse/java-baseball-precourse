
/*
 * OutputUtil.java
 * @author crystal_rim
 * @version 1.0.0
 * @date 2019-12-02
 */
package game.utils;

public class OutputUtil {
    /**
     * This method is used to print the error message.
     * @param e exception
     */
    public static void showError(Exception e) {
        System.out.println(e.getMessage());
    }
}
