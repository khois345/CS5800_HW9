import properties.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertiesTest {
	private final CharacterProperties properties = new CharacterPropertiesFactory().getProperties("Arial", "Red", 12);

	@Test
	public void getFont() {
		assertEquals("Arial", properties.getFont());
	}

	@Test
	public void getColor() {
		assertEquals("Red", properties.getColor());
	}

	@Test
	public void getSize() {
		assertEquals(12, properties.getSize());
	}

	@Test
	public void toStringFormat() {
		assertEquals("Arial, Red, 12", properties.toString());
	}
}
