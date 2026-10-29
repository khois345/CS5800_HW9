import document.*;
import properties.*;

public class initTextEditor {

	public static void main(String[] args) {
		String fileName = "HelloWorldCS5800.txt";

		// Create
		Document savedDocument = new Document(new CharacterPropertiesFactory());
		savedDocument.addText("Hello", "Arial", "Red", 16);
		savedDocument.addText("World", "Calibri", "Blue", 14);
		savedDocument.addText("CS", "Verdana", "Black", 12);
		savedDocument.addText("5800", "Arial", "Blue", 12);

		System.out.println("Created" + "-" .repeat(50));
		savedDocument.print();
		System.out.println();

		// Edit
		savedDocument.editCharacter(0, "Verdana", "Red", 14);

		System.out.println("Edited first character " + "-" .repeat(50));
		savedDocument.print();
		System.out.println();

		// Save
		System.out.println("Saving " + fileName + " " + "-" .repeat(50));
		savedDocument.save(fileName);
		System.out.println("Saved to " + fileName);
		System.out.println();

		// Load
		System.out.println("Loading " + fileName + " " + "-" .repeat(50));
		Document loadedDocument = new Document(new CharacterPropertiesFactory());
		loadedDocument.load(fileName);

		System.out.println("Loaded from " + fileName + ":");
		loadedDocument.print();
	}
}
