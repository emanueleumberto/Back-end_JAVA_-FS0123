package Pattern.Adapter;

public class AudioPlayer implements MediaPlayer {
	
	AudioAdapter audioAdapter;

	@Override
	public void play(String audioType, String fileAudio) {
		
		if(audioType.equalsIgnoreCase("mp4")) {
			audioAdapter = new AudioAdapter(audioType);
			audioAdapter.play(audioType, fileAudio);
		} else if(audioType.equalsIgnoreCase("vlc")) {
			audioAdapter = new AudioAdapter(audioType);
			audioAdapter.play(audioType, fileAudio);
		} else {
			System.out.println("Formato audio non disponibile!!!");
		}
		
	}
	
	

}
