package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import song.*;

public class SongServiceProxy implements SongService {
	private SongServer server;							// aggregation
	private HashMap<Integer, Song> songsById;			// composition
	private HashMap<String, List<Song>> songsByTitle;	// composition
	private HashMap<String, List<Song>> songsByAlbum;	// composition

	// upon request, proxy pattern will provide data or cache when requested
	public SongServiceProxy(SongServer server) {
		this.server = server;
		this.songsById = new HashMap<>();
		this.songsByTitle = new HashMap<>();
		this.songsByAlbum = new HashMap<>();
	}

	// other methods
	@Override
	public Song searchById(Integer songID) {
		Song song = songsById.get(songID);
		if (song == null) {
			song = server.searchById(songID);
			if (song != null) {
				songsById.put(songID, song);
			}
		}

		return song;
	}

	@Override
	public List<Song> searchByTitle(String title) {
		if (title == null) {
			System.err.println("Title cannot be empty");
			return new ArrayList<>();
		}

		String key = title.toLowerCase();
		List<Song> results = songsByTitle.get(key);
		if (results == null) {
			results = server.searchByTitle(title);
			songsByTitle.put(key, results);
		}

		return results;
	}

	@Override
	public List<Song> searchByAlbum(String album) {
		if (album == null) {
			System.err.println("Album cannot be empty");
			return new ArrayList<>();
		}

		String key = album.toLowerCase();
		List<Song> results = songsByAlbum.get(key);
		if (results == null) {
			results = server.searchByAlbum(album);
			songsByAlbum.put(key, results);
		}

		return results;
	}
}
