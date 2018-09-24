package processor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;
import constants.CommandConstants;
import executor.CommandExecutor;
import models.Command;
import models.CommandFactory;
import service.DirectoryService;
import utils.CommandUtils;
import validator.CommandValidator;
import validator.CommandValidatorImpl;

public class InputProcessor {

	public void processInputs() throws Exception {

		// Initialize BufferedReader
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		// Initialize BufferedReader
		String input;

		// Initialize Directory Service
		DirectoryService.getInstance().init();

		printPrefix();

		while ((input = bufferedReader.readLine()) != null) {

			String commandName = CommandUtils.getCommandFromInput(input);

			// Assign it as Optional since Arguments are not Mandatory for every Command
			Optional<String> optionalArgument =
					Optional.ofNullable(CommandUtils.getCommandArgumentsFromInput(input));

			// Clear Session Based on User Input
			if (isClearSession(input)) {
				clearSession(input);
			} else {
				// Initialize command
				Command command = getCommand(commandName, optionalArgument);

				// Validate and process Commands
				validateAndProcessCommands(command);
			}

			printPrefix();
		}
	}

	private boolean isClearSession(String input) {
		return input.trim().equalsIgnoreCase(CommandConstants.session_clear);
	}

	private void clearSession(String input) {
		DirectoryService.getInstance().init();
		System.out.println("SUCC: CLEARED: RESET TO ROOT");
	}


	private void printPrefix() {
		System.out.print("$>");
	}

	private Command getCommand(String commandName, Optional<String> argument) {
		if (argument.isPresent()) {
			return new Command.CommandBuilder(commandName).setArgument(argument.get()).build();
		}
		return new Command.CommandBuilder(commandName).build();
	}

	private void validateAndProcessCommands(Command command) {
		// Initialize Validator
		CommandValidator validator = new CommandValidatorImpl();
		// Check if Valid Command
		if (validator.isValid(command)) {
			// Get Executor from Factory
			CommandExecutor commandExecutor = CommandFactory.getExecutor(command);
			commandExecutor.execute(command.argument);
		} else {
			System.out.println("ERR: CANNOT RECOGNIZE INPUT.");
		}
	}



}
