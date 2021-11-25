package baseball;

import java.util.ArrayList;
import java.util.Random;

public class ThreeDigits {
    public String threeDigits = "123";

    public String getThreeDigits() {
        return threeDigits;
    }

    public void genThreeRandomDigits() {
        Random random = new Random();
        boolean [] IsChecked = new boolean[10];
        for (int i = 1; i <= 9; i++) {
            IsChecked[i] = false;
        }

        String ThreeRandomDigits = "";
        int count = 0;
        while (count != 3) {
            int rand = random.nextInt(8) + 1;  // generate 1 ~ 9
            if (!IsChecked[rand]) {
                count++;
                IsChecked[rand] = true;
                ThreeRandomDigits += String.valueOf(rand);
            }
        }

        this.threeDigits = ThreeRandomDigits;
    }
}
