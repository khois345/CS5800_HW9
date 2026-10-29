import java.util.List;

import service.*;
import song.*;

public class initMusicStreaming {

	public static void main(String[] args) {
		SongServer server = new SongServer();
		server.addSong(new Song(1, "Manchild", "Sabrina Carpenter", "Man's Best Friend", 210));
		server.addSong(new Song(2, "Tears", "Sabrina Carpenter", "Man's Best Friend", 170));
		server.addSong(new Song(3, "Goodbye", "Sabrina Carpenter", "Man's Best Friend", 220));
		server.addSong(new Song(4, "Espresso", "Sabrina Carpenter", "Short n' Sweet", 180));
		server.addSong(new Song(5, "Please Please Please", "Sabrina Carpenter", "Short n' Sweet", 190));
		server.addSong(new Song(6, "Bed Chem", "Sabrina Carpenter", "Short n' Sweet", 170));
		server.addSong(new Song(7, "Firework", "Katy Perry", "Teenage Dream", 230));
		server.addSong(new Song(8, "Roar", "Katy Perry", "Prism", 220));
		server.addSong(new Song(9, "Closer", "The Chainsmokers", "Collage", 240));
		server.addSong(new Song(10, "Something Just Like This", "The Chainsmokers", "Memories...Do Not Open", 250));

		SongService proxy = new SongServiceProxy(server);

		// Search by id
		System.out.println("Search by id 1 " + "-".repeat(50));
		for (int i = 1; i <= 2; i++) {
			System.out.print("  Search " + i + "... ");

			// currentTimeMillis() returns the current time in milliseconds
			long start = System.currentTimeMillis();
			Song song = proxy.searchById(1);
			long processingTime = System.currentTimeMillis() - start;

			// This should print after to simulate the delay
			System.out.println("(took " + processingTime + " ms): " + song);
		}
		System.out.println();

		// Search by title
		System.out.println("Search by title \"Espresso\" " + "-".repeat(50));
		for (int i = 1; i <= 2; i++) {
			System.out.print("  Search " + i + "... ");
			long start = System.currentTimeMillis();
			List<Song> songs = proxy.searchByTitle("Espresso");
			long processingTime = System.currentTimeMillis() - start;

			// This should print after to simulate the delay
			System.out.println("(took " + processingTime + " ms): " + songs);
		}
		System.out.println();

		// Search by album
		System.out.println("Search by album \"Man's Best Friend\" " + "-".repeat(50));
		for (int i = 1; i <= 2; i++) {
			long start = System.currentTimeMillis();
			List<Song> songs = proxy.searchByAlbum("Man's Best Friend");
			long processingTime = System.currentTimeMillis() - start;

			System.out.println("  Search " + i + " (took " + processingTime + " ms):");
			for (Song song : songs) {
				System.out.println("    " + song);
			}
		}
	}
}
