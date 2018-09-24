package executor;

import models.Directory;
import service.DirectoryService;

public class RMCommandExecutor implements CommandExecutor {

	@Override
	public void execute(String args) {
		String[] directories = args.split(" ");
		int count = 0;
		for (String name : directories) {
			Directory deletableDirectory = null;
			for (Directory directory : DirectoryService.getInstance().getCurrentDirectory()
					.getChildren()) {
				if (directory.getName().equalsIgnoreCase(name)) {
					deletableDirectory = directory;
					break;
				}
			}
			if (deletableDirectory != null) {
				deletableDirectory.deleteNode();
				count++;
			}
		}
		if (count > 0) {
			System.out.println("SUCC: DELETED");
		}
	}

}
