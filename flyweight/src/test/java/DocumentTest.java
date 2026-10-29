import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Path;

import document.*;
import properties.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentTest {
	@Test
	public void addCharacter() {
		Document document = new Document(new CharacterPropertiesFactory());
		document.addCharacter('H', "Arial", "Red", 12);

		assertEquals(1, document.getCharacters().size());
		assertEquals('H', document.getCharacters().get(0).getValue());
	}

	@Test
	public void addCharacterInvalid() {
		Document document = new Document(new CharacterPropertiesFactory());
		document.addCharacter('H', "Arial", "Red", 12);
		document.addCharacter('W', "", "Red", 12);

		assertEquals(1, document.getCharacters().size());
	}

	@Test
	public void addTextSharesProperties() {
		CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
		Document document = new Document(factory);
		document.addText("Hello", "Arial", "Red", 12);

		assertEquals(5, document.getCharacters().size());
		assertSame(document.getCharacters().get(0).getProperties(), document.getCharacters().get(4).getProperties());
		assertEquals(1, factory.getPropertiesCount());
	}

	@Test
	public void editCharacter() {
		CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
		Document document = new Document(factory);
		document.addText("Hi", "Arial", "Red", 12);
		document.editCharacter(1, "Verdana", "Black", 16);

		assertSame(factory.getProperties("Verdana", "Black", 16), document.getCharacters().get(1).getProperties());
		assertSame(factory.getProperties("Arial", "Red", 12), document.getCharacters().get(0).getProperties());
	}

	@Test
	public void editCharacterOutOfRange() {
		CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
		Document document = new Document(factory);
		document.addCharacter('H', "Arial", "Red", 12);
		document.editCharacter(5, "Verdana", "Black", 16);

		assertSame(factory.getProperties("Arial", "Red", 12), document.getCharacters().get(0).getProperties());
	}

	@Test
	public void getText() {
		Document document = new Document(new CharacterPropertiesFactory());
		document.addText("Hello", "Arial", "Red", 12);
		document.addText("World", "Calibri", "Blue", 14);

		assertEquals("HelloWorld", document.getText());
	}

	@Test
	public void print() {
		Document document = new Document(new CharacterPropertiesFactory());
		document.addText("Hi", "Arial", "Red", 12);

		PrintStream out = System.out;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		try {
			document.print();
		} finally {
			System.setOut(out);
		}

		String printed = output.toString();
		assertTrue(printed.contains("Document: Hi"));
		assertTrue(printed.contains("H (Arial, Red, 12)"));
		assertTrue(printed.contains("Shared character properties: 1"));
	}

	@Test
	public void save(@TempDir Path folder) {
		String file = folder.resolve("document.txt").toString();
		Document document = new Document(new CharacterPropertiesFactory());
		document.addText("Hi", "Arial", "Red", 12);
		document.save(file);

		assertTrue(new File(file).exists());
	}

	@Test
	public void load(@TempDir Path folder) {
		String file = folder.resolve("document.txt").toString();
		Document saved = new Document(new CharacterPropertiesFactory());
		saved.addText("Hi", "Arial", "Red", 12);
		saved.save(file);

		Document loaded = new Document(new CharacterPropertiesFactory());
		loaded.load(file);

		assertEquals("Hi", loaded.getText());
	}
}
