package GUIPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import CodePart.CodeScrollPanel;
import Operation.Operation;
import OperationPanel.OperationPanel;

public class GUIFrame extends JFrame {

	// �ڵ� ��ø�� ���� �����ϴ� ����
	public static int numOfButton = 0;
	public static int countOfFor = 0;

	public static boolean isForOperation = false;

	// �ڵ尡 ��ø�Ǵ� ť
	LinkedList<Operation> mainList = new LinkedList<>();
	Stack<LinkedList<Operation>> preListStack = new Stack();
	LinkedList<Operation> targetList = mainList;

	private JPanel subPanel;
	private JPanel mapPanel;
	private OperationPanel operationPanel;

	
	// �ڵ� �г�
	public JPanel codePanel;
	
	CodeScrollPanel codeScrollPanel;
	

	public void setTargetList(LinkedList<Operation> sourceList) {

		targetList = sourceList;
	}

	public LinkedList<Operation> getTargetList() {
		return targetList;
	}

	public LinkedList<Operation> getMainList() {
		return mainList;
	}


	// for ��� ����
	public void addNumOfFor() {
		countOfFor++;
		numOfButton--;
		preListStack.push(getTargetList());
	}

	public void subNumOfFor() {
		countOfFor--;
		setTargetList(preListStack.pop());
	}

	public int getNumOfFor() {
		return countOfFor;
	}

	public OperationPanel getOperationPanel(){
		return operationPanel;
	}
	
	public GUIFrame() {
		super("main frame");
		setBoundary();

		
		addCodePanel();
		addMapPanel();
		

		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}

	// �⺻���� ��輱 ����
	private void setBoundary() {

		setBounds(200, 50, 0, 0);
		getContentPane().setPreferredSize(new Dimension(DefaultSize.mainFrameWidth, DefaultSize.mainFrameHeight));
		pack();
		setLayout(new BorderLayout());
		setResizable(false);

		// ������ �����г� (operationButtonPanel + DetailOperationPanel + StartPanel+
		// CodePanl)
		subPanel = new JPanel();
		subPanel.setLayout(new BorderLayout());
		subPanel.setPreferredSize(new Dimension(DefaultSize.subPanelWidth, 0));
		subPanel.setBackground(Color.white);

		// �������� �����г� (�ڵ� ����? â)
		mapPanel = new JPanel();
		mapPanel.setLayout(new FlowLayout());
		mapPanel.setPreferredSize(new Dimension(DefaultSize.mapPanelWidth, 0));
		mapPanel.setBackground(new Color(50, 0, 0, 50));

		// ūƲ���� ���� ������ �ϼ�.
		add(subPanel, BorderLayout.WEST);
		add(mapPanel, BorderLayout.EAST);

		// ���� �г��� ���(operationButtonPanel + DetailOperationPanel + StartPanel)
		operationPanel = new OperationPanel();
		

		subPanel.add(operationPanel, BorderLayout.NORTH);

	}


	
	


	// �ڵ� �г� �߰�.
	private void addCodePanel() {

		codeScrollPanel = new CodeScrollPanel();

		codePanel = codeScrollPanel.getCodePanel();

		subPanel.add(codeScrollPanel);

	}
	
	private void addMapPanel() {

		mapPanel.add(GUI.manager.getMapPanel());
		mapPanel.setPreferredSize(new Dimension(DefaultSize.mapPanelWidth, DefaultSize.mainFrameHeight));
	}
	
	public CodeScrollPanel getCodeScrollPanel(){
		return codeScrollPanel;
	}

	// �ڵ��гο� ������ ���۷��̼��� ���õɶ����� �߰��ϴ� �۾�.
	public void addOperationButtonInCodePanel(Operation operationType) {
		JLabel operateLabel = operationType.getLabel();


		// �۾� ��ư �߰�.
		operateLabel.setBounds(100 + DefaultSize.buttonWidth * countOfFor,
				(DefaultSize.buttonHeight) * (numOfButton) + 10, DefaultSize.buttonWidth, DefaultSize.buttonHeight);


		numOfButton++;

		//Ÿ�� ť�� ���۷��̼� ����
		getTargetList().add(operationType);

		// ��ư�� �þ�� ���� �г� ũ�� Ȯ��.
		codePanel.setPreferredSize(
				new Dimension(DefaultSize.codePanelWidth, DefaultSize.buttonHeight * (numOfButton + 1)));

		//�ϼ��� ��ư �гο� ����
		codePanel.add(operateLabel);
		codePanel.updateUI();

	}
	

	public void clearCodePanel() {
		
		
		codePanel.removeAll();
		codePanel.updateUI();
	}

	public void resetList() {
		mainList.clear();
		setTargetList(getMainList());
		countOfFor = 0;
		numOfButton = 0;
		GUI.manager.getOperationData().clear();

	}



	
}
