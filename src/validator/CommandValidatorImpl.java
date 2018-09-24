package validator;
import constants.CommandConstants;
import models.Command;

public class CommandValidatorImpl implements CommandValidator {

	private boolean validateForIndividualCommands(Command command) {
		switch (command.name) {
			case CommandConstants.ls:
			case CommandConstants.pwd:
				if (command.argument != null) {
					return false;
				}
				break;
			case CommandConstants.cd:
				if (command.argument.trim().contains(" ")) {
					return false;
				}
				break;
			case CommandConstants.mkdir:
			case CommandConstants.rm:
				if(command.argument==null) {
					return false;
				}
				break;
		}
		return true;
	}

	@Override
	public boolean isValid(Command command) {
		return CommandConstants.isCommandPresent(command.name)
				&& validateForIndividualCommands(command);
	}
}
