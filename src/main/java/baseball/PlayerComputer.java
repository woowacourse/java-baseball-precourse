package baseball;

import utils.RandomUtils;

public class PlayerComputer {
    private static int[] records = new int[Judge.RECORD_LENGTH];
    private static final int INITIALIZER = -1;

    public int[] getRecords() {
        initializeRecords();
        for (int i = 0; i < Judge.RECORD_LENGTH; i++) {
            int newDigit = RandomUtils.nextInt(Judge.MIN_NUMBER, Judge.MAX_NUMBER);
            if (isSameDigitInRecords(records, newDigit)) {
                i -= 1;
                continue;
            }
            records[i] = newDigit;
        }
        return records;
    }

    private void initializeRecords() {
        for (int i = 0; i < records.length; i++) {
            records[i] = INITIALIZER;
        }
    }

    private boolean isSameDigitInRecords(int[] records, int newDigit) {
        for (int i = 0; i < records.length; i++) {
            if (newDigit == records[i]) {
                return true;
            }
        }
        return false;
    }
}
