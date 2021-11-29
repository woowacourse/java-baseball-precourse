package constants;


public enum ExitOption {

	RESTART("1"),
	END("2");

	private final String command;

	ExitOption(String command) {

		this.command = command;
	}

	public String getCommand() {

		return command;
	}
}
