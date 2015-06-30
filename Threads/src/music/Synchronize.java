package music;

import javax.swing.JTextArea;

public class Synchronize {

	private boolean leadVoiceFlag ;
	private boolean guitarSoloFlag;
	
	public Synchronize(boolean leadVoiceFlag, boolean guitarSoloFlag) {
		super();
		this.leadVoiceFlag = leadVoiceFlag;
		this.guitarSoloFlag = guitarSoloFlag;
	}
	public synchronized void singLeadLine(String line, long delay,JTextArea area){
		
		while(!leadVoiceFlag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		singOneLine(line,delay,area);
	}
	private void singOneLine(String line, long delay,JTextArea area){
		
		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 area.append(line +'\n');
		leadVoiceFlag= false;
		guitarSoloFlag = true;
		
		notifyAll();
	}
public synchronized void singBackLine(String line, long delay,JTextArea area){
		
		while(!guitarSoloFlag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		singOneLineBack(line,delay,area);
		
	}
private void singOneLineBack(String line, long delay,JTextArea area){
	
	try {
		wait(delay);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 area.append(line +'\n');
	leadVoiceFlag= false;
	guitarSoloFlag = false;
	notifyAll();
}

public synchronized void playGuitarSolo (String line, long delay,JTextArea area){
	
	while(guitarSoloFlag || leadVoiceFlag){
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	playGuitarLine(line,delay,area);
	
}


private void playGuitarLine(String line, long delay,JTextArea area){
	
	try {
		wait(delay);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 area.append(line +'\n');
	leadVoiceFlag = true;
	guitarSoloFlag = false;
	
	notifyAll();
		
}


public boolean isLeadVoiceFlag() {
	return leadVoiceFlag;
}
public void setLeadVoiceFlag(boolean leadVoiceFlag) {
	this.leadVoiceFlag = leadVoiceFlag;
}
public boolean isGuitarSoloFlag() {
	return guitarSoloFlag;
}
public void setGuitarSoloFlag(boolean guitarSoloFlag) {
	this.guitarSoloFlag = guitarSoloFlag;
}

}
