package Pattern.Adapter;

public class Mp4Player implements AdvancedMediaPlayer {

	@Override
	public void playMp4(String fileName) {
		System.out.println("Sto ascoltando un formato Mp4: " + fileName);
	}

	@Override
	public void playVlc(String fileName) {
	
	}

}
