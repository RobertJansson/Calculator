package calculator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class CViewer extends JFrame implements ActionListener
{

	private static final boolean LOG = false;
	private static final long serialVersionUID = 1L;
	private BufferedImage imageBG;

	private JLayeredPane layeredPane;

	private JPanel background;		// -> layeredPane
//	private JImage image;			// -> backDrop -> layeredPane

	private JPanel controlPanel;	// -> layeredPane
	private JPanel displayPanel;	// -> controlPanel -> layeredPane
	private JPanel buttonPanel;		// -> controlPanel -> layeredPane

	// -> displayPanel -> controlPanel -> layeredPane
	private JLabel display;

	// -> buttonPanel -> controlPanel -> layeredPane
	private JButton bClear, bPlusMinus, bPercent, bComma;
	private JButton bEqual, bPlus, bMinus, bMultiplication, bDivision;
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;

	
//    public void paint(Graphics g) {
//        g.drawImage(imageBG, 0, 0, null);
//    }
	
	/**
	 * Constructor for the CViewer<p>
	 * Require: CController
	 * @param n is the number of measures
	 */
	public CViewer(BufferedImage imageBG) {

		super("Calculator"); 									// Set title by calling JFrame constructor
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Quit if window is closed
		this.getContentPane().setPreferredSize(new Dimension(321, 362)); // Request window size: 321x362
		// Create a CalculatorBrain
//		pb = new U5_ProjectileBrain(n);

		this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
//		layeredPane = new JLayeredPane();
		
		background = new JPanel();
        ImageIcon icon=new ImageIcon(imageBG);
//        JFrame frame=new JFrame();
        background.setLayout(new FlowLayout());
//        frame.setSize(200,300);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        background.add(lbl);
        background.setVisible(true);

//		backDrop.add(imageBG);
//		backDrop.setPreferredSize(new Dimension(321, 362));

		controlPanel = new JPanel();
//		controlPanel.setLayout(new GridLayout(2, 0));
		controlPanel.setPreferredSize(new Dimension(321, 362));

		// Set up the display panel
		displayPanel = new JPanel();
		displayPanel.setLayout(new GridLayout(1, 0));
		displayPanel.setPreferredSize(new Dimension(321, 60));
		display = new JLabel("0");
		display.setFont(new Font("Gil Sans",0,30));
		display.setHorizontalAlignment(JLabel.RIGHT);
		displayPanel.add(display);
		displayPanel.setToolTipText("This is the display");
		displayPanel.setBorder(BorderFactory.createTitledBorder("Display"));
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 0));
		buttonPanel.setPreferredSize(new Dimension(321, 302));

		bClear = new JButton(CController.getIcon(Icn.CLEAR));
		bPlusMinus = new JButton(CController.getIcon(Icn.PLUSMINUS));
		bPercent = new JButton(CController.getIcon(Icn.PERCENT));
		bComma = new JButton(CController.getIcon(Icn.COMMA));
		b0 = new JButton(CController.getIcon(Icn.D0));
		b1 = new JButton(CController.getIcon(Icn.D1));
		b2 = new JButton(CController.getIcon(Icn.D2));
		b3 = new JButton(CController.getIcon(Icn.D3));
		b4 = new JButton(CController.getIcon(Icn.D4));
		b5 = new JButton(CController.getIcon(Icn.D5));
		b6 = new JButton(CController.getIcon(Icn.D6));
		b7 = new JButton(CController.getIcon(Icn.D7));
		b8 = new JButton(CController.getIcon(Icn.D8));
		b9 = new JButton(CController.getIcon(Icn.D9));
		bEqual = new JButton(CController.getIcon(Icn.EQUAL));
		bPlus = new JButton(CController.getIcon(Icn.PLUS));
		bMinus = new JButton(CController.getIcon(Icn.MINUS));
		bMultiplication = new JButton(CController.getIcon(Icn.MULTIPLICATION));
		bDivision = new JButton(CController.getIcon(Icn.DIVISION));

		bClear.setPreferredSize(new Dimension(75, 55));
		bPlusMinus.setPreferredSize(new Dimension(75, 55));
		bPercent.setPreferredSize(new Dimension(75, 55));
		bComma.setPreferredSize(new Dimension(75, 55));
		b0.setSize(new Dimension(150, 55));
		b1.setPreferredSize(new Dimension(75, 55));
		b2.setPreferredSize(new Dimension(75, 55));
		b3.setPreferredSize(new Dimension(75, 55));
		b4.setPreferredSize(new Dimension(75, 55));
		b5.setPreferredSize(new Dimension(75, 55));
		b6.setPreferredSize(new Dimension(75, 55));
		b7.setPreferredSize(new Dimension(75, 55));
		b8.setPreferredSize(new Dimension(75, 55));
		b9.setPreferredSize(new Dimension(75, 55));
		bEqual.setPreferredSize(new Dimension(75, 55));
		bPlus.setPreferredSize(new Dimension(75, 55));
		bMinus.setPreferredSize(new Dimension(75, 55));
		bMultiplication.setPreferredSize(new Dimension(75, 55));
		bDivision.setPreferredSize(new Dimension(75, 55));
		
//		b5.setBorder(BorderFactory.createEmptyBorder());

		// Button panel
		buttonPanel.add(bClear);
		buttonPanel.add(bPlusMinus);
		buttonPanel.add(bPercent);
		buttonPanel.add(bDivision);
		buttonPanel.add(b7);
		buttonPanel.add(b8);
		buttonPanel.add(b9);
		buttonPanel.add(bMultiplication);
		buttonPanel.add(b4);
		buttonPanel.add(b5);
		buttonPanel.add(b6);
		buttonPanel.add(bMinus);
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		buttonPanel.add(bPlus);
		buttonPanel.add(b0);
		buttonPanel.add(bComma);
		buttonPanel.add(bEqual);

		bClear.setToolTipText("Clear");
		bPlusMinus.setToolTipText("Plus/minus");
		bPercent.setToolTipText("Percent");
		bDivision.setToolTipText("Division");
		b7.setToolTipText("Seven");
		b8.setToolTipText("Eight");
		b9.setToolTipText("Nine");
		bMultiplication.setToolTipText("Multiplication");
		b4.setToolTipText("Four");
		b5.setToolTipText("Five");
		b6.setToolTipText("Six");
		bPlus.setToolTipText("Addition");
		b1.setToolTipText("One");
		b2.setToolTipText("Two");
		b3.setToolTipText("Three");
		bPlus.setToolTipText("Subtraction");
		b0.setToolTipText("Zero");
		bPlus.setToolTipText("Comma");
		bPlus.setToolTipText("Equal");

		// Add panels to content pane
		controlPanel.add(displayPanel);
//		controlPanel.add(frame);
		controlPanel.add(buttonPanel);
		controlPanel.setVisible (true);
		layeredPane.add(controlPanel);
		layeredPane.add(background);
		this.getContentPane().add(layeredPane);
//		this.getContentPane().add(controlPanel);

/*		
layeredPane = new JLayeredPane();
layeredPane.setPreferredSize(new Dimension(300, 310));
layeredPane.setBorder(BorderFactory.createTitledBorder("Move the Mouse to Move Duke"));
layeredPane.addMouseMotionListener(new MouseMotionAdapter() {
    ...
});
*/		
		// Listeners
		bClear.addActionListener(this);
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bComma.addActionListener(this);
		
		this.pack();				// Resize the window and its components to preferred size
		this.setVisible(true); 		// Display the window

		// Set start values and plot the result
		redraw();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
//			pb.setVelocity(Double.parseDouble(velocityTF.getText()));
			
		if (e.getSource() == bClear) {
			display.setText("");					log("Button C pressed");
		} else if (e.getSource() == bComma) {
			display.setText(display.getText() + '.');log("Button ',' pressed");
		} else if (e.getSource() == b0) {
			display.setText(display.getText() + 0);	log("Button 0 pressed");
		} else if (e.getSource() == b1) {
			display.setText(display.getText() + 1);	log("Button 1 pressed");
		} else if (e.getSource() == b2) {
			display.setText(display.getText() + 2);	log("Button 2 pressed");
		} else if (e.getSource() == b3) {
			display.setText(display.getText() + 3);	log("Button 3 pressed");
		} else if (e.getSource() == b4) {
			display.setText(display.getText() + 4);	log("Button 4 pressed");
		} else if (e.getSource() == b5) {
			display.setText(display.getText() + 5);	log("Button 5 pressed");
		} else if (e.getSource() == b6) {
			display.setText(display.getText() + 6);	log("Button 6 pressed");
		} else if (e.getSource() == b7) {
			display.setText(display.getText() + 7);	log("Button 7 pressed");
		} else if (e.getSource() == b8) {
			display.setText(display.getText() + 8);	log("Button 8 pressed");
		} else if (e.getSource() == b9) {
			display.setText(display.getText() + 9);	log("Button 9 pressed");
		}
		
		// Update the text fields and plot the reciept
		redraw();

	}

	private static void log(String s){
		if (LOG) System.out.println(s);
	}
	
	/**
	 * Sub routine to set the values in the text fields
	 * Called from both the constructor and actionPerformed()
	 */
	private void redraw(){
//		final String FORMAT = "%.3f";
//		angleTF.setText(String.format(Locale.US, FORMAT, pb.getAngle()));
//		gravityTF.setText(String.format(Locale.US, FORMAT, pb.getGravity()));
//		distanceTF.setText(String.format(Locale.US, FORMAT, pb.getDistance()));
//		velocityTF.setText(String.format(Locale.US, FORMAT, pb.getVelocity()));
//		
//		pb.calcArray();
//		textArea.setText(pb.print());
		repaint();
	}
	
//	public void paint(Graphics g, BufferedImage imageBG) {
//        g.drawImage(imageBG, 0, 0, null);
//    }
	
	public static void main(String[] args) {

		// This program is user driven so we just create the viewer and wait for commands
		CController controller = new CController();
		
	}
}