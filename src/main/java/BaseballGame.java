import java.util.*;

public class BaseballGame {
    // 1에서 9 사이의 서로 다른 임의의 정수 3개를 생성하여 배열로 반환.
    private static int[] randIntArray() {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Random rand = new Random();

        // Fisher–Yates shuffle
        int j, temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            j = rand.nextInt(arr.length);
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        return Arrays.copyOfRange(arr, 0, 3);
    }

    // 메인 함수.
    public static void main(String[] args) {
        // randIntArray 동작 테스트
        int[] array1 = randIntArray();
        for (int i: array1) {
            System.out.println(i);
        }
    }
}
