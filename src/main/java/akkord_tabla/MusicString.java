package akkord_tabla;

/**
 * A lejátszáshoz szükséges {@code JFugue}-ban használt {@code MusicString}-ek előállításáért felelős osztály.
 * @author Csaba Székelyhídi
 */
public class MusicString 
{
	/**
	 * Visszaadja a lefogott hang zenei ábécés megnevezését.
	 * @param x a lefogott húr sorszáma ({@code E1}-től {@code E6}-ig) mínusz 1.
	 * @param y a lefogott bund sorszáma
	 * @return Az lefogott hang zenei ábécés megnevezése
	 */
	public static String getMusicString( int x, int y )
	{
		String[][] s = new String[][]{	{"E6","F6","F#6","G6","G#6","A6","A#6","B6","C7","C#7","D7","D#7","E7","F7","F#7","G7"},
										{"B5","C6","C#6","D6","D#6","E6","F6","F#6","G6","G#6","A6","A#6","B6","C7","C#7","D7"},
										{"G5","G#5","A5","A#5","B5","C6","C#6","D6","D#6","E6","F6","F#6","G6","G#6","A6","A#6"},
										{"D5","D#5","E5","F5","F#5","G5","G#5","A5","A#5","B5","C6","C#6","D6","D#6","E6","F6"},
										{"A4","A#4","B4","C5","C#5","D5","D#5","E5","F5","F#5","G5","G#5","A5","A#5","B5","C5"},
										{"E4","F4","F#4","G4","G#4","A4","A#4","B4","C5","C#5","D5","D#5","E5","F5","F#5","G5"}	
									 };
		
		if ( y < 0 )
		{
			return "-";
		}
		return s[x][y];
	}
	
	/**
	 * Visszaadja a lefogott akkord lejátszáshoz szükséges {@code MusicString}-jét.
	 * @param selected a lejátszani kívánt akkord
	 * @return Az akkord teljes lejátszásához szükséges MusicString
	 */
	public static String getChordMusicString( Chord selected )
	{
    	String s = "";
    	
    	s += selected.e6 >= 0 ? getMusicString(5, selected.e6)+"w+" : "";
    	s += selected.a5 >= 0 ? getMusicString(4, selected.a5)+"w+" : "";
    	s += selected.d4 >= 0 ? getMusicString(3, selected.d4)+"w+" : "";
    	s += selected.g3 >= 0 ? getMusicString(2, selected.g3)+"w+" : "";
    	s += selected.b2 >= 0 ? getMusicString(1, selected.b2)+"w+" : "";
    	s += selected.e1 >= 0 ? getMusicString(0, selected.e1)+"w" : "";
    	
    	return s;
	}
}
