package OperationSubStream;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import GUIPackage.GUI;
import Operation.Repeat;
import OperationButton.OperationButton;
import OperationButton.RepeatButton;

public class RepeatPanel extends JPanel implements ActionListener{

//	JComboBox comboBox;
	OperationButton repeatButton;
	
	public RepeatPanel(int width, int height) {
		setLayout(new FlowLayout());
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(width, height));
		

		repeatButton = new RepeatButton("");
		repeatButton.setBackground(new Color(255,255,255,0));
		repeatButton.addActionListener(this);

		add(repeatButton);
	}
	
	
	//�ݺ� �۾� ��ư �׼Ǹ�����
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		Repeat repeatInstance = (Repeat)repeatButton.GenerateNewOperateInstance();
		
		//�ڵ��гο� ��ư �߰�
		GUI.mainFrame.addOperationButtonInCodePanel(repeatInstance);
		
		//for���۷��̼�  ��ø
		GUI.mainFrame.addNumOfFor();
		//Ÿ�� ����Ʈ ��ü
		GUI.mainFrame.setTargetList(repeatInstance.getOpertionList());
		
		
		//�׳� ���� �г� �����ִ°ǵ� �����ɵ�.
		GUI.mainFrame.getOperationPanel().showMovePanel();
		
		
	}

}
