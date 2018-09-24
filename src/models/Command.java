package models;

public class Command {

	public String name;

	public String argument;

	public String getArgument() {
		return argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Command(CommandBuilder commandBuilder) {
		this.name = commandBuilder.name;
		this.argument = commandBuilder.argument;
	}

	public static class CommandBuilder {

		// required Parameter
		String name;

		// optional parameter
		String argument;

		public CommandBuilder(String name) {
			this.name = name;
		}

		public CommandBuilder setArgument(String argument) {
			this.argument = argument;
			return this;
		}

		public Command build() {
			return new Command(this);
		}

	}

}
