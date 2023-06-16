package Pattern.Adapter;

public class VlcPlayer implements AdvancedMediaPlayer {

	@Override
	public void playMp4(String fileName) {
		
	}

	@Override
	public void playVlc(String fileName) {
		System.out.println("Sto ascoltando un formato VLC: " + fileName);
	}

}
