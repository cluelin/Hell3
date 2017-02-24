package OperationSubStream;

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

import GUIPackage.DefaultSize;
import GUIPackage.GUI;
import Operation.Backward;
import Operation.Forward;
import Operation.LeftRotate;
import Operation.RightRotate;

import OperationButton.OperationButton;


public class MoveButtonPanel extends JPanel implements ActionListener{

//	private OperationButton forwardButton = new ForwardButton("Forward");
//	private OperationButton backwardButton = new BackwardButton("Backward");
//	private OperationButton rightRotateButton = new RightRotateButton("Right Rotate");
//	private OperationButton leftRotateButton = new LeftRotateButton("Left Rotate");
	
	private JButton forwardButton = new JButton();
	private JButton backwardButton = new JButton();
	private JButton rightRotateButton = new JButton();
	private JButton leftRotateButton = new JButton();
	
	public MoveButtonPanel(int width, int height) {

		setLayout(new FlowLayout());
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(width, height));

		makeMoveButton();	
	}

	public void makeMoveButton() {
		
		
		
		try {
			Image img = ImageIO.read(new File("resources/moveForward.png"));
			forwardButton.setIcon(new ImageIcon(img));
			
			img = ImageIO.read(new File("resources/rotateRight.png"));
			
			rightRotateButton.setIcon(new ImageIcon(img));
			
			img = ImageIO.read(new File("resources/moveBackward.png"));
			backwardButton.setIcon(new ImageIcon(img));
			
			img = ImageIO.read(new File("resources/rotateLeft.png"));
			leftRotateButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		

		forwardButton.setPreferredSize(new Dimension(DefaultSize.buttonWidth, DefaultSize.buttonHeight));
		backwardButton.setPreferredSize(new Dimension(DefaultSize.buttonWidth, DefaultSize.buttonHeight));
		rightRotateButton.setPreferredSize(new Dimension(DefaultSize.buttonWidth, DefaultSize.buttonHeight));
		leftRotateButton.setPreferredSize(new Dimension(DefaultSize.buttonWidth, DefaultSize.buttonHeight));

		forwardButton.addActionListener(this);
		backwardButton.addActionListener(this);
		rightRotateButton.addActionListener(this);
		leftRotateButton.addActionListener(this);

		add(forwardButton);
		add(backwardButton);
		add(rightRotateButton);
		add(leftRotateButton);

	}

	// Move버튼 눌럿을때의 버튼 클릭 리스너.
	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource() == forwardButton){
			GUI.mainFrame.addOperationButtonInCodePanel(new Forward());
		}else if(e.getSource() == backwardButton){
			GUI.mainFrame.addOperationButtonInCodePanel(new Backward());
		}else if(e.getSource() == rightRotateButton){
			GUI.mainFrame.addOperationButtonInCodePanel(new RightRotate());
		}else if(e.getSource() == leftRotateButton){
			GUI.mainFrame.addOperationButtonInCodePanel(new LeftRotate());
		}

		//눌러진 버튼의 이미지를 변환? 
//		OperationButton res = (OperationButton)e.getSource();
//		try {
//			
//			Image selectedImage = ImageIO.read(new File("resources/Right_s.png"));
//			res.setIcon(new ImageIcon(selectedImage));
//			
//		} catch (IOException ex) {
//		}
		
		//operation버튼이 클릭될때,   각 버튼 값을 code 패널에 추가. 
//		GUI.mainFrame.addOperationButtonInCodePanel(res.GenerateNewOperateInstance());
		
		

	}

}
