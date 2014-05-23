package akkord_tabla;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.LineBorder;

import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.MatteBorder;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JButton;

import org.jfugue.Player;

import java.awt.FlowLayout;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLayeredPane;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

import java.awt.CardLayout;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A program megjenítéséért felelős osztály.
 * 
 * @author Csaba Székelyhídi
 */
public class Design extends JFrame 
{
	private JPanel contentPane;
	
	private int startX;
	private int startY;

	private Drawing drawing = new Drawing();
	private Drawing drawing2 = new Drawing();
		
	private Chord[] chords;
	
	private JLayeredPane layeredPane;
	
	private JPanel panel_17;
	
	private JLabel chordName;
	private JLabel chordName2;
	private JLabel title;
	
	private JLabel label_finger_e1;
	private JLabel label_finger_b2;
	private JLabel label_finger_g3;
	private JLabel label_finger_d4;
	private JLabel label_finger_a5;
	private JLabel label_finger_e6;
	
	private JButton btnMen;
	private JButton btnBngszs;
	
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JSpinner spinner_3;
	private JSpinner spinner_4;
	private JSpinner spinner_5;
	
	private JList list;
	private JList list_1;
	
	private DefaultListModel listData;
	private DefaultListModel sublistData;
	private JTextField form_chordName;
	private JTextField form_chordString;
	
	private String[] instrument;
	private String[] instrumentMusicString;
	private String selectedInstument;
	
	
	
	public Design( Chord[] base ) 
	{
		this.chords = base;
		
		instrument = new String[]{	
				"Nylon húros gitár",
				"Fém húros gitár",
				"Elektromos Jazz gitár",
				"Elektromos gitár (tiszta)",
				"Elektromos gitár (tompított)",
				"Torzított elektromos gitár"
				};
		
		instrumentMusicString = new String[]{	
				"NYLON_STRING_GUITAR",
				"STEEL_STRING_GUITAR",
				"ELECTRIC_JAZZ_GUITAR",
				"ELECTRIC_CLEAN_GUITAR",
				"ELECTRIC_MUTED_GUITAR",
				"DISTORTION_GUITAR"
				};
		
		selectedInstument = instrumentMusicString[0];
		
		setSize(new Dimension(500, 500));
		setResizable(false);
		setPreferredSize(new Dimension(500, 500));
		setUndecorated(true);
		setType(Type.UTILITY);
		setTitle("Akkord t\u00E1bla");
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		chordName = new JLabel(chords[0].name);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		panel.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{
				startX = e.getX();
				startY = e.getY();
				
				//System.out.println(e.getX() + ";" + e.getY());
			}
		});
		
		panel.addMouseMotionListener(new MouseMotionAdapter() 
		{			
			@Override
			public void mouseDragged(MouseEvent e)
			{

				setLocation(e.getXOnScreen() - startX, e.getYOnScreen() - startY);
			}
		});
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(0.0f);
		panel.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(153, 204, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 0));
		panel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_1.setPreferredSize(new Dimension(110, 45));
		panel.add(panel_1);
		
		JLabel lblAkkord = new JLabel("Akkord\r\n");
		lblAkkord.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAkkord.setPreferredSize(new Dimension(110, 20));
		lblAkkord.setFont(new Font("Segoe Print", Font.BOLD, 24));
		lblAkkord.setForeground(new Color(255, 255, 255));
		panel_1.add(lblAkkord);
		
		JLabel lblTbla = new JLabel("t\u00E1bl\u00E1zat");
		lblTbla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTbla.setPreferredSize(new Dimension(110, 12));
		lblTbla.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		lblTbla.setForeground(new Color(0, 0, 0));
		panel_1.add(lblTbla);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_2.setBackground(new Color(153, 204, 0));
		panel_2.setPreferredSize(new Dimension(550, 45));
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setVgap(0);
		flowLayout_2.setHgap(0);
		panel_3.setBackground(new Color(153, 204, 0));
		panel_3.setPreferredSize(new Dimension(550, 20));
		panel_2.add(panel_3);
		
		btnMen = new JButton("\u00DAj akkord");
		btnMen.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				CardLayout cardLayout = (CardLayout) layeredPane.getLayout();
				cardLayout.show(layeredPane, "NewChord");
				title.setText("Új akkord");
			}
		});
		
		btnBngszs = new JButton("B\u00F6ng\u00E9sz\u00E9s");
		btnBngszs.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0)
			{
				CardLayout cardLayout = (CardLayout) layeredPane.getLayout();
				cardLayout.show(layeredPane, "ViewChord");
				title.setText("Böngészés");
			}
		});
		btnBngszs.setPreferredSize(new Dimension(100, 25));
		btnBngszs.setFocusPainted(false);
		btnBngszs.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		btnBngszs.setBackground(Color.WHITE);
		btnBngszs.setAlignmentY(0.0f);
		panel_2.add(btnBngszs);
		btnMen.setFocusPainted(false);
		btnMen.setPreferredSize(new Dimension(100, 25));
		btnMen.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		btnMen.setBackground(Color.WHITE);
		btnMen.setAlignmentY(0.0f);
		panel_2.add(btnMen);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		flowLayout_3.setVgap(0);
		flowLayout_3.setHgap(0);
		panel_4.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_4.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_4.setBackground(new Color(153, 204, 0));
		panel_4.setPreferredSize(new Dimension(14, 45));
		panel.add(panel_4);
		
		JButton btnX = new JButton("\u00D7");
		btnX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				Main.db.close();
				System.exit(0);
			}
		});
		btnX.setHorizontalTextPosition(SwingConstants.CENTER);
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setFont(new Font("Source Code Pro", Font.BOLD, 12));
		btnX.setBackground(new Color(0, 0, 0));
		btnX.setBorder(null);
		btnX.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_4.add(btnX);
		btnX.setPreferredSize(new Dimension(12, 12));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(5, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel_5.setBackground(new Color(153, 204, 0));
		contentPane.add(panel_5, BorderLayout.SOUTH);
		
		JPanel panel_6 = new JPanel();
		panel_6.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_6.setAlignmentX(Component.LEFT_ALIGNMENT);
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setVgap(0);
		flowLayout_4.setHgap(0);
		panel_6.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_6, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_8.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		flowLayout_6.setVgap(0);
		flowLayout_6.setHgap(0);
		panel_8.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		panel_8.setPreferredSize(new Dimension(694, 335));
		panel_6.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_9.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		flowLayout_9.setVgap(0);
		flowLayout_9.setHgap(0);
		panel_9.setBorder(null);
		panel_9.setPreferredSize(new Dimension(180, 332));
		panel_8.add(panel_9);
		
		listData = new DefaultListModel<Chord>();
		sublistData = new DefaultListModel();
		boolean alreadyhas = false;
		for (int i=0; i<chords.length && chords[i]!=null; i++)
		{
			for (int j=0; j<listData.getSize(); j++)
			{
				Chord tmp = (Chord) listData.get(j);
				if ( tmp.name.equals(chords[i].name)) alreadyhas = true;
			}
			if (!alreadyhas)	listData.addElement( chords[i] );	
			alreadyhas = false;
		}
		
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_13 = (FlowLayout) panel_12.getLayout();
		flowLayout_13.setVgap(0);
		flowLayout_13.setHgap(0);
		panel_12.setPreferredSize(new Dimension(180, 20));
		panel_9.add(panel_12);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_9.add(horizontalStrut_2);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		FlowLayout flowLayout_12 = (FlowLayout) panel_15.getLayout();
		flowLayout_12.setVgap(0);
		flowLayout_12.setHgap(0);
		panel_15.setPreferredSize(new Dimension(140, 293));
		panel_9.add(panel_15);
		
		JLabel lblFgdfhdfgh = new JLabel("Bevitt akkordok:");
		panel_15.add(lblFgdfhdfgh);
		lblFgdfhdfgh.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblFgdfhdfgh.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblFgdfhdfgh.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFgdfhdfgh.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFgdfhdfgh.setOpaque(true);
		lblFgdfhdfgh.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblFgdfhdfgh.setBackground(new Color(153, 204, 0));
		lblFgdfhdfgh.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblFgdfhdfgh.setHorizontalAlignment(SwingConstants.CENTER);
		lblFgdfhdfgh.setHorizontalTextPosition(SwingConstants.LEADING);
		lblFgdfhdfgh.setPreferredSize(new Dimension(136, 25));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_15.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setPreferredSize(new Dimension(136, 262));
		
		list = new JList(listData);
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent arg0) 
			{
				Chord selected = (Chord) list.getSelectedValue();
				
				drawing.newChord(selected);
				chordName.setText(selected.name);
				
				sublistData.clear();
				for (int i=0;i<100;i++)
				{
					if ( chords[i] == null ) break;
					
					if ( selected.name.equals(chords[i].name) )
					{
						//System.out.println("x");
						sublistData.addElement(chords[i]);
					}	
				}
				list_1.setSelectedIndex(0);
			}
		});
		list.setSelectionBackground(new Color(153, 204, 0));
		list.setAutoscrolls(false);
		list.setBackground(new Color(255, 255, 255));
		list.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		scrollPane.setViewportView(list);
		
		JPanel panel_main = new JPanel();
		FlowLayout fl_panel_main = (FlowLayout) panel_main.getLayout();
		fl_panel_main.setVgap(0);
		fl_panel_main.setHgap(0);
		panel_main.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_main.setBackground(Color.WHITE);
		panel_main.setPreferredSize(new Dimension(494, 293));
		panel_8.add(panel_main);
		
		JPanel panel_main_title = new JPanel();
		panel_main_title.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_main_title.setBackground(new Color(153, 204, 0));
		panel_main_title.setPreferredSize(new Dimension(490, 25));
		panel_main.add(panel_main_title);
		
		title = new JLabel("Böngészés");
		title.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_main_title.add(title);
		
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(490, 264));
		panel_main.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		layeredPane.add(panel_14, "ViewChord");
		panel_14.setLayout(null);
		
		JButton btnLejtszs = new JButton("Lej\u00E1tsz\u00E1s");
		btnLejtszs.setBackground(new Color(153, 204, 0));
		btnLejtszs.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLejtszs.setPreferredSize(new Dimension(100, 30));
		btnLejtszs.setBounds(319, 200, 150, 19);
		btnLejtszs.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				Chord selected = (Chord) list.getSelectedValue();
				//play("I[Guitar] "+selected.music+"w");
				play(selected);
			}
		});
		panel_14.add(btnLejtszs);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(249, 223, 220, 19);
		panel_16.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_14 = (FlowLayout) panel_16.getLayout();
		flowLayout_14.setAlignment(FlowLayout.LEFT);
		flowLayout_14.setVgap(0);
		flowLayout_14.setHgap(0);
		panel_14.add(panel_16);
		
		list_1 = new JList(sublistData);
		list_1.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent arg0) 
			{
				Chord tmp = (Chord) list.getSelectedValue();
				if ( list_1.getSelectedValue() != null )
				{
					Chord selected = (Chord) list_1.getSelectedValue();
					
					if (tmp.name.equals(selected.name) )
					{
						drawing.newChord(selected);
						chordName.setText(selected.name);
						chordName2.setText(selected.name);
						
						setPrintData( selected );
					}
				}
			}
		});
		list_1.setBackground(new Color(153, 204, 0));
		list_1.setOpaque(false);
		list_1.setForeground(new Color(153, 204, 0));
		list_1.setSelectionForeground(new Color(102, 153, 0));
		list_1.setFocusTraversalPolicyProvider(true);
		list_1.setBorder(null);
		list_1.setFixedCellWidth(30);
		
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list_1.getCellRenderer();  
		
		JLabel verziok = new JLabel("Verzi\u00F3k:");
		verziok.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		verziok.setHorizontalAlignment(SwingConstants.CENTER);
		verziok.setPreferredSize(new Dimension(70, 15));
		panel_16.add(verziok);
		
		list_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		list_1.setAlignmentY(Component.TOP_ALIGNMENT);
		list_1.setSelectedIndex(0);
		list_1.setFixedCellHeight(17);
		list_1.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		list_1.setVisibleRowCount(1);
		list_1.setSelectionBackground(new Color(102, 153, 0));
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list_1.setBounds(0, 0, 1, 1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(204, 255, 204));
		panel_16.add(scrollPane_1);
		scrollPane_1.setOpaque(false);
		scrollPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setPreferredSize(new Dimension(150, 19));
		
		scrollPane_1.setViewportView(list_1);
		
		chordName2 = new JLabel( chordName.getText() );
		chordName2.setHorizontalAlignment(SwingConstants.CENTER);
		chordName2.setFont(new Font("Segoe Script", Font.PLAIN, 42));
		chordName2.setBounds(319, 148, 150, 64);
		panel_14.add(chordName2);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_10 = (FlowLayout) panel_11.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		flowLayout_10.setVgap(0);
		flowLayout_10.setHgap(0);
		panel_11.setBounds(15, 15, 200, 160);
		panel_14.add(panel_11);
		
		JLabel lblEgyesHrokonJtszott = new JLabel("Egyes h\u00FArokon j\u00E1tszott hangok:");
		lblEgyesHrokonJtszott.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblEgyesHrokonJtszott.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEgyesHrokonJtszott.setHorizontalAlignment(SwingConstants.CENTER);
		lblEgyesHrokonJtszott.setPreferredSize(new Dimension(200, 20));
		panel_11.add(lblEgyesHrokonJtszott);
		
		Component glue_4 = Box.createGlue();
		glue_4.setPreferredSize(new Dimension(200, 10));
		panel_11.add(glue_4);
		
		JLabel label_e1 = new JLabel("E1 h\u00FAr:");
		panel_11.add(label_e1);
		label_e1.setPreferredSize(new Dimension(50, 20));
		label_e1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		label_finger_e1 = new JLabel("");
		label_finger_e1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_finger_e1.setHorizontalAlignment(SwingConstants.CENTER);
		label_finger_e1.setPreferredSize(new Dimension(60, 20));
		panel_11.add(label_finger_e1);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalGlue_2.setPreferredSize(new Dimension(10, 20));
		panel_11.add(horizontalGlue_2);
		
		JButton btnLejtszs_1 = new JButton("Lej\u00E1tsz\u00E1s");
		btnLejtszs_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				play( label_finger_e1.getText() );
			}
		});
		btnLejtszs_1.setBackground(new Color(153, 204, 0));
		btnLejtszs_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLejtszs_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLejtszs_1.setPreferredSize(new Dimension(80, 20));
		panel_11.add(btnLejtszs_1);
		
		Component glue_5 = Box.createGlue();
		glue_5.setPreferredSize(new Dimension(200, 2));
		panel_11.add(glue_5);
		
		JLabel label_b2 = new JLabel("B2 h\u00FAr:");
		label_b2.setPreferredSize(new Dimension(50, 20));
		label_b2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_11.add(label_b2);
		
		label_finger_b2 = new JLabel("");
		label_finger_b2.setPreferredSize(new Dimension(60, 20));
		label_finger_b2.setHorizontalAlignment(SwingConstants.CENTER);
		label_finger_b2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_11.add(label_finger_b2);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalGlue_3.setPreferredSize(new Dimension(10, 20));
		panel_11.add(horizontalGlue_3);
		
		JButton button = new JButton("Lej\u00E1tsz\u00E1s");
		button.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				play( label_finger_b2.getText() );
			}
		});
		button.setPreferredSize(new Dimension(80, 20));
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBorder(new LineBorder(new Color(0, 0, 0)));
		button.setBackground(new Color(153, 204, 0));
		panel_11.add(button);
		
		Component glue_6 = Box.createGlue();
		glue_6.setPreferredSize(new Dimension(200, 2));
		panel_11.add(glue_6);
		
		JLabel label_g3 = new JLabel("G3 h\u00FAr:");
		label_g3.setPreferredSize(new Dimension(50, 20));
		label_g3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_11.add(label_g3);
		
		label_finger_g3 = new JLabel("");
		label_finger_g3.setPreferredSize(new Dimension(60, 20));
		label_finger_g3.setHorizontalAlignment(SwingConstants.CENTER);
		label_finger_g3.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_11.add(label_finger_g3);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalGlue_4.setPreferredSize(new Dimension(10, 20));
		panel_11.add(horizontalGlue_4);
		
		JButton button_1 = new JButton("Lej\u00E1tsz\u00E1s");
		button_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				play( label_finger_g3.getText() );
			}
		});
		button_1.setPreferredSize(new Dimension(80, 20));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_1.setBackground(new Color(153, 204, 0));
		panel_11.add(button_1);
		
		Component glue_7 = Box.createGlue();
		glue_7.setPreferredSize(new Dimension(200, 2));
		panel_11.add(glue_7);
		
		JLabel label_d4 = new JLabel("D4 h\u00FAr:");
		label_d4.setPreferredSize(new Dimension(50, 20));
		label_d4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_11.add(label_d4);
		
		label_finger_d4 = new JLabel("");
		label_finger_d4.setPreferredSize(new Dimension(60, 20));
		label_finger_d4.setHorizontalAlignment(SwingConstants.CENTER);
		label_finger_d4.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_11.add(label_finger_d4);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalGlue_5.setPreferredSize(new Dimension(10, 20));
		panel_11.add(horizontalGlue_5);
		
		JButton button_2 = new JButton("Lej\u00E1tsz\u00E1s");
		button_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				play( label_finger_d4.getText() );
			}
		});
		button_2.setPreferredSize(new Dimension(80, 20));
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_2.setBackground(new Color(153, 204, 0));
		panel_11.add(button_2);
		
		Component glue_8 = Box.createGlue();
		glue_8.setPreferredSize(new Dimension(200, 2));
		panel_11.add(glue_8);
		
		JLabel label_a5 = new JLabel("A5 h\u00FAr:");
		label_a5.setPreferredSize(new Dimension(50, 20));
		label_a5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_11.add(label_a5);
		
		label_finger_a5 = new JLabel("");
		label_finger_a5.setPreferredSize(new Dimension(60, 20));
		label_finger_a5.setHorizontalAlignment(SwingConstants.CENTER);
		label_finger_a5.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_11.add(label_finger_a5);
		
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalGlue_6.setPreferredSize(new Dimension(10, 20));
		panel_11.add(horizontalGlue_6);
		
		JButton button_3 = new JButton("Lej\u00E1tsz\u00E1s");
		button_3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				play( label_finger_a5.getText() );
			}
		});
		button_3.setPreferredSize(new Dimension(80, 20));
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_3.setBackground(new Color(153, 204, 0));
		panel_11.add(button_3);
		
		Component glue_9 = Box.createGlue();
		glue_9.setPreferredSize(new Dimension(200, 2));
		panel_11.add(glue_9);
		
		JLabel label_e6 = new JLabel("E6 h\u00FAr:");
		label_e6.setPreferredSize(new Dimension(50, 20));
		label_e6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_11.add(label_e6);
		
		label_finger_e6 = new JLabel("");
		label_finger_e6.setPreferredSize(new Dimension(60, 20));
		label_finger_e6.setHorizontalAlignment(SwingConstants.CENTER);
		label_finger_e6.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_11.add(label_finger_e6);
		
		Component horizontalGlue_7 = Box.createHorizontalGlue();
		horizontalGlue_7.setPreferredSize(new Dimension(10, 20));
		panel_11.add(horizontalGlue_7);
		
		JButton button_4 = new JButton("Lej\u00E1tsz\u00E1s");
		button_4.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				play( label_finger_e6.getText() );
			}
		});
		button_4.setPreferredSize(new Dimension(80, 20));
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_4.setBackground(new Color(153, 204, 0));
		panel_11.add(button_4);
		
		JPanel panel_13 = new JPanel();
		FlowLayout flowLayout_17 = (FlowLayout) panel_13.getLayout();
		flowLayout_17.setVgap(0);
		flowLayout_17.setHgap(0);
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(15, 197, 200, 45);
		panel_14.add(panel_13);
		
		JLabel lblLejtszshozHasznltHangszer = new JLabel("Lej\u00E1tsz\u00E1shoz haszn\u00E1lt hangszer:");
		lblLejtszshozHasznltHangszer.setPreferredSize(new Dimension(200, 20));
		lblLejtszshozHasznltHangszer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_13.add(lblLejtszshozHasznltHangszer);
		
		JComboBox comboBox = new JComboBox(instrument);
		comboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox c = (JComboBox) e.getSource();
                selectedInstument = instrumentMusicString[c.getSelectedIndex()];
			}
		});
		comboBox.setBorder(new LineBorder(Color.BLACK));
		comboBox.setPreferredSize(new Dimension(200, 25));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_13.add(comboBox);
		
		panel_17 = new JPanel();
		layeredPane.setLayer(panel_17, 2);
		panel_17.setBackground(Color.WHITE);
		layeredPane.add(panel_17, "NewChord");
		drawing2.setBackground(Color.WHITE);
		drawing2.setAlignmentX(Component.LEFT_ALIGNMENT);
		drawing2.setPreferredSize(new Dimension(480, 95));
		
		panel_17.add(drawing2);
		
		JPanel panel_18 = new JPanel();
		FlowLayout flowLayout_11 = (FlowLayout) panel_18.getLayout();
		flowLayout_11.setVgap(0);
		flowLayout_11.setHgap(0);
		panel_18.setBackground(Color.WHITE);
		panel_18.setPreferredSize(new Dimension(480, 150));
		panel_17.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		FlowLayout flowLayout_16 = (FlowLayout) panel_19.getLayout();
		flowLayout_16.setVgap(0);
		flowLayout_16.setHgap(0);
		flowLayout_16.setAlignment(FlowLayout.RIGHT);
		panel_19.setPreferredSize(new Dimension(200, 150));
		panel_19.setBackground(Color.WHITE);
		panel_18.add(panel_19);
		
		Component glue_3 = Box.createGlue();
		glue_3.setPreferredSize(new Dimension(200, 10));
		panel_19.add(glue_3);
		
		JLabel lblAdatok = new JLabel("Adatok");
		lblAdatok.setOpaque(true);
		lblAdatok.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdatok.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdatok.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAdatok.setBackground(new Color(153, 204, 0));
		lblAdatok.setPreferredSize(new Dimension(200, 25));
		panel_19.add(lblAdatok);
		
		Component glue_2 = Box.createGlue();
		glue_2.setPreferredSize(new Dimension(200, 10));
		panel_19.add(glue_2);
		
		JLabel lblAkkordNeve = new JLabel("Akkord neve:");
		lblAkkordNeve.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAkkordNeve.setPreferredSize(new Dimension(90, 25));
		panel_19.add(lblAkkordNeve);
		
		form_chordName = new JTextField();
		form_chordName.setBorder(new LineBorder(Color.BLACK));
		form_chordName.setPreferredSize(new Dimension(100, 25));
		panel_19.add(form_chordName);
		
		Component glue = Box.createGlue();
		glue.setPreferredSize(new Dimension(200, 3));
		panel_19.add(glue);
		
		JLabel lblMusicstring = new JLabel("MusicString:");
		lblMusicstring.setPreferredSize(new Dimension(90, 25));
		lblMusicstring.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_19.add(lblMusicstring);
		
		form_chordString = new JTextField();
		form_chordString.setPreferredSize(new Dimension(100, 25));
		form_chordString.setBorder(new LineBorder(Color.BLACK));
		panel_19.add(form_chordString);
		
		Component glue_1 = Box.createGlue();
		glue_1.setPreferredSize(new Dimension(200, 8));
		panel_19.add(glue_1);
		
		JButton btnElklds = new JButton("Elk\u00FCld\u00E9s");
		btnElklds.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{		
				int newID = Main.db.getLastId() + 1;
				String newNAME = form_chordName.getText();
				String newString = form_chordString.getText();
				int[] newF = new int[]{	(int) spinner.getValue(),
										(int) spinner_1.getValue(),
										(int) spinner_2.getValue(),
										(int) spinner_3.getValue(),
										(int) spinner_4.getValue(),
										(int) spinner_5.getValue(),
									  };
				final Chord toInsert = new Chord(newID, newNAME, newString, newF);
				Thread t = new Thread()
				{
					boolean b = Main.db.insertNewChord( toInsert );
				};
				chords = Main.db.getAllChords();
				
			}
		});
		btnElklds.setBackground(new Color(153, 204, 0));
		btnElklds.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnElklds.setPreferredSize(new Dimension(200, 25));
		panel_19.add(btnElklds);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setPreferredSize(new Dimension(40, 0));
		panel_18.add(horizontalGlue);
		
		JPanel panel_20 = new JPanel();
		FlowLayout flowLayout_15 = (FlowLayout) panel_20.getLayout();
		flowLayout_15.setAlignment(FlowLayout.RIGHT);
		flowLayout_15.setVgap(0);
		flowLayout_15.setHgap(0);
		panel_20.setPreferredSize(new Dimension(100, 150));
		panel_20.setBackground(Color.WHITE);
		panel_18.add(panel_20);
		
		JLabel lblE = new JLabel("E1");
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblE.setPreferredSize(new Dimension(50, 25));
		panel_20.add(lblE);
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				spinnerChanged();
				play( getMusicString(0, (int) spinner.getValue() ) );
			}
		});
		spinner.setModel(new SpinnerNumberModel(-1, -1, 15, 1));
		spinner.setPreferredSize(new Dimension(50, 25));
		panel_20.add(spinner);
		
		JLabel lblB = new JLabel("B2");
		lblB.setPreferredSize(new Dimension(50, 25));
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		panel_20.add(lblB);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(-1, -1, 15, 1));
		spinner_1.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				spinnerChanged();
				play( getMusicString(1, (int) spinner_1.getValue() ) );
			}
		});
		spinner_1.setPreferredSize(new Dimension(50, 25));
		panel_20.add(spinner_1);
		
		JLabel lblG = new JLabel("G3");
		lblG.setPreferredSize(new Dimension(50, 25));
		lblG.setHorizontalAlignment(SwingConstants.CENTER);
		lblG.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		panel_20.add(lblG);
		
		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(-1, -1, 15, 1));
		spinner_2.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				spinnerChanged();
				play( getMusicString(2, (int) spinner_2.getValue() ) );
			}
		});
		spinner_2.setPreferredSize(new Dimension(50, 25));
		panel_20.add(spinner_2);
		
		JLabel lblD = new JLabel("D4");
		lblD.setPreferredSize(new Dimension(50, 25));
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		panel_20.add(lblD);
		
		spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(-1, -1, 15, 1));
		spinner_3.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				spinnerChanged();
				play( getMusicString(3, (int) spinner_3.getValue() ) );
			}
		});
		spinner_3.setPreferredSize(new Dimension(50, 25));
		panel_20.add(spinner_3);
		
		JLabel lblA = new JLabel("A5");
		lblA.setPreferredSize(new Dimension(50, 25));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		panel_20.add(lblA);
		
		spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(-1, -1, 15, 1));
		spinner_4.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				spinnerChanged();
				play( getMusicString(4, (int) spinner_4.getValue() ) );
			}
		});
		spinner_4.setPreferredSize(new Dimension(50, 25));
		panel_20.add(spinner_4);
		
		JLabel lblE_1 = new JLabel("E6");
		lblE_1.setPreferredSize(new Dimension(50, 25));
		lblE_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		panel_20.add(lblE_1);
		
		spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(-1, -1, 15, 1));
		spinner_5.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				spinnerChanged();
				play( getMusicString(5, (int) spinner_5.getValue() ) );
			}
		});
		spinner_5.setPreferredSize(new Dimension(50, 25));
		panel_20.add(spinner_5);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalGlue_1.setPreferredSize(new Dimension(40, 0));
		panel_18.add(horizontalGlue_1);
		
		
		String[] s = new String[]{"1","2","3"};
		renderer.setHorizontalAlignment(JLabel.CENTER);
		renderer.setText("1");
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(null);
		panel_7.setBackground(Color.WHITE);
		panel_7.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_7.setAlignmentX(Component.LEFT_ALIGNMENT);
		FlowLayout flowLayout_5 = (FlowLayout) panel_7.getLayout();
		flowLayout_5.setAlignment(FlowLayout.RIGHT);
		flowLayout_5.setVgap(0);
		flowLayout_5.setHgap(0);
		panel_7.setPreferredSize(new Dimension(694, 95));
		panel_6.add(panel_7);
		
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_10.getLayout();
		flowLayout_7.setHgap(0);
		panel_10.setBackground(new Color(255, 255, 255));
		panel_10.setPreferredSize(new Dimension(130, 70));
		panel_7.add(panel_10);
		
		chordName.setFont(new Font("Segoe Script", Font.PLAIN, 42));
		panel_10.add(chordName);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_7.add(horizontalStrut_1);
		
		Chord c = new Chord(0,"G7","Gmaj7",new int[]{3,6,4,3,5,3});
		
		drawing.setBackground(Color.WHITE);
		drawing.setPreferredSize(new Dimension(540, 95));
		FlowLayout flowLayout_8 = (FlowLayout) drawing.getLayout();
		flowLayout_8.setVgap(0);
		flowLayout_8.setHgap(0);
		panel_7.add(drawing);
		
		drawing.newChord(chords[0]);
		setPrintData(chords[0]);
	}
	
	public void setChord( Chord[] c )
	{
		this.chords = c;
		drawing.newChord(c[0]);
	}
	
	public Chord spinnerChanged()
	{
		int[] f = new int[]{	(int) spinner.getValue(),
								(int) spinner_1.getValue(),
								(int) spinner_2.getValue(),
								(int) spinner_3.getValue(),
								(int) spinner_4.getValue(),
								(int) spinner_5.getValue()
							}; 
		Chord c = new Chord(0, "", "", f);
		drawing2.newChord(c);
		return c;
	}
	
	public String getMusicString( int x, int y )
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
	
	public void setPrintData( Chord selected )
	{		
		label_finger_e1.setText(getMusicString(0, selected.e1));
		label_finger_b2.setText(getMusicString(1, selected.b2));
		label_finger_g3.setText(getMusicString(2, selected.g3));
		label_finger_d4.setText(getMusicString(3, selected.d4));
		label_finger_a5.setText(getMusicString(4, selected.a5));
		label_finger_e6.setText(getMusicString(5, selected.e6));
	}
	
	public void play( final String s )
	{
		Thread p = new Thread() 
		{
		    public void run() 
		    {
		        Player p = new Player();
				p.play("I["+selectedInstument+"] "+s+"w");
		    }  
		};
		p.start();
	}
	
	public void play( final Chord selected )
	{
		Thread p = new Thread() 
		{
		    public void run() 
		    {
		    	String s = "I["+selectedInstument+"] ";
		    	
		    	s += selected.e6 >= 0 ? getMusicString(5, selected.e6)+"w+" : "";
		    	s += selected.a5 >= 0 ? getMusicString(4, selected.a5)+"w+" : "";
		    	s += selected.d4 >= 0 ? getMusicString(3, selected.d4)+"w+" : "";
		    	s += selected.g3 >= 0 ? getMusicString(2, selected.g3)+"w+" : "";
		    	s += selected.b2 >= 0 ? getMusicString(1, selected.b2)+"w+" : "";
		    	s += selected.e1 >= 0 ? getMusicString(0, selected.e1)+"w" : "";
		    	
		        Player p = new Player();
				p.play(s);
		    }  
		};
		p.start();
	}
}
