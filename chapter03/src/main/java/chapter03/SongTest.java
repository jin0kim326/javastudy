package chapter03;

public class SongTest {

	public static void main(String[] args) {
		Song song = new Song();
		song.setTitle("좋은날");
		song.setArtist("이민수");
		song.setAlbum("Real");
		song.setComposer("composer");
		song.setYear(2010);
		song.setTrack(3);
		
		Song song1 = new Song("좋은날", "아이유", "이민수", "Real", 2010, 3);
		song.show();
		song1.show();
		
		Song song2 = new Song("좋은날", "아이유");
		song2.show();

	}

}
