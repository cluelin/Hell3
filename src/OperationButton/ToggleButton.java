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

public class ToggleButton extends JButton implements ActionListener{

	boolean Flag = false;
	
	public ToggleButton(int width, int height) {

		setPreferredSize(new Dimension(width, height));
		try {
			Image img = ImageIO.read(new File("resources/comment.png"));
			setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		// 코드화
		addActionListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		// 오퍼레이션 버튼 리스트 숨기기.

		// GUI.mainFrame.toggleCodePanel();
		GUI.mainFrame.getCodeScrollPanel().toggleCodePanel();

		try {
			if (Flag) {

				Image img = ImageIO.read(new File("resources/comment.png"));
				((JButton) e.getSource()).setIcon(new ImageIcon(img));
				Flag = false;

			} else {
				Image img = ImageIO.read(new File("resources/back.png"));
				((JButton) e.getSource()).setIcon(new ImageIcon(img));
				Flag = true;

			}

		} catch (IOException ex) {
		}

	}
}
