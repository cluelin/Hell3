package OperationMainStream;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUIPackage.DefaultSize;
import GUIPackage.GUI;


public class OperationButtonPanel extends JPanel implements ActionListener{

	private JButton moveButton;
	private JButton repeatButton;
	private JButton conditionButton;
	
	public OperationButtonPanel(int width, int height) {
		

		//패널 기본 설정. 
		setLayout(new FlowLayout());
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(width, height));
		
		makeOperationButton();


	}
	
	private void makeOperationButton() {

		moveButton = new JButton();
		repeatButton = new JButton();
		conditionButton = new JButton();
		
		try {
			Image img1 = ImageIO.read(new File("resources/move.png"));
			Image img2 = ImageIO.read(new File("resources/repeat.png"));
			Image img3 = ImageIO.read(new File("resources/condition.png"));
			
			
			moveButton.setIcon(new ImageIcon(img1));
			repeatButton.setIcon(new ImageIcon(img2));
			conditionButton.setIcon(new ImageIcon(img3));
		} catch (IOException ex) {
		}
		

		
		moveButton.setPreferredSize(new Dimension(DefaultSize.buttonWidth, DefaultSize.buttonHeight));
		repeatButton.setPreferredSize(new Dimension(DefaultSize.buttonWidth, DefaultSize.buttonHeight));
		conditionButton.setPreferredSize(new Dimension(DefaultSize.buttonWidth, DefaultSize.buttonHeight));

		moveButton.addActionListener(this);
		repeatButton.addActionListener(this);
		conditionButton.addActionListener(this);
		

		add(moveButton);
		add(repeatButton);
		add(conditionButton);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		
		
		if(e.getSource() == moveButton){
			
			GUI.mainFrame.getOperationPanel().showMovePanel();

		}else if(e.getSource() == repeatButton){
		
			GUI.mainFrame.getOperationPanel().showRepeatPanel();
			
		}else if(e.getSource() == conditionButton){
			GUI.mainFrame.getOperationPanel().showConditionPanel();
		}
		

	}

	

}
