public class OutputBaseballGame {
    public static void printPitchResult(int stCnt, int bCnt) {
        if (stCnt == 0 && bCnt == 0) {
            System.out.println("낫싱");
        } else if (stCnt == 0 && bCnt > 0) {
            System.out.println(bCnt + "볼");
        } else if (stCnt > 0 && bCnt == 0) {
            System.out.println(stCnt + " 스트라이크");
        } else {
            System.out.println(stCnt + " 스트라이크 " + bCnt + "볼");
        }
    }

    public void printNextStepMsg(){}
}
