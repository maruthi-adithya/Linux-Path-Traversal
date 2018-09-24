package utils;

public final class CommandUtils {
	
	public static String getCommandFromInput(String input) {
		if (input.contains(" ")) {
			return input.substring(0, input.indexOf(" "));
		}
		return input;
	}
	
	public static String getCommandArgumentsFromInput(String input) {
		if (input.contains(" ")) {
			return input.substring(input.indexOf(" ") + 1);
		}
		return null;
	}
	
	

}
