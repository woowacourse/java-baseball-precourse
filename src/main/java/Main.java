 public class Main {
    // 컴퓨터가 선택할 수 (각 자리 서로 다른 수)
    public static String computerSelectNum() {
        StringBuilder sb = new StringBuilder();

        while (true) {
            // 1 ~ 9 자리의 수
            String ran = String.valueOf((int)(Math.random() * 9 + 1));

            // 자릿수까지 반복
            for (int i = 0; i < sb.length() + 1; i++) {
                // 해당 숫자가 존재하지 않으면 추가
                if (sb.indexOf(ran) == -1) {
                    sb.append(ran);
                }
            }

            // 3자리 일경우 반복문 종료
            if (sb.length() == 3) break;
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(computerSelectNum());
    }
}
