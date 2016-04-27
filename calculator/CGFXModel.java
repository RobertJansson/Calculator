package calculator;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CGFXModel
{
	private static final boolean LOG = false;

	private static final String PATH = "resources/";
	private static final String ICONS = PATH + "buttons/normal/frame-0000";
	private static final int NUMBER_OF_ICONS = 52;

	private JButton[] button;
	private Icon[] icon;
	private int bWidth;
	private int bHeight;
	private ImageIcon normalBG;
	private ImageIcon advancedBG;

	public CGFXModel() {
		icon = new Icon[NUMBER_OF_ICONS];
		button = new JButton[NUMBER_OF_ICONS];
		importGraphics();
		this.bWidth  = icon[0].getIconWidth();
		this.bHeight = icon[0].getIconHeight();
		setupButtons();
	}
	
	public int bWidth()				{ return this.bWidth;		}
	public int bHeight()			{ return this.bHeight;		}
	public ImageIcon normalBG()		{ return this.normalBG; 	}
	public ImageIcon advancedBG()	{ return this.advancedBG; 	}

	public JButton buttonAt(int index){
		if (index > NUMBER_OF_ICONS-1)
			throw new RuntimeException("\nButton " + index + ": we only have button[i] 0-" + (NUMBER_OF_ICONS));
		return this.button[index];
	}

	public Icon iconAt(int index){
		if (index > NUMBER_OF_ICONS-1)
			throw new RuntimeException("\nIcon " + index + ": we only have icon[i] 0-" + (NUMBER_OF_ICONS));
		return this.icon[index];
	}

	private void importGraphics(){
		File file;
		try {
			file = new File(PATH + "BG_normal.png");			log(PATH+"BG_normal.png");
			normalBG = new ImageIcon(ImageIO.read(file));
			file = new File(PATH + "BG_advanced.png");			log(PATH+"BG_advanced.png");
			advancedBG = new ImageIcon(ImageIO.read(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < NUMBER_OF_ICONS; i++){
			if (i < 10){
				file = new File(ICONS + "0" + i + ".png");		log(ICONS+"0"+i+".png");
			} else {
				file = new File(ICONS + i + ".png");			log(ICONS+i+".png");
			}
			try {
				icon[i] = new ImageIcon(ImageIO.read(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void setupButtons(){
		for(int i=0; i < NUMBER_OF_ICONS; i++){
			button[i] = new JButton(icon[i]);
			button[i].setSize(new Dimension(bWidth, bHeight));
			button[i].setBorder(BorderFactory.createEmptyBorder());
//			button[i].addActionListener(this);
//			buttonPanel.add(button[i]);
		}
	}

	private static void log(String s){
		if (LOG) System.out.println(s);
	}

	public static void main(String[] args) {
		CGFXModel gfx = new CGFXModel();
		System.out.println();
		System.out.println(gfx.iconAt(0));
		System.out.println(gfx.iconAt(50));
		System.out.println();
		System.out.println(gfx.normalBG);
		System.out.println();
		System.out.println(gfx.advancedBG);
		System.out.println();
		System.out.println(Icn.XROOTY + " has id " + Icn.XROOTY.id());
		System.out.println();
		System.out.println("Button[9]:" + gfx.buttonAt(Icn.D0.id()));
		System.out.println();
		System.out.println("Width/height: " + gfx.bWidth() + "/" + gfx.bHeight());
	}
}