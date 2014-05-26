package akkord_tabla;

import java.awt.EventQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A program fő osztálya.
 * @author Csaba Székelyhídi
 */
public class Main
{
	/**
	 * A naplózáshoz szükséges adattag.
	 */
	public static Logger logger = LoggerFactory.getLogger(Main.class);
	
	/**
	 * Az adatbázis osztály.
	 */
	public static Database db;
	
	/**
	 * Main metódus.
	 * @param args a main() argumentumai
	 */
	public static void main(String[] args) 
	{	
		db.connect();
		
		final Chord[] chords = db.getAllChords();
		int id = new Database().getLastId();
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Design frame = new Design(chords);
					frame.setVisible(true);
					logger.info("Swing felület létrehozva");
				}
				catch (Exception e) 
				{
					logger.error("Hiba a felület létrehozása közben");
				}
			}
		});
		
	}
		
}