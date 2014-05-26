package akkord_tabla;

import org.jfugue.Player;

/**
 * Lejátszásért felelős osztály.
 * @author Csaba Székelyhídi
 */
public class MyPlayer 
{
	/**
	 * A kiválasztott hangszer.
	 */
	public static String selectedInstrument;
	
	/**
	 * Egy teljes akkord lejátszása.
	 * @param selected a lejátszandó akkord
	 */
	public static void play( final Chord selected )
	{
		Thread p = new Thread() 
		{
		    public void run() 
		    {
		    	String s = "I["+selectedInstrument+"] ";
		    	
		    	s += MusicString.getChordMusicString(selected);
		    	
		        Player p = new Player();
				p.play(s);
		    }  
		};
		p.start();
	}
	
	/**
	 * Egy hang lejátszása.
	 * @param s a lejátszandó hang
	 */
	public static void play( final String s )
	{
		Thread p = new Thread() 
		{
		    public void run() 
		    {
		        Player p = new Player();
				p.play("I["+selectedInstrument+"] "+s+"w");
		    }  
		};
		p.start();
	}
}
