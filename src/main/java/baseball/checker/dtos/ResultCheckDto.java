package baseball.checker.dtos;

import baseball.players.Players;

public class ResultCheckDto {
    private final Players players;
    private final ResultIndexDto resultIndexDto;

    public ResultCheckDto(Players players, ResultIndexDto resultIndexDto) {
        this.players = players;
        this.resultIndexDto = resultIndexDto;
    }

    public int getUserIndex() {
        return resultIndexDto.getUserIndex();
    }

    public int getComputerIndex() {
        return resultIndexDto.getComputerIndex();
    }

    public int getUserNumberIndexOf(int userIndex) {
        return players.getUserNumberIndexOf(userIndex);
    }

    public int getComputerNumberIndexOf(int computerIndex) {
        return players.getComputerNumberIndexOf(computerIndex);
    }
}
