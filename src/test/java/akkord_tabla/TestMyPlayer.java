package akkord_tabla;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMyPlayer
{
	private static Chord test1 = new Chord(0,"Test","MusicString",new int[]{1,2,3,4,5,6});

	@Test
	public void testPlay1() 
	{
		MyPlayer.play(test1);
	}
	
	@Test
	public void testPlay2() 
	{
		MyPlayer.play(MusicString.getMusicString(2, 4));
	}
	
	@Test
	public void testConstructor() 
	{
		MyPlayer m = new MyPlayer();
	}

}
