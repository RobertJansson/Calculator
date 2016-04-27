package calculator;

import java.awt.Color;
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
import javax.swing.Box;
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

	private JLayeredPane layeredPane;

	private JLabel background;		// -> layeredPane:0

	private JPanel foreground;	// -> layeredPane
	private JPanel displayPanel;	// -> foreground -> layeredPane
	private JPanel buttonPanel;		// -> foreground -> layeredPane

	// -> displayPanel -> foreground -> layeredPane
	private JLabel display;

	// -> buttonPanel -> foreground -> layeredPane
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
	public CViewer(ImageIcon imageBG) {

		super("Calculator"); 									// Set title by calling JFrame constructor
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Quit if window is closed
		this.getContentPane().setPreferredSize(new Dimension(321, 362)); // Request window size: 321x362
		this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(321, 362));
		layeredPane.setBackground(new Color(0,0,0,0));;
		
		background=new JLabel();
		background.setSize(321,362);
		background.setIcon(imageBG);
		background.setVisible(true);

		foreground = new JPanel();
		foreground.setLayout(new GridLayout(2, 0));
		foreground.setSize(new Dimension(321, 362));
		foreground.setBackground(new Color(0,0,0,0));;

		// displayPanel:
		displayPanel = new JPanel();
		displayPanel.setLayout(new GridLayout(1, 0));
		displayPanel.setSize(new Dimension(310, 60));
		displayPanel.setBackground(new Color(0,0,0,0));;
		displayPanel.setToolTipText("This is the display");
//		displayPanel.setBorder(BorderFactory.createTitledBorder(" "));

		display = new JLabel("0");
		display.setFont(new Font("Gil Sans",0,30));
		display.setHorizontalAlignment(JLabel.RIGHT);
		displayPanel.add(display);
		foreground.add(displayPanel);
		
		// buttonPanel:
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 0));
		buttonPanel.setSize(new Dimension(321, 302));
		buttonPanel.setBackground(new Color(0,0,0,0));;
//		buttonPanel.setAlignmentX(JPanel.BOTTOM_ALIGNMENT);

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

		bClear.setSize(new Dimension(75, 55));
		bPlusMinus.setSize(new Dimension(75, 55));
		bPercent.setSize(new Dimension(75, 55));
		bComma.setSize(new Dimension(75, 55));
		b0.setSize(new Dimension(150, 55));
		b1.setSize(new Dimension(75, 55));
		b2.setSize(new Dimension(75, 55));
		b3.setSize(new Dimension(75, 55));
		b4.setSize(new Dimension(75, 55));
		b5.setSize(new Dimension(75, 55));
		b6.setSize(new Dimension(75, 55));
		b7.setSize(new Dimension(75, 55));
		b8.setSize(new Dimension(75, 55));
		b9.setSize(new Dimension(75, 55));
		bEqual.setSize(new Dimension(75, 55));
		bPlus.setSize(new Dimension(75, 55));
		bMinus.setSize(new Dimension(75, 55));
		bMultiplication.setSize(new Dimension(75, 55));
		bDivision.setSize(new Dimension(75, 55));
		
		bClear.setBorder(BorderFactory.createEmptyBorder());
		bPlusMinus.setBorder(BorderFactory.createEmptyBorder());
		bPercent.setBorder(BorderFactory.createEmptyBorder());
		bComma.setBorder(BorderFactory.createEmptyBorder());
		b0.setBorder(BorderFactory.createEmptyBorder());
		b1.setBorder(BorderFactory.createEmptyBorder());
		b2.setBorder(BorderFactory.createEmptyBorder());
		b3.setBorder(BorderFactory.createEmptyBorder());
		b4.setBorder(BorderFactory.createEmptyBorder());
		b5.setBorder(BorderFactory.createEmptyBorder());
		b6.setBorder(BorderFactory.createEmptyBorder());
		b7.setBorder(BorderFactory.createEmptyBorder());
		b8.setBorder(BorderFactory.createEmptyBorder());
		b9.setBorder(BorderFactory.createEmptyBorder());
		bEqual.setBorder(BorderFactory.createEmptyBorder());
		bPlus.setBorder(BorderFactory.createEmptyBorder());
		bMinus.setBorder(BorderFactory.createEmptyBorder());
		bMultiplication.setBorder(BorderFactory.createEmptyBorder());
		bDivision.setBorder(BorderFactory.createEmptyBorder());

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
		buttonPanel.add(bComma);
		buttonPanel.add(bEqual);
		buttonPanel.add(b0,2,16);

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

		foreground.add(buttonPanel);

		//	JLayeredPane.DEFAULT_LAYER
		//	JLayeredPane.PALETTE_LAYER

		layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);
//		layeredPane.add(foreground, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(displayPanel, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(buttonPanel, JLayeredPane.PALETTE_LAYER);
//		layeredPane.moveToFront(foreground);
		this.getContentPane().add(layeredPane);


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