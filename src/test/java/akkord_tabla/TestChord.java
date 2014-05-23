package akkord_tabla;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A {@link Chord} osztály JUNIT tesztelésére létrehozott osztály. 
 * 
 * @author Csaba Székelyhídi
 *
 */
public class TestChord 
{
	private static Chord test1 = new Chord(0,"Test","MusicString",new int[]{1,2,3,4,5,6});
	
	/**
	 * A {@link Chord} osztály {@code toString()} metódusának tesztelése.
	 */
	@Test
	public void testToString() 
	{
		assertEquals( test1.toString(), test1.name );
	}
	
	/**
	 * A {@link Chord} osztály {@code getFingers()} metódusának tesztelése.
	 */
	@Test
	public void testGetFingers()
	{
		int[] test = test1.getFingers();
		
		assertEquals( test[0], 1 );
		assertEquals( test[1], 2 );
		assertEquals( test[2], 3 );
		assertEquals( test[3], 4 );
		assertEquals( test[4], 5 );
		assertEquals( test[5], 6 );
	}
	
	/**
	 * A {@link Chord} osztály húrok lefogását reprezentáló publikus adattagjainak tesztelése.
	 */
	@Test
	public void testPublicFingers()
	{
		assertEquals( test1.e1, 1 );
		assertEquals( test1.b2, 2 );
		assertEquals( test1.g3, 3 );
		assertEquals( test1.d4, 4 );
		assertEquals( test1.a5, 5 );
		assertEquals( test1.e6, 6 );
	}
	
	/**
	 * A {@link Chord} osztályban reprezentált akkord nevének publikus adattagjának tesztelése.
	 */
	@Test
	public void testPublicName()
	{
		assertEquals( test1.name, "Test" );
	}
	
	/**
	 * A {@link Chord} osztályban reprezentált akkord {@code JFugue}-ban használatos {@code MusicString} publikus adattagjának tesztelése.
	 */
	@Test
	public void testPublicMusicString()
	{
		assertEquals( test1.music, "MusicString" );
	}
	
	@Test
	public void testEmptyConstructor()
	{
		Chord c = new Chord();
		c = test1;
		assertEquals(c, test1);
	}

}
