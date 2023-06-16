package Pattern.Adapter;

public class AudioAdapter implements MediaPlayer {
	
	AdvancedMediaPlayer advancedMediaPlayer;

	public AudioAdapter(String audioType) {
		if(audioType.equalsIgnoreCase("vlc")) {
			advancedMediaPlayer = new VlcPlayer();
		} else if(audioType.equalsIgnoreCase("mp4")) {
			advancedMediaPlayer = new Mp4Player();
		}
	}

	@Override
	public void play(String audioType, String fileAudio) {
		if(audioType.equalsIgnoreCase("vlc")) {
			advancedMediaPlayer.playVlc(fileAudio);
		} else if(audioType.equalsIgnoreCase("mp4")) {
			advancedMediaPlayer.playMp4(fileAudio);
		}
		
	}

}
