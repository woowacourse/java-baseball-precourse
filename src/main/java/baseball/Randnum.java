package baseball;

import java.util.Random;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class Randnum {
    int createRandnum() {
        Random random = new Random();
        int rd = 0;
        for (int i=0;i<3;i++)
            rd = rd*10 + random.nextInt(8)+1;

        return rd;
        //System.out.println(random.nextInt(8)+1);
    }
}

