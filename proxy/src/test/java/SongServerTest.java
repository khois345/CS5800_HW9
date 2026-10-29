import java.util.List;

import service.*;
import song.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SongServerTest {
	private final SongServer server = new SongServer();
	private final Song manchild = new Song(1, "Manchild", "Sabrina Carpenter", "Man's Best Friend", 210);
	private final Song please = new Song(2, "Please Please Please", "Sabrina Carpenter", "Short n' Sweet", 190);
	private final Song espresso = new Song(3, "Espresso", "Sabrina Carpenter", "Short n' Sweet", 180);

	@Test
	public void addSong() {
		server.addSong(manchild);

		assertSame(manchild, server.searchById(1));
	}

	@Test
	public void searchById() {
		server.addSong(manchild);
		server.addSong(please);

		assertSame(please, server.searchById(2));
	}

	@Test
	public void searchByTitle() {
		server.addSong(manchild);
		server.addSong(please);

		assertEquals(List.of(manchild), server.searchByTitle("manchild"));
	}

	@Test
	public void searchByAlbum() {
		server.addSong(manchild);
		server.addSong(please);
		server.addSong(espresso);

		assertEquals(2, server.searchByAlbum("Short n' Sweet").size());
	}
}
