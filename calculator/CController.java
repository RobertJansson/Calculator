package calculator;

import javax.swing.JButton;

public class CController
{
	private static final boolean LOG = false;
	private static CGFXModel gfxModel;
	@SuppressWarnings("unused")
	private CViewer viewer;

	
	// Constructor:
	public CController(){
		gfxModel = new CGFXModel();
		viewer = new CViewer(gfxModel.normalBG());
	}

	// Fetching methods:
	public static int bWidth()  {return gfxModel.bWidth(); }
	public static int bHeight() {return gfxModel.bHeight();}
	public static JButton getButton(Icn icn){
		return gfxModel.buttonAt(icn.id());
		// Viewer:		CController.getButton(Icn.SIN)
		// Controller:	CGFXModel.buttonAt(Icn.SIN.id())
	}

	
	@SuppressWarnings("unused")
	private static void log(String s){ if (LOG) System.out.println(s); }

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		CController controller = new CController();
	}
}