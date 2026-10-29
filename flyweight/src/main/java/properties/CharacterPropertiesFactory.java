package properties;

import java.util.HashMap;

public class CharacterPropertiesFactory {
	private HashMap<String, CharacterProperties> properties;	// composition

	public CharacterPropertiesFactory() {
		this.properties = new HashMap<>();	// flyweight pattern: store shared properties
	}

	public CharacterProperties getProperties(String font, String color, int size) {
		// if (font == null || font.isBlank() || color == null || color.isBlank()) {
		// 	System.err.println("Font and color cannot be blank");
		// 	return null;
		// }
		// if (size <= 0) {
		// 	System.err.println("Size must be greater than 0");
		// 	return null;
		// }

		// // flyweight pattern: reuse existing if available, otherwise create new
		// String key = font + " | " + color + " | " + size;
		// CharacterProperties existing = properties.get(key);
		// if (existing == null) {
		// 	existing = new CharacterProperties(font, color, size);
		// 	properties.put(key, existing);
		// }
		// return existing;
		return new CharacterProperties(font, color, size);
	}

	public int getPropertiesCount() {
		// return properties.size();
		return 0;
	}
}
