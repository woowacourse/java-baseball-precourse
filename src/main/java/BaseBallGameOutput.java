public class BaseBallGameOutput {
    public void printResult(BaseBallGameResult baseBallGameResult) {
        StringBuilder stringBuilder = new StringBuilder();
        if(baseBallGameResult.getStrike() == 3) {
            stringBuilder.append(baseBallGameResult.getStrike() + " 스트라이크 ");
            stringBuilder.append("\n3개의 숫자를 모두 맞히셨습니다.");

        } else if(baseBallGameResult.getStrike() != 0) {
            stringBuilder.append(baseBallGameResult.getStrike() + " 스트라이크 ");
        }

        if(baseBallGameResult.getBall() != 0) {
            stringBuilder.append(baseBallGameResult.getBall() + " 볼");
        }

        if(baseBallGameResult.getStrike() == 0 && baseBallGameResult.getBall() == 0) {
            stringBuilder.append("낫싱");
        }

        System.out.println(stringBuilder);
    }
} 
