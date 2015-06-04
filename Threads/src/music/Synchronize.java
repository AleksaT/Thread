package music;

public class Synchronize {

	private boolean leadVoiceFlag ;
	
	public Synchronize(boolean leadVoiceFlag) {
		super();
		this.leadVoiceFlag = leadVoiceFlag;
	}
	public synchronized void singLeadLine(String line, long delay){
		
		while(!leadVoiceFlag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		singOneLine(line,delay);
	}
	private void singOneLine(String line, long delay){
		
		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(line);
		leadVoiceFlag= !leadVoiceFlag;
		
		notifyAll();
	}
public synchronized void singBackLine(String line, long delay){
		
		while(leadVoiceFlag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		singOneLine(line,delay);
	}
public boolean isLeadVoiceFlag() {
	return leadVoiceFlag;
}
public void setLeadVoiceFlag(boolean leadVoiceFlag) {
	this.leadVoiceFlag = leadVoiceFlag;
}

}
