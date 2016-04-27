package calculator;

import javax.swing.Icon;

public class CController {

	private static final boolean LOG = false;
	private static CGFXModel gfxModel;
	private CViewer viewer;
//	private CBrain brain;

	
	public CController(){
		gfxModel = new CGFXModel();
		viewer = new CViewer(gfxModel.normalBG());
	}
	
	//	Grep example: CGFXModel.iconAt(Icn.SIN.id())
	public static Icon getIcon(Icn icn){
		return gfxModel.iconAt(icn.id());
	}

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
