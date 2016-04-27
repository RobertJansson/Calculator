package calculator;

import javax.swing.JButton;

public class CController {

	private static final boolean LOG = false;
	private static CGFXModel gfxModel;
	@SuppressWarnings("unused")
	private CViewer viewer;
//	private CBrain brain;

	
	public CController(){
		gfxModel = new CGFXModel();
		viewer = new CViewer(gfxModel.normalBG());
	}
	
//	//	CController.getIcon(Icn.SIN) -> CGFXModel.iconAt(Icn.SIN.id())
//	public static Icon getIcon(Icn icn){
//		return gfxModel.iconAt(icn.id());
//	}
	
	//	CController.getButton(Icn.SIN) -> CGFXModel.buttonAt(Icn.SIN.id())
	public static JButton getButton(Icn icn){
		return gfxModel.buttonAt(icn.id());
	}

	public static int bWidth()		{ return gfxModel.bWidth();		}
	public static int bHeight()		{ return gfxModel.bHeight();	}

	
	private void setupNormal(){
//		viewer.setBG(gfxModel.normalBG());
	}
	
	@SuppressWarnings("unused")
	private static void log(String s){
		if (LOG) System.out.println(s);
	}

	public static void main(String[] args) {
		CController controller = new CController();
		controller.setupNormal();

	}
}
