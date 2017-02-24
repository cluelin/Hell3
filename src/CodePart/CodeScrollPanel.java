package CodePart;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.StyledEditorKit.BoldAction;

import GUIPackage.GUI;

public class CodeScrollPanel extends JScrollPane {

	JPanel codePanel;
	TextArea textCodeArea;

	public CodeScrollPanel() {

		addTextCodeField();
		addButtonCodeField();

	}

	private void addButtonCodeField() {
		codePanel = new JPanel();

		codePanel.setLayout(null);
		codePanel.setBackground(Color.WHITE);

		codePanel.setVisible(true);
		setViewportView(codePanel);
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

	}

	private void addTextCodeField() {
		textCodeArea = new TextArea();

		textCodeArea.setFont(new Font(COLUMN_HEADER, 0, 20));

		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		// 안보이는 상태로 스크롤뷰에 추가.
		textCodeArea.setVisible(false);

		setViewportView(textCodeArea);
	}

	public JPanel getCodePanel() {
		return codePanel;
	}

	// 패널 change.
	public void toggleCodePanel() {

		if (textCodeArea.isVisible()) {
			textCodeArea.setVisible(false);
			setViewportView(codePanel);

		} else {
			CodeMaker codeMaker = new CodeMaker();

			textCodeArea.setText(codeMaker.codeMake(GUI.mainFrame.getMainList()));
			textCodeArea.setVisible(true);
			setViewportView(textCodeArea);

		}

	}

}
