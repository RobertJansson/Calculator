package calculator;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class CGFXModel
{
	private static final boolean LOG = false;

	private static final String PATH = "resources/";
	private static final String ICONS = PATH + "buttons/normal/frame-0000";
	private static final int NUMBER_OF_ICONS = 52;

	private Icon[] icon;
	private File file;
	private BufferedImage normalBG;
	private BufferedImage advancedBG;

	public CGFXModel() {
		icon = new Icon[NUMBER_OF_ICONS];
		importGraphics();
	}

	/**
	 * Ritar ut bilden i bildobjektet 'picture'.
	 */
//	public void paintComponent(Graphics g) {
//		BufferedImage picture;
//		super.paintComponent(g);
//		Graphics2D g2 = (Graphics2D) g;
//		if (picture != null) {
//			g2.drawImage(picture, null, 0, 0);
//		}
//	}
	
	public Icon iconAt(int index){
		if (index > NUMBER_OF_ICONS-1)
			throw new RuntimeException("\nIcon " + index + ": we only have " + (NUMBER_OF_ICONS-1) + " icons");
		return this.icon[index];
	}

	public BufferedImage normalBG(){
		return this.normalBG;
	}
	public BufferedImage advancedBG(){
		return this.advancedBG;
	}

	private void importGraphics(){
		log("importGraphics()");
		for (int i = 0; i < NUMBER_OF_ICONS; i++){

			if (i < 10){
				file = new File(ICONS + "0" + i + ".png");	log(ICONS + "0" + i + ".png");
			} else {
				file = new File(ICONS + i + ".png");		log(ICONS + i + ".png");
			}

			try {
				icon[i] = new ImageIcon(ImageIO.read(file));

				//			ViewerPanel panel = new ViewerPanel (img);
				//			ViewerWindow win = new ViewerWindow ("Image Viewer", panel);
				//			win.setVisible (true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			file = new File(PATH + "BG_normal.png");	log(PATH + "BG_normal.png");
			normalBG = ImageIO.read(file);

			file = new File(PATH + "BG_advanced.png");	log(PATH + "BG_advanced.png");
			advancedBG = ImageIO.read(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void log(String s){
		if (LOG) System.out.println(s);
	}

	public static void main(String[] args) {
		CGFXModel gfx = new CGFXModel();
		System.out.println();
		System.out.println(gfx.iconAt(0));
		System.out.println(gfx.iconAt(1));
		System.out.println(gfx.iconAt(50));
		System.out.println();
		System.out.println(gfx.normalBG);
		System.out.println();
		System.out.println(gfx.advancedBG);
		System.out.println();
		System.out.println(Icn.XROOTY + " has id " + Icn.XROOTY.id());

	}
}