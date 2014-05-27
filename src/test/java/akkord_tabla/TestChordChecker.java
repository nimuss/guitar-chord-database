package akkord_tabla;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestChordChecker 
{
	ChordChecker check = new ChordChecker();
	
	private static Chord Em = new Chord(0,"Em","Eminor",new int[]{0,0,0,2,2,0});
	private static Chord E = new Chord(0,"E","Emajor",new int[]{0,0,1,2,2,0});

	@Test
	public void testMajor() 
	{
		assertEquals( check.isMajor(E), true );
		assertNotEquals( check.isMinor(E), true );
	}
	
	@Test
	public void testMinor() 
	{
		assertEquals( check.isMinor(Em), true );
		assertNotEquals( check.isMajor(Em), true );
	}

}
