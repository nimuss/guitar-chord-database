package akkord_tabla;

/**
 * Egy gitár akkord reprezentálása.
 * @author Csaba Székelyhídi
 */
public class Chord 
{
	/** 
	 * Adatbázisban használt egyedi azonosító.
	 */
	public int id;
	/** 
	 * Az akkord neve.
	 */
	public String name;
	/** 
	 * Az akkord {@code JFugue}-ban lejátszáshoz használatos {@code MusicString}-je.
	 */
	public String music;
	
	/** 
	 * E1 húr. 
	 */
	public int e1;
	/** 
	 * B2 húr. 
	 */
	public int b2;
	/** 
	 * G3 húr. 
	 */
	public int g3;
	/** 
	 * D4 húr. 
	 */
	public int d4;
	/** 
	 * A5 húr. 
	 */
	public int a5;
	/** 
	 * E6 húr. 
	 */
	public int e6;
	
	/**
	 * Üres konstruktor.
	 */
	public Chord()
	{
		
	}
	
	/**
	 * Egy akkord reprezentálása.
	 * 
	 * @param id Az {@link id} adattag beállítása
	 * @param name A {@link name} adattag beállítása
	 * @param music A {@link music} adattag beállítása
	 * @param finger Az {@link e1}, {@link b2}, {@link g3}, {@link d4}, {@link a5}, {@link e6} adattagok beállítása
	 */
	public Chord(int id, String name, String music, int finger[])
	{
		this.id = id;
		this.name = name;
		this.music = music;
		
		this.e1 = finger[0];
		this.b2 = finger[1];
		this.g3 = finger[2];
		this.d4 = finger[3];
		this.a5 = finger[4];
		this.e6 = finger[5];
	}
	
	/**
	 * Visszaadja az egyes húrokon lefogott bundok helyét.
	 * @return Egy {@code int[]} tömb, benne a lefogott bundok helyével, E1 húrtól az E6 húrig
	 */
	public int[] getFingers()
	{
		return new int[]{e1,b2,g3,d4,a5,e6};
	}
	
	/**
	 * Visszaadja az akkord nevét.
	 * @return name Az akkord neve
	 */
	@Override
	public String toString() 
	{
		return name;
	}
	
}
