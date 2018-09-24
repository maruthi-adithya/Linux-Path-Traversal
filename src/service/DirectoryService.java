package service;

import models.Directory;

public class DirectoryService {
	
	private static Directory directory = null;
	
	private static Directory currentDirectory = null;
	
	private static DirectoryService directoryService = null;
	
  private DirectoryService() {
  	
  }

	public static DirectoryService getInstance() {
		if (directoryService == null) {
			directoryService = new DirectoryService();
		}
		return directoryService;
	}


	private void createRootDirectory() {
		directory = new Directory("/");
		currentDirectory =directory;
	}
	
	public Directory getCurrentDirectory() {
		return currentDirectory;
	}

	public void setCurrentDirectory(Directory currentDirectory) {
		DirectoryService.currentDirectory = currentDirectory;
	}
	
	public void init() {
		createRootDirectory();
	}

}
