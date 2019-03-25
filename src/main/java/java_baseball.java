/*
 *  java_baseball.java
 *
 *  ver 1.0.0
 *
 *  2019/03/25
 *
 */

public class java_baseball {
    public static void main(String[] args) {
        Number comNum = new Number();
        Number userNum = new Number();

        for (int i = 0; i < 3; ++i) {
            comNum.number[i] = (int) (Math.random() * 10);
            if (comNum.isOverlap(i)) i--;
        }

    }
}
