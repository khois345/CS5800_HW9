package properties;

public final class CharacterProperties {
	private final String font;
	private final String color;
	private final int size;

	CharacterProperties(String font, String color, int size) {
		// this.font = font;
		// this.color = color;
		// this.size = size;
		this.font = null;
		this.color = null;
		this.size = 0;
	}

	public String getFont() {
		// return font;
		return null;
	}

	public String getColor() {
		// return color;
		return null;
	}

	public int getSize() {
		// return size;
		return 0;
	}

	// other methods
	@Override
	public String toString() {
		// return font + ", " + color + ", " + size;
		return "";
	}
}
