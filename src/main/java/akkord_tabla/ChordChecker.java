package akkord_tabla;

public class ChordChecker 
{	
	public boolean isMajor( Chord c )
	{
		int[] fingers = c.getFingers();
		
		String kisTerc = new String();
		String nagyTerc = new String();
		
		int basszus = BassSound(c);
		
		kisTerc = MusicString.getMusicString(basszus, fingers[basszus]+4);
		kisTerc = kisTerc.substring(0, kisTerc.length()-1);
		
		nagyTerc = MusicString.getMusicString(basszus, fingers[basszus]+7);
		nagyTerc = nagyTerc.substring(0, nagyTerc.length()-1);
		
		boolean isNagyTerc = false;
		boolean isKisTerc = false;
		
		for (int i = 0; i <= basszus; i++) 
		{
			String tmp = MusicString.getMusicString( i, fingers[i] );
			tmp = tmp.substring(0, tmp.length()-1);

			if ( tmp.equals(kisTerc) )
			{
				isKisTerc = true;
			}
			else if ( tmp.equals(nagyTerc) )
			{
				isNagyTerc = true;
			}
		}
		
		if ( isKisTerc && isNagyTerc )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isMinor( Chord c )
	{
		int[] fingers = c.getFingers();
		
		String kisTerc = new String();
		String nagyTerc = new String();
		
		int basszus = BassSound(c);
		
		kisTerc = MusicString.getMusicString(basszus, fingers[basszus]+3);
		kisTerc = kisTerc.substring(0, kisTerc.length()-1);
		
		nagyTerc = MusicString.getMusicString(basszus, fingers[basszus]+7);
		nagyTerc = nagyTerc.substring(0, nagyTerc.length()-1);
		
		boolean isNagyTerc = false;
		boolean isKisTerc = false;
		
		for (int i = 0; i <= basszus; i++) 
		{
			String tmp = MusicString.getMusicString( i, fingers[i] );
			tmp = tmp.substring(0, tmp.length()-1);

			if ( tmp.equals(kisTerc) )
			{
				isKisTerc = true;
			}
			else if ( tmp.equals(nagyTerc) )
			{
				isNagyTerc = true;
			}
		}
		
		if ( isKisTerc && isNagyTerc )
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private int BassSound( Chord c )
	{
		int[] fingers = c.getFingers();
		for ( int i=5; i>-2; i-- )
		{
			if ( fingers[i] >= 0 )
			{
				return i;
			}
		}
		return 0;
	}
}
