package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import music.Performance;
import music.Singer;
import music.Song;
import music.Voice;

public class Test {
	
  public static final Scanner IN = new Scanner(System.in);
  
  private List<String> lyrics;
  private Song love;
  private Performance performance;
  
  private Singer bbk;
  private Singer bono;
  private void initialize(){
	  lyrics = new ArrayList<String>();
	  lyrics.add("When love comes to town I'am gona jump that train");
	  lyrics.add("When love comes to town I'am gona catch that flame");
	  lyrics.add("When love comes to town I'am gona jump that train");
	  lyrics.add("When love comes to town I'am gona jump that train");
	  
	  love = new Song("When love comes to town", lyrics);
	  performance = new Performance(love, 1000);
	  bbk = new Singer("B.B. King", Voice.LEAD, performance);
	  bono = new Singer("BOno", Voice.BACKNIG, performance);
  }
  public void testGetAllLyrics(){
	  initialize();
	  System.out.println(love.getAllLyrics()); 
  }
  public void testpickLine(){
	  initialize();
	  System.out.println(love.pickLine(Voice.LEAD, 3));
  }
  public void testSingWithRepetitions(){
	  initialize();
	  bbk.sing(love,8);
	  System.out.println();
	  bono.sing(love, 8);
	  
  }
  public void testSingWithDelay(){
	  initialize();
	  bbk.singWithDelay(love,8);
	  System.out.println();
	  bono.singWithDelay(love, 8);
	  
  }
  public void testSingWithTimer(){
	  initialize();
	  
	  Timer timer = new Timer();
	  ShoutTask shout = new ShoutTask(timer);
	  timer.schedule(shout,2500);
	  
	  bbk.singWithDelay(love,8);
	  System.out.println();
	  bono.singWithDelay(love, 8);
	  
  }
  
}
