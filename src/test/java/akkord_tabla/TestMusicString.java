package akkord_tabla;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMusicString 
{
	private static MusicString m = new MusicString();
	private static Chord test1 = new Chord(0,"Test","MusicString",new int[]{1,2,3,4,5,6});

	@Test
	public void testGetMusicString() 
	{
		assertEquals("E6", m.getMusicString(0, 0));
		assertEquals("G#5", m.getMusicString(3, 6));
		assertEquals("A#5", m.getMusicString(4, 13));
		assertEquals("-", m.getMusicString(4, -1));
	}
	
	@Test
	public void testGetChordMusicString() 
	{
		assertEquals("A#4w+D5w+F#5w+A#5w+C#6w+F6w", m.getChordMusicString(test1));
	}

}
