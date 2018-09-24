package executor;
import java.util.List;
import models.Directory;
import service.DirectoryService;

public class MKDIRCommandExecutor implements CommandExecutor {

	@Override
	public void execute(String args) {
		DirectoryService directoryService = DirectoryService.getInstance();
		if (isDirectoryExists(args)) {
			System.out.println("ERR: DIRECTORY ALREADY EXISTS");
		} else {
			String[] directories = args.split(" ");
			for (String directory : directories) {
				directoryService.getCurrentDirectory().addChild(new Directory(directory));
			}
			System.out.println("SUCC: CREATED");
		}
	}

	private boolean isDirectoryExists(String args) {
		DirectoryService directoryService = DirectoryService.getInstance();
		List<Directory> directories = directoryService.getCurrentDirectory().getChildren();
		String[] directoryNames = args.split(" ");
		for (String directoryName : directoryNames) {
			for (Directory directory : directories) {
				if (directory.getName().equalsIgnoreCase(directoryName)) {
					return true;
				}
			}
		}

		return false;
	}

}
