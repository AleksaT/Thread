package music;

public class Singer extends Thread{

	private String name1;
	private Voice voice;
	private Performance performance;
	private boolean stop;
	private Synchronize synch;
	public String getName1() {
		return name1;
	}
	public void setName1(String name) {
		this.name1 = name;
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
		this.name1 = name;
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
	private void sing(){
		Song song = this.performance.getSong();
		long delay = this.performance.getDelay();
		
		int i = 0;
		String line = null;
		while(!stop){
			if(this.voice == Voice.LEAD){
				line = song.getLyrics().get(i% song.getLyrics().size());
				synch.singLeadLine(line, delay);
			};
            if(this.voice == Voice.BACKNIG){
				line = '\t'+song.getLyrics().get(i% song.getLyrics().size()+1);
				synch.singBackLine(line, delay);
			};
			
		i+=2;	
		}
	}
	public void run(){
		sing();
		
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public Singer(String name1, Voice voice, Performance performance,
			boolean stop, Synchronize synch) {
		super();
		this.name1 = name1;
		this.voice = voice;
		this.performance = performance;
		this.stop = stop;
		this.synch = synch;
	}
	public Synchronize getSynch() {
		return synch;
	}
	public void setSynch(Synchronize synch) {
		this.synch = synch;
	}
	
	
}

