package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import song.*;

public class SongServer implements SongService {
	private HashMap<Integer, Song> songs;	// aggregation

	public SongServer() {
		this.songs = new HashMap<>();
	}

	// setters
	public void addSong(Song song) {
		if (song == null) {
			System.err.println("Song cannot be empty");
			return;
		}

		songs.put(song.getId(), song);
	}

	// other methods
	@Override
	public Song searchById(Integer songID) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}

		return songs.get(songID);
	}

	@Override
	public List<Song> searchByTitle(String title) {
		// java requires a try/catch block for Thread.sleep
		try {
			Thread.sleep(1000);	// add a second delay to simulate
		} catch (Exception e) {
			// do nothing
		}

		List<Song> results = new ArrayList<>();
		for (Song song : songs.values()) {
			if (song.getTitle().equalsIgnoreCase(title)) {
				results.add(song);
			}
		}

		return results;
	}

	@Override
	public List<Song> searchByAlbum(String album) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}

		List<Song> results = new ArrayList<>();
		for (Song song : songs.values()) {
			if (song.getAlbum().equalsIgnoreCase(album)) {
				results.add(song);
			}
		}

		return results;
	}
}
