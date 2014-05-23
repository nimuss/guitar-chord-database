package akkord_tabla;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDrawing 
{
	private static Chord test1 = new Chord(0,"Test","MusicString",new int[]{1,2,3,4,5,6});

	@Test
	public void testNewChord() 
	{
		Drawing d = new Drawing();
		d.newChord(test1);
	}
	
	@Test
	public void testConstructor() 
	{
		Drawing d = new Drawing();
		assertNotEquals(d, null);
	}
	
	

}
