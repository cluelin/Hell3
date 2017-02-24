package OperationOverPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUIPackage.DefaultSize;
import OperationButton.ClearButton;
import OperationButton.ForStopButton;
import OperationButton.StartButton;
import OperationButton.ToggleButton;

public class OverPanel extends JPanel{
	
	StartButton startButton;
	
	public OverPanel(){
		
		setLayout(new FlowLayout());
//		setBackground(new Color(0, 0, 20, 50));
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(DefaultSize.operationPanelWidth/3 -20, DefaultSize.operationPanelHeight));
		
		startButton = new StartButton(DefaultSize.buttonWidth, DefaultSize.buttonHeight);
		add(startButton);

		// 생성햇던 코드 백지화 하는ㄱㅣ능.
		ClearButton clearButton = new ClearButton(DefaultSize.buttonWidth, DefaultSize.buttonHeight);
		add(clearButton);
		
		ForStopButton forStopButton = new ForStopButton(DefaultSize.buttonWidth, DefaultSize.buttonHeight);
		add(forStopButton);
		
		ToggleButton convertToText = new ToggleButton(DefaultSize.buttonWidth, DefaultSize.buttonHeight);
		add(convertToText);
	}
	
	public StartButton getStartButton(){
		
		return startButton;
	}
	
	

}
