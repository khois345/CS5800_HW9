import properties.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertiesFactoryTest {
	@Test
	public void getPropertiesShared() {
		CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
		CharacterProperties first = factory.getProperties("Calibri", "Blue", 14);
		CharacterProperties second = factory.getProperties("Calibri", "Blue", 14);

		assertSame(first, second);
	}

	@Test
	public void getPropertiesDifferent() {
		CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
		CharacterProperties arial = factory.getProperties("Arial", "Red", 12);
		CharacterProperties verdana = factory.getProperties("Verdana", "Black", 16);

		assertNotSame(arial, verdana);
		assertEquals("Verdana", verdana.getFont());
	}

	@Test
	public void getPropertiesInvalid() {
		CharacterPropertiesFactory factory = new CharacterPropertiesFactory();

		assertNull(factory.getProperties("", "Red", 12));
		assertNull(factory.getProperties("Arial", null, 12));
		assertNull(factory.getProperties("Arial", "Red", 0));
	}

	@Test
	public void getPropertiesCount() {
		CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
		factory.getProperties("Arial", "Red", 12);
		factory.getProperties("Arial", "Red", 12);
		factory.getProperties("Verdana", "Black", 16);

		assertEquals(2, factory.getPropertiesCount());
	}
}
