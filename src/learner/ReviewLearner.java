package learner;

import java.io.File;

public class ReviewLearner {

	public static void main(String[] args) {
		if (args.length != 3) {
			throw new IllegalArgumentException("Usage: java -jar "
					+ "ReviewLearner.jar <positive_input_foldwer> "
					+ "<negative_input_folder> <output_file>");
		}

		File positiveInputFolder = new File(args[0]);
		File negativeInputFolder = new File(args[1]);
		
		if (!positiveInputFolder.isDirectory()) {
			throw new IllegalArgumentException("First argument should be a folder");
		}
		
		if (!negativeInputFolder.isDirectory()) {
			throw new IllegalArgumentException("Second argument should be a folder");
		}
		
		File outputFile = new File(args[2]);
		
		
	}

}
