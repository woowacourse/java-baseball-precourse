package baseball;

public enum CommandType {
    RESTART("1"), EXIT("2");

    private final String value;

    CommandType(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public static CommandType convert(String playerInput) {
        if (!checkValidation(playerInput)) {
            throw new IllegalArgumentException(Message.REQUEST_COMMAND_TYPE_ERROR);
        }

        for (CommandType commandType : CommandType.values()) {
            if (commandType.getValue().equals(playerInput)) {
                return commandType;
            }
        }

        return CommandType.EXIT;
    }

    private static boolean checkValidation(String playerInput) {
        for (CommandType commandType : CommandType.values()) {
            if (commandType.getValue().equals(playerInput)) {
                return true;
            }
        }
        return false;
    }
}
