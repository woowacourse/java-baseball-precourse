package baseball;

import java.util.List;

/*
 * 각 유저의 숫자를 저장하거나 반환합니다.
 */
public class Player {
    private List<Integer> numbersList;

    public List<Integer> getNumbersList() {
        return numbersList;
    }

    public void setNumbersList(List<Integer> numbersList) {
        this.numbersList = numbersList;
    }
}
