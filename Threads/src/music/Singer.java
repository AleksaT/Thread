package music;

public class Singer {

	private String name;
	private Voice voice;
	private Performance performance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Voice getVoice() {
		return voice;
	}
	public void setVoice(Voice voice) {
		this.voice = voice;
	}
	public Performance getPerformance() {
		return performance;
	}
	public void setPerformance(Performance performance) {
		this.performance = performance;
	}
	public Singer(String name, Voice voice, Performance performance) {
		super();
		this.name = name;
		this.voice = voice;
		this.performance = performance;
	}
	
	public Singer() {
		super();
		
	}
	public void sing(Song song, int noOfRepetitions){
		for (int i = 0; i < noOfRepetitions; i+=2) {
			if(this.voice == Voice.LEAD){
			System.out.println(song.getLyrics().get(i% song.getLyrics().size()));
			
			}else {
				if (this.voice == Voice.BACKNIG){
					System.out.println(song.getLyrics().get(i% song.getLyrics().size())+1);	
				}
				
			}
		}
		
	}
	
	public synchronized void singWithDelay(Song song, int noOfRepetitions){
		for (int i = 0; i < noOfRepetitions; i+=2) {
			if(this.voice == Voice.LEAD){
			try {
				wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(song.getLyrics().get(i% song.getLyrics().size()));
			
			}else {
				if (this.voice == Voice.BACKNIG){
					try {
						wait(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(song.getLyrics().get(i% song.getLyrics().size()+1));	
				}
				
			}
		}
		
	}
	
	
}
