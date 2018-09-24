package executor;
import service.DirectoryService;

public class PWDCommandExecutor implements CommandExecutor{

	@Override
	public void execute(String args) {
		System.out.println("PATH: "+DirectoryService.getInstance().getCurrentDirectory().getName());
		
	}

}
