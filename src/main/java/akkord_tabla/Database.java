package akkord_tabla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Az adatbáziskapcsolat létrehozásáért és lezárásáért, illetve lekérdezés végrehajtásáért felelős osztály.
 * @author Csaba Székelyhídi
 *
 */
public class Database
{
	/**
	 * A kapcsolat megadása.
	 */
	private static Connection connection = null;
	
	/**
	 * A lekérdezés megadása.
	 */
	private static PreparedStatement st2 = null;
	/**
	 * A lekérdezés eredménye.
	 */
	private static ResultSet rs2 = null;

	private static Chord[] chord = new Chord[100];
	private static int id;
	
	public static Chord[] getAllChords() 
	{			
		try 
		{
			st2 = connection.prepareStatement("SELECT * FROM chords");
			rs2 = st2.executeQuery();
			
			for (int i=0; rs2.next(); i++ )
			{
				int id = rs2.getInt("ID");
				String name = rs2.getString("NAME");
				String music = rs2.getString("CHORD");
				
				int e1 = rs2.getInt("E1");
				int b2 = rs2.getInt("B2");
				int g3 = rs2.getInt("G3");
				int d4 = rs2.getInt("D4");
				int a5 = rs2.getInt("A5");
				int e6 = rs2.getInt("E6");	
					
				chord[i] = new Chord(id,name,music,new int[]{e1,b2,g3,d4,a5,e6});		
				
				Main.logger.debug(chord.toString()+" akkord letöltve");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
		return chord;
	}
	
	public static boolean insertNewChord( Chord chord ) 
	{	
		try 
		{
			st2 = connection.prepareStatement("INSERT INTO chords VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			st2.setInt(1, chord.id);
			st2.setString(2, chord.name );
			st2.setString(3, chord.music );
			st2.setInt(4, chord.e1);
			st2.setInt(5, chord.b2);
			st2.setInt(6, chord.g3);
			st2.setInt(7, chord.d4);
			st2.setInt(8, chord.a5);
			st2.setInt(9, chord.e6);
					
			st2.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Új akkord feltöltve!");
			
			Main.logger.info("Akkord hozzáadás sikeres");
		} 
		catch (SQLException e) 
		{
			Main.logger.error("Akkord hozzáadása sikertelen");
			return false;
		}
		
		return true;	
	}
	
	public static int getLastId() 
	{		
		try 
		{
			st2 = connection.prepareStatement("SELECT id FROM chords WHERE rownum = 1 ORDER BY id DESC");
			rs2 = st2.executeQuery();
			
			while ( rs2.next() )
			{
				id = rs2.getInt(1);	
			}
			
			Main.logger.debug("Utolsó ID: "+id);
			Main.logger.info("Utolsó ID lekérése sikeres");
		} 
		catch (SQLException e) 
		{
			Main.logger.error("Utolsó ID lekérése sikertelen");
		}	
		
		return id;
	}
	
	public static void connect()
	{
		try 
		{
			//DriverManager.registerDriver( new oracle.jdbc.OracleDriver() );
			Class.forName("oracle.jdbc.OracleDriver");
		}
		catch (Exception e)
		{
			Main.logger.error("A driver nem elérhető");
			System.exit(1);
		}
		Main.logger.info("A driver elérhető");
		
		try 
		{
			connection = DriverManager.getConnection("jdbc:oracle:thin:@db.inf.unideb.hu:1521:ora11g", "h_GVLAHG", "kassai");
			Main.logger.info("A kapcsolat sikeres!");
		} 
		catch (SQLException e) 
		{
			Main.logger.error("A kapcsolat létrehozása sikertelen");
		}
	}
	
	public static void close()
	{
		try 
		{
			rs2.close();
			st2.close();
			connection.close();
			Main.logger.info("A kapcsolat bezárása sikeres");
		}
		catch (SQLException e)
		{
			Main.logger.error("A kapcsolat bezárása sikertelen");
		}
		
		
		
	}

}
