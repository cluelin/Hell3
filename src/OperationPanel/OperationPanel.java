package OperationPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUIPackage.DefaultSize;
import OperationMainStream.OperationButtonPanel;
import OperationOverPanel.OverPanel;
import OperationSubStream.ConditionButtonPanel;

import OperationSubStream.MoveButtonPanel;
import OperationSubStream.RepeatPanel;

public class OperationPanel extends JPanel {

	// 메인 스트림 오퍼레이션
	private OperationButtonPanel MainStreamOperationPanel;

	// sub스트림 오퍼레이션
	private MoveButtonPanel moveButtonPanel;
	private RepeatPanel repeatPanel;
	private ConditionButtonPanel conditionButtonPanel;

	// OverPanel
	private OverPanel overPanel;
	

	public OperationPanel() {
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(DefaultSize.subPanelWidth, DefaultSize.mainFrameHeight / 4 + 10));
		setBackground(Color.white);
		
		setOperationPanel();
	}
	
	private void setOperationPanel(){
		
		addMainStreamPanel();
		addSubStreamPanel();
		addOverPanel();
	}
	
	private void addMainStreamPanel(){
		
		MainStreamOperationPanel = new OperationButtonPanel(DefaultSize.subPanelWidth / 3,
				DefaultSize.operationPanelHeight);
		
		add(MainStreamOperationPanel);
		
	}

	// operationPanel 위에 올라가야 할 패널들
	private void addSubStreamPanel() {
		
		moveButtonPanel = new MoveButtonPanel(DefaultSize.subPanelWidth / 3, DefaultSize.operationPanelHeight);
		repeatPanel = new RepeatPanel(DefaultSize.operationPanelWidth / 3, DefaultSize.operationPanelHeight);
		conditionButtonPanel = new ConditionButtonPanel(DefaultSize.subPanelWidth / 3,
				DefaultSize.operationPanelHeight);


		// 세개는 중첩되어잇음.
		add(moveButtonPanel);
		add(conditionButtonPanel);
		add(repeatPanel);

		// 중첩되어있기때문에 visible설정해줘야함.
		showMovePanel();

	}

	// OverPanel 추가
	private void addOverPanel() {

		overPanel = new OverPanel();

		add(overPanel);

	}

	// MovePanel 활성화
	public void showMovePanel() {


		getMoveButtonPanel().setVisible(true);
		getConditionButtonPanel().setVisible(false);
		getRepeatPanel().setVisible(false);

		validate();
		repaint();

	}

	// RepeatPanel 활성화
	public void showRepeatPanel() {


		getMoveButtonPanel().setVisible(false);
		getConditionButtonPanel().setVisible(false);
		getRepeatPanel().setVisible(true);

		validate();
		repaint();

	}

	// ConditionPanel 활성화
	public void showConditionPanel() {
		
		getMoveButtonPanel().setVisible(false);
		getConditionButtonPanel().setVisible(true);
		getRepeatPanel().setVisible(false);

		validate();
		repaint();
	}
	

	public MoveButtonPanel getMoveButtonPanel() {
		return moveButtonPanel;
	}

	public RepeatPanel getRepeatPanel() {
		return repeatPanel;
	}

	public ConditionButtonPanel getConditionButtonPanel() {
		return conditionButtonPanel;
	}
	
	public JButton getStartButton(){
		return overPanel.getStartButton();
	}
}
