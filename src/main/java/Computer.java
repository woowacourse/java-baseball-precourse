import java.util.ArrayList;
import java.util.Random;

public class Computer {
    private ArrayList<Integer> answer = new ArrayList<>();

    Computer() {
    }

    void make_answer() {
        answer.clear();
        ArrayList<Integer> candidates = new ArrayList<>();
        Random random = new Random();
        candidates.add(1);
        candidates.add(2);
        candidates.add(3);
        candidates.add(4);
        candidates.add(5);
        candidates.add(6);
        candidates.add(7);
        candidates.add(8);
        candidates.add(9);
        for (int i = 0; i < 3; i++) {
            int random_index = random.nextInt(9 - i);
            answer.add(candidates.get(random_index));
            candidates.remove(random_index);
        }
    }

    boolean compare_answer(int raw_suggested_answer) {
        ArrayList<Integer> suggested_answer = convert_int_to_arrayList(raw_suggested_answer);
        int strikes_count = get_strikes_count(suggested_answer);
        int balls_count = get_balls_count(suggested_answer);

        if (strikes_count > 0) System.out.print(strikes_count + " 스트라이크 ");
        if (balls_count > 0) System.out.print(balls_count + " 볼 ");
        if (strikes_count == 0 && balls_count == 0) System.out.print("낫싱");
        System.out.println();
        if (strikes_count == 3) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        return strikes_count == 3;
    }

    private ArrayList<Integer> convert_int_to_arrayList(int raw_suggested_answer) {
        ArrayList<Integer> suggested_answer = new ArrayList<>();
        suggested_answer.add(raw_suggested_answer / 100);
        raw_suggested_answer = raw_suggested_answer - (raw_suggested_answer / 100) * 100;
        suggested_answer.add(raw_suggested_answer / 10);
        raw_suggested_answer = raw_suggested_answer - (raw_suggested_answer / 10) * 10;
        suggested_answer.add(raw_suggested_answer);
        return suggested_answer;
    }

    private int get_strikes_count(ArrayList<Integer> suggested_answer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (suggested_answer.get(i).equals(answer.get(i))) count++;
        }
        return count;
    }

    private int get_balls_count(ArrayList<Integer> suggested_answer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                if (suggested_answer.get(i).equals(answer.get(j))) count++;
            }
        }
        return count;
    }


}
