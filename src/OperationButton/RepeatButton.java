package OperationButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import GUIPackage.DefaultSize;
import GUIPackage.GUI;
import Operation.Operation;
import Operation.Repeat;

public class RepeatButton extends OperationButton {

	JComboBox comboBox;
	JLabel label;

	public RepeatButton(String name) {
		// TODO Auto-generated constructor stub
		super("");
		
		comboBox = setComboBox();
		
//		
//		comboBox.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//
////				GUI.mainFrame.getOperationPanel().getRepeatPanel().updateUI();
//				
//			}
//		});
		
		try {
			Image img = ImageIO.read(new File("resources/repeat_2.png"));
			setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		setRepeatButton(comboBox);
	}

	@Override
	public Operation GenerateNewOperateInstance() {
		// TODO Auto-generated method stub
		return new Repeat(comboBox.getSelectedIndex() + 1 , label.getText());
	}

	// 반복횟수 결정용 콤보 박스
	private JComboBox setComboBox() {

		String[] str = { "1", "2", "3", "4", "5", "6", "7" };
		JComboBox<String> jComboBox = new JComboBox<>(str);
		jComboBox.setMaximumSize(new Dimension(50, 50));

		return jComboBox;

	}
	
	private void setRepeatButton(JComboBox comboBox){
		
		
		setPreferredSize(new Dimension(DefaultSize.buttonWidth, DefaultSize.buttonHeight));
		setLayout(new FlowLayout());
		
		label = new JLabel();

		setLayout(new BorderLayout());		
		add(comboBox, BorderLayout.WEST);
		
		
		
		
	}
	
	public int getSelectedIndex(){
		return comboBox.getSelectedIndex();
	}
}
