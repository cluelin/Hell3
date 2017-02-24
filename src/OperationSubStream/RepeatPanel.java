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
	
	
	//반복 작업 버튼 액션리스너
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		Repeat repeatInstance = (Repeat)repeatButton.GenerateNewOperateInstance();
		
		//코드패널에 버튼 추가
		GUI.mainFrame.addOperationButtonInCodePanel(repeatInstance);
		
		//for오퍼레이션  중첩
		GUI.mainFrame.addNumOfFor();
		//타겟 리스트 교체
		GUI.mainFrame.setTargetList(repeatInstance.getOpertionList());
		
		
		//그냥 무브 패널 보여주는건데 빼도될듯.
		GUI.mainFrame.getOperationPanel().showMovePanel();
		
		
	}

}
