package document;

import properties.*;

public class TextCharacter {
	private char value;
	private CharacterProperties properties;	// aggregation

	public TextCharacter(char value, CharacterProperties properties) {
		setValue(value);
		setProperties(properties);
	}

	public char getValue() {
		return value;
	}

	public CharacterProperties getProperties() {
		return properties;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public void setProperties(CharacterProperties properties) {
		if (properties == null) {
			System.err.println("Character properties cannot be empty");
			return;
		}

		this.properties = properties;
	}

	@Override
	public String toString() {
		return value + " (" + properties + ")";
	}
}
