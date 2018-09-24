package models;
import constants.CommandConstants;
import executor.CDCommandExecutor;
import executor.CommandExecutor;
import executor.LSCommandExecutor;
import executor.MKDIRCommandExecutor;
import executor.PWDCommandExecutor;
import executor.RMCommandExecutor;

public class CommandFactory {

	public static CommandExecutor getExecutor(Command command) {
		if (command.name.equalsIgnoreCase(CommandConstants.cd)) {
			return new CDCommandExecutor();
		} else if (command.name.equalsIgnoreCase(CommandConstants.ls)) {
			return new LSCommandExecutor();
		} else if (command.name.equalsIgnoreCase(CommandConstants.mkdir)) {
			return new MKDIRCommandExecutor();
		} else if (command.name.equalsIgnoreCase(CommandConstants.pwd)) {
			return new PWDCommandExecutor();
		} else if (command.name.equalsIgnoreCase(CommandConstants.rm)) {
			return new RMCommandExecutor();
		} else {
			return null;
		}
	}
}
