package Results;

public class NothingResult implements ComparedResult {
    @Override
    public void printMessage() {

    }

    @Override
    public boolean isGameRunning() {
        return false;
    }
}
