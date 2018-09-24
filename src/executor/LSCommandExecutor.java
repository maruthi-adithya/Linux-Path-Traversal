package executor;
import java.util.List;
import models.Directory;
import service.DirectoryService;

public class LSCommandExecutor implements CommandExecutor {

	@Override
	public void execute(String args) {
		DirectoryService directoryService = DirectoryService.getInstance();
		List<Directory> directories = directoryService.getCurrentDirectory().getChildren();
		System.out.print("DIRS: ");
		for(Directory directory: directories) {
			System.out.print(directory.getName()+" ");
		}
		System.out.println();
	}

}
