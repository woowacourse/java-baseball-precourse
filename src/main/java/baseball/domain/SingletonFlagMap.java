package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class SingletonFlagMap {
    private final Map<Integer, ExecutionFlagType> flagMap;

    private SingletonFlagMap() {
        this.flagMap = new HashMap<>();
        for (ExecutionFlagType executionFlagType : ExecutionFlagType.values()) {
            this.flagMap.put(executionFlagType.getFlagNumber(), executionFlagType);
        }
    }

    public static SingletonFlagMap getInstance() {
        return LazyHolderFlagMap.SINGLETON_FLAG_MAP_INSTANCE;
    }

    public ExecutionFlagType getFlagFromNumber(int flag) {
        ExecutionFlagType selectedExecutionFlagType = this.flagMap.get(flag);
        if (selectedExecutionFlagType == null) {
            throw new IllegalArgumentException();
        }
        return selectedExecutionFlagType;
    }

    /**
     * Lazy holder pattern
     * for handling multi-threaded race condition
     */
    private static class LazyHolderFlagMap {
        private static final SingletonFlagMap SINGLETON_FLAG_MAP_INSTANCE = new SingletonFlagMap();
    }
}
