package utils;

public class Converter {
    public static int[] convertString(String string) {
        int[] resultArray = new int[string.length()];

        int stringIndex = 0;

        while (stringIndex < string.length()) {
            int parsedElement = Character.getNumericValue(string.charAt(stringIndex));

            resultArray[stringIndex] = parsedElement;

            stringIndex += 1;
        }

        return resultArray;
    }
}
