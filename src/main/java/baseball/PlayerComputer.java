package baseball;

import utils.RandomUtils;

public class PlayerComputer {
    private static int[] records = new int[Judge.RECORD_LENGTH];

    static {
        for(int i = 0; i < records.length; i++)
            records[i] = -1;
    }

    public int[] getRecords() {
        for(int i = 0; i < Judge.RECORD_LENGTH; i++) {
            int newDigit = RandomUtils.nextInt(Judge.MIN_NUMBER, Judge.MAX_NUMBER);
            if(isSameDigitInRecords(records, newDigit)) {
                i -= 1;
                continue;
            }
            records[i] = newDigit;
        }
        return records;
    }

    private boolean isSameDigitInRecords(int[] records, int newDigit) {
        for(int i = 0; i < records.length; i++) {
            if(newDigit == records[i])
                return true;
        }
        return false;
    }

}
