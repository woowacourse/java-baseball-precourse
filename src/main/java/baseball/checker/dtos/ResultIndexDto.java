package baseball.checker.dtos;

public class ResultIndexDto {
    private final int userIndex;
    private final int computerIndex;

    public ResultIndexDto(int userIndex, int computerIndex) {
        this.userIndex = userIndex;
        this.computerIndex = computerIndex;
    }

    public int getUserIndex() {
        return userIndex;
    }

    public int getComputerIndex() {
        return computerIndex;
    }
}
