import java.util.List;

import service.*;
import song.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SongServiceProxyTest {
	private final SongServer server = new SongServer();
	private final SongServiceProxy proxy = new SongServiceProxy(server);

	private final Song manchild = new Song(1, "Manchild", "Sabrina Carpenter", "Man's Best Friend", 210);
	private final Song please = new Song(2, "Please Please Please", "Sabrina Carpenter", "Short n' Sweet", 190);
	private final Song espresso = new Song(3, "Espresso", "Sabrina Carpenter", "Short n' Sweet", 180);

	@Test
	public void searchById() {
		server.addSong(manchild);
		proxy.searchById(1);
		server.addSong(new Song(1, "Taste", "Sabrina Carpenter", "Short n' Sweet", 160));

		assertSame(manchild, proxy.searchById(1));
	}

	@Test
	public void searchByTitle() {
		server.addSong(espresso);
		proxy.searchByTitle("Espresso");
		server.addSong(new Song(4, "Espresso", "Another Artist", "Another Album", 200));

		assertEquals(List.of(espresso), proxy.searchByTitle("espresso"));
	}

	@Test
	public void searchByAlbum() {
		server.addSong(please);
		server.addSong(espresso);
		proxy.searchByAlbum("Short n' Sweet");
		server.addSong(new Song(4, "Taste", "Sabrina Carpenter", "Short n' Sweet", 160));

		assertEquals(2, proxy.searchByAlbum("short n' sweet").size());
	}
}
