package song;

public class Song {
	private int id;
	private String title;
	private String artist;
	private String album;
	private int duration;

	public Song(int id, String title, String artist, String album, int duration) {
		setId(id);
		setTitle(title);
		setArtist(artist);
		setAlbum(album);
		setDuration(duration);
	}

	public int getId() {
		// return id;
		return 0;
	}

	public String getTitle() {
		// return title;
		return null;
	}

	public String getArtist() {
		// return artist;
		return null;
	}

	public String getAlbum() {
		// return album;
		return null;
	}

	public int getDuration() {
		// return duration;
		return 0;
	}

	public void setId(int id) {
		// if (id <= 0) {
		// 	System.err.println("Song id must be greater than 0");
		// 	return;
		// }

		// this.id = id;
	}

	public void setTitle(String title) {
		// if (title == null || title.isBlank()) {
		// 	System.err.println("Song title cannot be blank");
		// 	return;
		// }

		// this.title = title;
	}

	public void setArtist(String artist) {
		// if (artist == null || artist.isBlank()) {
		// 	System.err.println("Song artist cannot be blank");
		// 	return;
		// }

		// this.artist = artist;
	}

	public void setAlbum(String album) {
		// if (album == null || album.isBlank()) {
		// 	System.err.println("Song album cannot be blank");
		// 	return;
		// }

		// this.album = album;
	}

	public void setDuration(int duration) {
		// if (duration <= 0) {
		// 	System.err.println("Song duration must be greater than 0");
		// 	return;
		// }

		// this.duration = duration;
	}

	// other methods
	@Override
	public String toString() {
		// return id + ". " + title + " - " + artist + " (" + album + ", " + duration + "s)";
		return "";
	}
}
