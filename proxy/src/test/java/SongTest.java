import song.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SongTest {
	private final Song song = new Song(1, "Manchild", "Sabrina Carpenter", "Man's Best Friend", 210);

	@Test
	public void getId() {
		assertEquals(1, song.getId());
	}

	@Test
	public void getTitle() {
		assertEquals("Manchild", song.getTitle());
	}

	@Test
	public void getArtist() {
		assertEquals("Sabrina Carpenter", song.getArtist());
	}

	@Test
	public void getAlbum() {
		assertEquals("Man's Best Friend", song.getAlbum());
	}

	@Test
	public void getDuration() {
		assertEquals(210, song.getDuration());
	}

	@Test
	public void setIdInvalid() {
		song.setId(0);

		assertEquals(1, song.getId());
	}

	@Test
	public void setTitleBlank() {
		song.setTitle("");

		assertEquals("Manchild", song.getTitle());
	}

	@Test
	public void setArtistBlank() {
		song.setArtist("");

		assertEquals("Sabrina Carpenter", song.getArtist());
	}

	@Test
	public void setAlbumBlank() {
		song.setAlbum("");

		assertEquals("Man's Best Friend", song.getAlbum());
	}

	@Test
	public void setDurationInvalid() {
		song.setDuration(-5);

		assertEquals(210, song.getDuration());
	}

	@Test
	public void toStringFormat() {
		assertEquals("1. Manchild - Sabrina Carpenter (Man's Best Friend, 210s)", song.toString());
	}
}
