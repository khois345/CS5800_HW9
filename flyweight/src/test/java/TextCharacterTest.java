import document.*;
import properties.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextCharacterTest {
	private final CharacterProperties properties = new CharacterPropertiesFactory().getProperties("Arial", "Red", 12);

	@Test
	public void getValue() {
		assertEquals('H', new TextCharacter('H', properties).getValue());
	}

	@Test
	public void getProperties() {
		assertSame(properties, new TextCharacter('H', properties).getProperties());
	}

	@Test
	public void setValue() {
		TextCharacter textCharacter = new TextCharacter('H', properties);
		textCharacter.setValue('W');

		assertEquals('W', textCharacter.getValue());
	}

	@Test
	public void setPropertiesNull() {
		TextCharacter textCharacter = new TextCharacter('H', properties);
		textCharacter.setProperties(null);

		assertSame(properties, textCharacter.getProperties());
	}

	@Test
	public void toStringFormat() {
		assertEquals("H (Arial, Red, 12)", new TextCharacter('H', properties).toString());
	}
}
