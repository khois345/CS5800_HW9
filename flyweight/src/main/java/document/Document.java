package document;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import properties.*;

public class Document {
	private CharacterPropertiesFactory factory;		// aggregation
	private ArrayList<TextCharacter> characters;	// composition

	public Document(CharacterPropertiesFactory factory) {
		this.factory = factory;
		this.characters = new ArrayList<>();
	}

	// getters
	public ArrayList<TextCharacter> getCharacters() {
		return characters;
	}

	public String getText() {
		String text = "";
		for (TextCharacter textCharacter : characters) {
			text += textCharacter.getValue();
		}

		return text;
	}

	// setters
	public void addCharacter(char value, String font, String color, int size) {
		CharacterProperties properties = factory.getProperties(font, color, size);
		if (properties == null) {
			return;
		}

		TextCharacter newChar = new TextCharacter(value, properties);
		characters.add(newChar);
	}

	public void addText(String text, String font, String color, int size) {
		if (text == null) {
			System.err.println("Text cannot be empty");
			return;
		}

		for (char value : text.toCharArray()) {
			addCharacter(value, font, color, size);
		}
	}

	public void editCharacter(int index, String font, String color, int size) {
		if (index < 0 || index >= characters.size()) {
			System.err.println("Character index is incorrect or out of range");
			return;
		}

		CharacterProperties properties = factory.getProperties(font, color, size);
		if (properties == null) {
			return;
		}

		TextCharacter editChar = characters.get(index);
		editChar.setProperties(properties);
	}

	// other methods
	public void print() {
		System.out.println("Document: " + getText());

		for (TextCharacter textCharacter : characters) {
			System.out.println("  " + textCharacter);
		}

		System.out.println("Shared character properties: " + factory.getPropertiesCount());
	}

	public void save(String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (TextCharacter textCharacter : characters) {
				CharacterProperties properties = textCharacter.getProperties();
				writer.write(textCharacter.getValue() + "," + properties.getFont() + "," + properties.getColor() + "," + properties.getSize());
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.println("Cannot save document to " + fileName);
		}
	}

	public void load(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			characters.clear();

			String line;
			while ((line = reader.readLine()) != null) {
				char value = line.charAt(0);
				String[] properties = line.substring(2).split(",");
				String font = properties[0];
				String color = properties[1];
				int size = Integer.parseInt(properties[2]);

				addCharacter(value, font, color, size);
			}
		} catch (IOException e) {
			System.err.println("Cannot load document from " + fileName);
		}
	}
}
