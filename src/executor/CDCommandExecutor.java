package executor;
import java.util.List;
import models.Directory;
import service.DirectoryService;

public class CDCommandExecutor implements CommandExecutor {

	@Override
	public void execute(String args) {
		DirectoryService directoryService = DirectoryService.getInstance();
		Directory currentDirectory = directoryService.getCurrentDirectory();
		if (!args.contains("/")) {
			List<Directory> directories = directoryService.getCurrentDirectory().getChildren();
			Directory found = null;
			for (Directory directory : directories) {
				if (directory.getName().equalsIgnoreCase(args)) {
					found = directory;
					break;
				}
			}
			if (found != null) {
				directoryService.setCurrentDirectory(found);
				System.out.println("SUCC: REACHED");
			} else {
				System.out.println("ERR: INVALID PATH");
			}
		} else {
			String[] directories = args.split("/");
			int count = 0;
			for (String name : directories) {
				Directory directory = directoryService.getCurrentDirectory();
				List<Directory> list = directory.getChildren();
				for (Directory start : list) {
					if (start.getName().equalsIgnoreCase(name)) {
						count++;
						directoryService.setCurrentDirectory(start);
						break;
					}
				}
			}
			if (count == directories.length) {
				System.out.println("SUCC: REACHED");
			} else {
				// Revert back to current Directory
				directoryService.setCurrentDirectory(currentDirectory);
				System.out.println("ERR: INVALID PATH");
			}
		}
	}

}
