//http://www.anyexample.com/programming/java/java_play_wav_sound_file.xml
//IN TITLE CLASS....
//Music music = new Music("music/D8.wav");
//music.start();

import java.io.File; 
import java.io.IOException; 
import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.DataLine; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.SourceDataLine; 
import javax.sound.sampled.UnsupportedAudioFileException; 
import javax.swing.JOptionPane;

/**
 * @author Stephanie Brown
 */
public class Music extends Thread 
{ 

	private String filename;
	private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb 

	public Music(String wavfile) 
	{ 
		filename = wavfile;
	}

	public void run() 
	{ 

		File soundFile = new File(filename);
		if (!soundFile.exists()) 
		{ 
			JOptionPane.showMessageDialog(null, "Wave file not found: " + filename);
			return;
		} 

		AudioInputStream audioInputStream = null;
		try 
		{ 
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} 
		catch (UnsupportedAudioFileException e) 
		{ 
			e.printStackTrace();
			return;
		} 
		catch (IOException e) 
		{ 
			e.printStackTrace();
			return;
		} 

		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try 
		{ 
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} 
		catch (LineUnavailableException e) 
		{ 
			e.printStackTrace();
			return;
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace();
			return;
		} 

		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

		try 
		{ 
			while (nBytesRead != -1) 
			{ 
				interrupt();
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0) 
					auline.write(abData, 0, nBytesRead);
			} 
		} 
		catch (IOException e) 
		{ 
			e.printStackTrace();
			return;
		} 
		finally 
		{ 
			auline.drain();
			auline.close();
		} 

	}
}