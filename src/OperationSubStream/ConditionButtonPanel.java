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

import GUIPackage.GUI;
import OperationButton.ConditionButton;
import OperationButton.OperationButton;

public class ConditionButtonPanel extends JPanel implements ActionListener{

	public ConditionButtonPanel(int width, int height){
		setLayout(new FlowLayout());
//		setBackground(new Color(0, 0, 20, 50));
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(width, height));

		makeMoveButton();
	}
	
	private void makeMoveButton(){
		OperationButton condition1 = new ConditionButton();
		
		
		
		try {
			Image img = ImageIO.read(new File("resources/isWall.png"));
			condition1.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		
		condition1.setPreferredSize(new Dimension(150, 50));
		

		condition1.addActionListener(this);
		
		add(condition1);
		
		
	}
	
	// condition버튼 눌럿을때의 버튼 클릭 리스너.
	@Override
	public void actionPerformed(ActionEvent e) {

		// operation버튼이 클릭될때, 각 버튼 값을 code 패널에 추가.
		OperationButton res = (OperationButton) e.getSource();
		try {

			Image selectedImage = ImageIO.read(new File("resources/isWall.png"));
			res.setIcon(new ImageIcon(selectedImage));

		} catch (IOException ex) {
		}
		GUI.mainFrame.addOperationButtonInCodePanel(res.GenerateNewOperateInstance());

	}
	
}
