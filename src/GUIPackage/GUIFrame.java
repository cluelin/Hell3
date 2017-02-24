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

	// 코드 중첩을 위해 존재하는 변수
	public static int numOfButton = 0;
	public static int countOfFor = 0;

	public static boolean isForOperation = false;

	// 코드가 중첩되는 큐
	LinkedList<Operation> mainList = new LinkedList<>();
	Stack<LinkedList<Operation>> preListStack = new Stack();
	LinkedList<Operation> targetList = mainList;

	private JPanel subPanel;
	private JPanel mapPanel;
	private OperationPanel operationPanel;

	
	// 코드 패널
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


	// for 계수 증가
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

	// 기본적인 경계선 설정
	private void setBoundary() {

		setBounds(200, 50, 0, 0);
		getContentPane().setPreferredSize(new Dimension(DefaultSize.mainFrameWidth, DefaultSize.mainFrameHeight));
		pack();
		setLayout(new BorderLayout());
		setResizable(false);

		// 왼쪽의 서브패널 (operationButtonPanel + DetailOperationPanel + StartPanel+
		// CodePanl)
		subPanel = new JPanel();
		subPanel.setLayout(new BorderLayout());
		subPanel.setPreferredSize(new Dimension(DefaultSize.subPanelWidth, 0));
		subPanel.setBackground(Color.white);

		// 오른쪽의 서브패널 (코드 수행? 창)
		mapPanel = new JPanel();
		mapPanel.setLayout(new FlowLayout());
		mapPanel.setPreferredSize(new Dimension(DefaultSize.mapPanelWidth, 0));
		mapPanel.setBackground(new Color(50, 0, 0, 50));

		// 큰틀에서 왼쪽 오른쪽 완성.
		add(subPanel, BorderLayout.WEST);
		add(mapPanel, BorderLayout.EAST);

		// 왼쪽 패널의 상단(operationButtonPanel + DetailOperationPanel + StartPanel)
		operationPanel = new OperationPanel();
		

		subPanel.add(operationPanel, BorderLayout.NORTH);

	}


	
	


	// 코드 패널 추가.
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

	// 코드패널에 각각의 오퍼레이션이 선택될때마다 추가하는 작업.
	public void addOperationButtonInCodePanel(Operation operationType) {
		JLabel operateLabel = operationType.getLabel();


		// 작업 버튼 추가.
		operateLabel.setBounds(100 + DefaultSize.buttonWidth * countOfFor,
				(DefaultSize.buttonHeight) * (numOfButton) + 10, DefaultSize.buttonWidth, DefaultSize.buttonHeight);


		numOfButton++;

		//타겟 큐에 오퍼레이션 삽입
		getTargetList().add(operationType);

		// 버튼이 늘어남에 따라 패널 크기 확장.
		codePanel.setPreferredSize(
				new Dimension(DefaultSize.codePanelWidth, DefaultSize.buttonHeight * (numOfButton + 1)));

		//완성한 버튼 패널에 삽입
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
