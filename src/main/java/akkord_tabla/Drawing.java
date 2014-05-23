package akkord_tabla;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * A gitár nyakának, és lefogási pontjainak megrajzolásáért felelős osztály.
 * @author Csaba Székelyhídi
 */
 public class Drawing extends JPanel 
 {
	 /**
	  * Lefogás pontjának sugara.
	  */
	 private int r = 9;
	 
	 /**
	  * Bundok közepének pontjai pixelben.
	  */
	 private int[] cX = new int[]{38,85,128,169,208,246,280,314,346,375,401,425,447,468,489};
	 /**
	  * Húrok közepének pontjai pixelben.
	  */
	 private int[] cY = new int[]{9,22,36,49,63,77};
	 
	 /**
	  * Előre definiált szín.
	  * {@code Zöld (153,204,0)}
	  */
	 private Color mygreen = new Color(153, 204, 0);
	 
	 /**
	  * Húrokon lefogott bundok {@code E1}-től {@code E6}-ig.
	  */
	 private int[] fingers = new int[]{-1,-1,-1,-1,-1,-1};
	  
	 /**
	  * A nyak és az akkord kirajzolása.
	  */
	 public void paintComponent(Graphics g) 
	 {
		 super.paintComponent(g);
		 
		 ImageIcon img = new ImageIcon( getClass().getResource("/neck.png") );
		 g.drawImage(img.getImage(), 10, 0, this);
		 
		 drawChord(g);
		 
	 }
	 
	 /**
	  * Az akkord kirajzolása.
	  * @param g a grafika
	  */
	 private void drawChord( Graphics g )
	 {
		 g.setFont(new Font ("Garamond", Font.BOLD , 9));
		 for (int i = 0; i < 6; i++) 
		 {
			 if ( fingers[i] > 0 )
			 {
				 g.setColor(mygreen);
				 g.fillOval(cX[fingers[i]-1], cY[i], r, r);
				 g.setColor(Color.black);
				 g.drawOval(cX[fingers[i]-1], cY[i], r, r);

				 g.setColor(Color.GRAY);
				 g.drawString("O", 6, cY[i]+9);
			 }
			 else
			 {
				 g.setColor(Color.GRAY);
				 String s = fingers[i] == 0 ? "O" : "X";
				 g.drawString(s, 6, cY[i]+9);
			 }
		 }
	 }
	 
	 /**
	  * Új akkord kirajzolása.
	  * @param c az új akkord
	  */
	 public void newChord( Chord c )
	 {
		 this.fingers = c.getFingers();
		 this.repaint();
	 }
}