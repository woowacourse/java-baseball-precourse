package baseball;

import javafx.beans.binding.When;
import jdk.nashorn.internal.ir.WhileNode;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumber {
    //RandomUtils.nextInt(1,9); // 1부터 9까지

    public List<Integer> randNumList() {
        while (true) {
            List<Integer> list = new ArrayList<>();
            int n1 = RandomUtils.nextInt(1,9);
            int n2 = RandomUtils.nextInt(1,9);
            int n3 = RandomUtils.nextInt(1,9);
            if(n1 != n2 && n2 != n3 && n3 != n1) {
                list.add(n1);
                list.add(n2);
                list.add(n3);
                return list;
            }
        }
    }

}
