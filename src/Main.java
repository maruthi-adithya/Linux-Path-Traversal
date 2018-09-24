import processor.InputProcessor;

public class Main {

	public static void main(String[] args) throws Exception {
		Main obj = new Main();
		obj.start();
	}

	private void start() throws Exception {
		System.out.println("$> <Starting your application...>");
		InputProcessor inputProcessor = new InputProcessor();
		inputProcessor.processInputs();
	}

}
