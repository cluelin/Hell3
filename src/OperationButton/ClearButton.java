package OperationButton;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import GUIPackage.GUI;
import Operation.Operation;


public class ClearButton extends JButton implements ActionListener {
	
	

	public ClearButton(int width, int height) {
		// 생성햇던 코드 백지화 하는ㄱㅣ능.
		super();
		
		try {
			Image img = ImageIO.read(new File("resources/delete.png"));
			setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
//		setHorizontalAlignment();
		
		setPreferredSize(new Dimension(width, height));
		addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		GUI.mainFrame.clearCodePanel();
		GUI.mainFrame.resetList();
		
		for(Operation o : GUI.mainFrame.getMainList()){
			System.out.println(o);
		}
		
		
	}

}
