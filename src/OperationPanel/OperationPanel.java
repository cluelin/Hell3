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

	// ���� ��Ʈ�� ���۷��̼�
	private OperationButtonPanel MainStreamOperationPanel;

	// sub��Ʈ�� ���۷��̼�
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

	// operationPanel ���� �ö󰡾� �� �гε�
	private void addSubStreamPanel() {
		
		moveButtonPanel = new MoveButtonPanel(DefaultSize.subPanelWidth / 3, DefaultSize.operationPanelHeight);
		repeatPanel = new RepeatPanel(DefaultSize.operationPanelWidth / 3, DefaultSize.operationPanelHeight);
		conditionButtonPanel = new ConditionButtonPanel(DefaultSize.subPanelWidth / 3,
				DefaultSize.operationPanelHeight);


		// ������ ��ø�Ǿ�����.
		add(moveButtonPanel);
		add(conditionButtonPanel);
		add(repeatPanel);

		// ��ø�Ǿ��ֱ⶧���� visible�����������.
		showMovePanel();

	}

	// OverPanel �߰�
	private void addOverPanel() {

		overPanel = new OverPanel();

		add(overPanel);

	}

	// MovePanel Ȱ��ȭ
	public void showMovePanel() {


		getMoveButtonPanel().setVisible(true);
		getConditionButtonPanel().setVisible(false);
		getRepeatPanel().setVisible(false);

		validate();
		repaint();

	}

	// RepeatPanel Ȱ��ȭ
	public void showRepeatPanel() {


		getMoveButtonPanel().setVisible(false);
		getConditionButtonPanel().setVisible(false);
		getRepeatPanel().setVisible(true);

		validate();
		repaint();

	}

	// ConditionPanel Ȱ��ȭ
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
