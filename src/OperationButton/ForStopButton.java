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

public class ForStopButton extends JButton{

	public ForStopButton(int width, int height){
		
		super();
		setPreferredSize(new Dimension(width, height));
		
		
		try {
			Image img = ImageIO.read(new File("resources/loopBreak.png"));
			setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//반복 구문을 종료한다. 
				if(GUI.mainFrame.countOfFor != 0){
					GUI.mainFrame.subNumOfFor();
					
				}
				
			}
		});
		
	}
	
}
