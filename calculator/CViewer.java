package calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class CViewer extends JFrame implements ActionListener
{

	private static final boolean LOG = false;
	private static final long serialVersionUID = 1L;

	private JLayeredPane layeredPane;

	private JLabel background;		// -> layeredPane:DEFAULT_LAYER

	private JPanel foreground;		// -> layeredPane:PALETTE_LAYER
	private JLabel display;			// -> foreground -> layeredPane
	private JPanel buttonPanel;		// -> foreground -> layeredPane
	
	private static final int COL = 4;
	private static final int ROW = 5;
	private int bWidth = CController.bWidth();
	private int bHeight= CController.bHeight();
	private int w = COL * bWidth;
	private int h = ROW * bHeight + 60;

	/**
	 * Constructor for the CViewer<p>
	 * Require: CController
	 * @param n is the number of measures
	 */
	public CViewer(ImageIcon imageBG) {
		super("Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("Width/height:" + w + "/" + h);
		this.getContentPane().setPreferredSize(new Dimension(w, h)); // Request window size
		this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
//		this.add(Box.createRigidArea(new Dimension(0, 10)));
		
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(w, h));
		layeredPane.setOpaque(true);
//		layeredPane.setLayout(new FlowLayout());
//		layeredPane.setBackground(new Color(0,0,0,0));;

		background=new JLabel();
		background.setSize(w, h);
		background.setIcon(imageBG);
		background.setVisible(true);

		foreground = new JPanel();
//		foreground.setLayout(new GridLayout(0, 1));
//		foreground.setLayout(new GridBagLayout());
		foreground.setSize(new Dimension(w, h));
		foreground.setOpaque(true);
//		foreground.setBackground(new Color(0,0,0,0));
//		foreground.setAlignmentY(JPanel.TOP_ALIGNMENT);

/*
		// displayPanel:
		displayPanel = new JPanel();
		displayPanel.setLayout(new GridLayout(1, 0));
		displayPanel.setSize(new Dimension(310, 60));
		displayPanel.setBackground(new Color(0,0,0,0));;
		displayPanel.setToolTipText("This is the display");
//		displayPanel.setBorder(BorderFactory.createTitledBorder(" "));
*/
		display = new JLabel("0");
		display.setFont(new Font("Gil Sans",0,30));
		display.setHorizontalAlignment(JLabel.RIGHT);
		display.setSize(new Dimension(w-20, 60));
		display.setMinimumSize(new Dimension(w-20, 60));
		display.setMaximumSize(new Dimension(w-20, 60));
		display.setPreferredSize(new Dimension(w-20, 60));
//		display.setOpaque(true);
		display.setBackground(new Color(0,0,0,0));
//		displayPanel.add(display);
		
		// buttonPanel:
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 0));
		buttonPanel.setSize(new Dimension(w, h-60));
//		buttonPanel.setOpaque(true);
		buttonPanel.setBackground(new Color(0,0,0,0));;
		// buttonPanel.setAlignmentX(JPanel.BOTTOM_ALIGNMENT);

		buttonPanel.add(CController.getButton(Icn.CLEAR));
		buttonPanel.add(CController.getButton(Icn.PLUSMINUS));
		buttonPanel.add(CController.getButton(Icn.PERCENT));
		buttonPanel.add(CController.getButton(Icn.DIVISION));
		buttonPanel.add(CController.getButton(Icn.D7));
		buttonPanel.add(CController.getButton(Icn.D8));
		buttonPanel.add(CController.getButton(Icn.D9));
		buttonPanel.add(CController.getButton(Icn.MULTIPLICATION));
		buttonPanel.add(CController.getButton(Icn.D4));
		buttonPanel.add(CController.getButton(Icn.D5));
		buttonPanel.add(CController.getButton(Icn.D6));
		buttonPanel.add(CController.getButton(Icn.MINUS));
		buttonPanel.add(CController.getButton(Icn.D1));
		buttonPanel.add(CController.getButton(Icn.D2));
		buttonPanel.add(CController.getButton(Icn.D3));
		buttonPanel.add(CController.getButton(Icn.PLUS));
		buttonPanel.add(CController.getButton(Icn.D0));
		buttonPanel.add(CController.getButton(Icn.COMMA));
		buttonPanel.add(CController.getButton(Icn.EQUAL));

		CController.getButton(Icn.CLEAR).setToolTipText("Clear");
		CController.getButton(Icn.PLUSMINUS).setToolTipText("plus/minus");
		CController.getButton(Icn.PERCENT).setToolTipText("Percent");
		CController.getButton(Icn.DIVISION).setToolTipText("Division");
		CController.getButton(Icn.D7).setToolTipText("7");
		CController.getButton(Icn.D8).setToolTipText("8");
		CController.getButton(Icn.D9).setToolTipText("9");
		CController.getButton(Icn.MULTIPLICATION).setToolTipText("Multiplication");
		CController.getButton(Icn.D4).setToolTipText("4");
		CController.getButton(Icn.D5).setToolTipText("5");
		CController.getButton(Icn.D6).setToolTipText("6");
		CController.getButton(Icn.PLUS).setToolTipText("Addition");
		CController.getButton(Icn.D1).setToolTipText("4");
		CController.getButton(Icn.D2).setToolTipText("5");
		CController.getButton(Icn.D3).setToolTipText("6");
		CController.getButton(Icn.MINUS).setToolTipText("Subtraction");
		CController.getButton(Icn.D0).setToolTipText("0");
		CController.getButton(Icn.COMMA).setToolTipText("Comma");
		CController.getButton(Icn.EQUAL).setToolTipText("Equal");

		foreground.add(display);
		foreground.add(buttonPanel);
//		foreground.setOpaque(true);
		foreground.setBackground(new Color(0,0,0,0));


//		layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(background, JLayeredPane.PALETTE_LAYER);
//		layeredPane.add(foreground, JLayeredPane.PALETTE_LAYER);
//		layeredPane.add(foreground, JLayeredPane.MODAL_LAYER);
//		layeredPane.add(foreground, JLayeredPane.POPUP_LAYER);
//		layeredPane.add(foreground, JLayeredPane.DRAG_LAYER);
		layeredPane.add(display, JLayeredPane.MODAL_LAYER);
		layeredPane.add(buttonPanel, JLayeredPane.MODAL_LAYER);
//		layeredPane.moveToFront(foreground);
//		layeredPane.setOpaque(true);
		layeredPane.setBackground(new Color(0,0,0,0));
		this.getContentPane().add(layeredPane);
		
		// Listeners
		CController.getButton(Icn.CLEAR).addActionListener(this);
		CController.getButton(Icn.D0).addActionListener(this);
		CController.getButton(Icn.D1).addActionListener(this);
		CController.getButton(Icn.D2).addActionListener(this);
		CController.getButton(Icn.D3).addActionListener(this);
		CController.getButton(Icn.D4).addActionListener(this);
		CController.getButton(Icn.D5).addActionListener(this);
		CController.getButton(Icn.D6).addActionListener(this);
		CController.getButton(Icn.D7).addActionListener(this);
		CController.getButton(Icn.D8).addActionListener(this);
		CController.getButton(Icn.D9).addActionListener(this);
		CController.getButton(Icn.COMMA).addActionListener(this);

		this.pack();
		this.setVisible(true);
		redraw();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
//			pb.setVelocity(Double.parseDouble(velocityTF.getText()));

		if (e.getSource() == CController.getButton(Icn.CLEAR))
			display.setText("");
		else if (e.getSource() == CController.getButton(Icn.COMMA))
			display.setText(display.getText() + '.');
		else if (e.getSource() == CController.getButton(Icn.PLUSMINUS))
			display.setText("-" + display.getText());
		else if (e.getSource() == CController.getButton(Icn.D0))
			display.setText(display.getText() + 0);
		else if (e.getSource() == CController.getButton(Icn.D1))
			display.setText(display.getText() + 1);
		else if (e.getSource() == CController.getButton(Icn.D2))
			display.setText(display.getText() + 2);
		else if (e.getSource() == CController.getButton(Icn.D3))
			display.setText(display.getText() + 3);
		else if (e.getSource() == CController.getButton(Icn.D4))
			display.setText(display.getText() + 4);
		else if (e.getSource() == CController.getButton(Icn.D5))
			display.setText(display.getText() + 5);
		else if (e.getSource() == CController.getButton(Icn.D6))
			display.setText(display.getText() + 6);
		else if (e.getSource() == CController.getButton(Icn.D7))
			display.setText(display.getText() + 7);
		else if (e.getSource() == CController.getButton(Icn.D8))
			display.setText(display.getText() + 8);
		else if (e.getSource() == CController.getButton(Icn.D9))
			display.setText(display.getText() + 9);
		
		// Update the text fields and plot the reciept
		redraw();
	}

	/**
	 * Sub routine whenever we redraw Viewer
	 * Called from both the constructor and actionPerformed()
	 */
	private void redraw(){
		// display.setText(CController.helpMe());
		repaint();
	}
	
	@SuppressWarnings("unused")
	private static void log(String s){
		if (LOG) System.out.println(s);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// CController initiate the program:
		CController controller = new CController();
	}
}