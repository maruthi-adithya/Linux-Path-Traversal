package constants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class CommandConstants {

	// Command Names
	public static final String cd = "cd";
	public static final String mkdir = "mkdir";
	public static final String rm = "rm";
	public static final String pwd = "pwd";
	public static final String ls = "ls";
	public static final String session_clear = "session clear";

	// Storing in Set as Set returns contains in O(1)
	public static final Set<String> commandSet =
			new HashSet<String>(Arrays.asList(new String[] {cd, mkdir, rm, pwd, ls,session_clear}));

	public static boolean isCommandPresent(String name) {
		return commandSet.contains(name);
	}
}
