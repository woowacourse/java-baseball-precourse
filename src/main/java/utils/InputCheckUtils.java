package utils;

public class InputCheckUtils {
    public static boolean isNumeric(String str) {
        return str.matches("^[1-9]*$");
    }

    public static boolean hasDuplicated(String str) {
        for (int i = 0; i < str.length(); i++) {
            String remain = str.substring(i + 1);
            if (remain.contains(Character.toString(str.charAt(i)))) {
                return true;
            }
        }
        return false;
    }
}
