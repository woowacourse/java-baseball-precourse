public class Baseball {
    
    public static int[] randomNumber(int[] computer) {
        // 컴퓨터 숫자를 랜덤으로 부여
        Random rand = new Random();
        boolean[] sure = new boolean[10];
        int count = 0;
        int trial;

        sure[0] = true; // 0제외

        while (count < computer.length) {
            trial = rand.nextInt(10);
            if (!sure[trial]) {
                computer[count] = trial;
                sure[trial] = true; // 숫자 중복 방지
                count++;
            }
        }
        return computer;
    }
}

