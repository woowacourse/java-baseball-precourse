package baseball;

import java.util.Scanner;

public class PlayerHuman {
    private static int[] records = new int[Judge.RECORD_LENGTH];

    static {
        for(int i = 0; i < records.length; i++)
            records[i] = -1;
    }

    public int[] getRecords(Scanner scanner) {
        int[] records = new int[Judge.RECORD_LENGTH];
        return records;
    }
}
